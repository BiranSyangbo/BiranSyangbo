package com.spring.practice.remote.chunking;

import com.spring.practice.es.load.dto.CompanyEsDto;
import com.spring.practice.remote.chunking.autoconfiguration.MasterRequestChannel;
import com.spring.practice.remote.chunking.autoconfiguration.MasterRepliesChannel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.TaskletStep;
import org.springframework.batch.integration.chunk.ChunkMessageChannelItemWriter;
import org.springframework.batch.integration.chunk.RemoteChunkHandlerFactoryBean;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.UUID;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class MasterConfiguration {

    final JobRepository jobRepository;
    final PlatformTransactionManager transactionManager;
    final JobLauncher jobLauncher;

    @Bean
    @MasterRequestChannel
    @ConditionalOnMissingBean
    DirectChannel request() {
        return MessageChannels.direct().get();
    }

    @Bean
    @MasterRepliesChannel
    @ConditionalOnMissingBean
    QueueChannel replies() {
        return MessageChannels.queue().get();
    }

    @Bean
    public IntegrationFlow outboundFlow(AmqpTemplate amqpTemplate,
                                        @MasterRequestChannel DirectChannel request) {
        return IntegrationFlow
                .from(request)
                .handle(Amqp.outboundAdapter(amqpTemplate).routingKey("requests"))
                .get();
    }

    @Bean
    public IntegrationFlow inboundFlow(ConnectionFactory connectionFactory,
                                       @MasterRepliesChannel QueueChannel channel) {
        return IntegrationFlow
                .from(Amqp.inboundAdapter(connectionFactory, "replies"))
                .channel(channel)
                .get();
    }

    @Bean
    public MessagingTemplate remoteChunkCompanyEsMessagingTemplate() {
        var template = new MessagingTemplate();
        template.setDefaultChannel(request());
        template.setReceiveTimeout(2000);
        return template;
    }

    @Bean
    public ItemWriter<CompanyEsDto> chunkMessageCompanyEsItemWriter(MessagingTemplate remoteChunkCompanyEsMessagingTemplate) {
        var chunkMessageChannelItemWriter = new ChunkMessageChannelItemWriter<CompanyEsDto>();
        chunkMessageChannelItemWriter.setMessagingOperations(remoteChunkCompanyEsMessagingTemplate);
        chunkMessageChannelItemWriter.setReplyChannel(replies());
        return chunkMessageChannelItemWriter;

    }

    @Bean
    public RemoteChunkHandlerFactoryBean<CompanyEsDto> remoteChunkHandlerFactoryBeanCompanyES() {
        var remote = new RemoteChunkHandlerFactoryBean<CompanyEsDto>();
        remote.setChunkWriter(chunkMessageCompanyEsItemWriter(remoteChunkCompanyEsMessagingTemplate()));
        remote.setStep(chunkTaskletStep(null));
        return remote;
    }

    @Bean
    public TaskletStep chunkTaskletStep(ItemReader<CompanyEsDto> loadDataFromDB) {
        return new StepBuilder("dataTransferStepBuilder", jobRepository)
                .<CompanyEsDto, CompanyEsDto>chunk(10, transactionManager)
                .reader(loadDataFromDB)
                .writer(chunkMessageCompanyEsItemWriter(remoteChunkCompanyEsMessagingTemplate()))
                .listener(new StepExecutionListener() {
                    @Override
                    public void beforeStep(StepExecution stepExecution) {
                        System.out.println("Started Execution");
                    }

                    @Override
                    public ExitStatus afterStep(StepExecution stepExecution) {
                        System.out.println("After step " + stepExecution.getStatus());
                        return StepExecutionListener.super.afterStep(stepExecution);
                    }
                })
                .build();
    }

    @Bean
    public Job chunkJob() {
        return new JobBuilder("chunk job", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(chunkTaskletStep(null))
                .build();
    }

    @Bean
    ApplicationRunner runner() {
        return args -> jobLauncher.run(chunkJob(), new JobParametersBuilder().addString("ID", UUID.randomUUID().toString()).toJobParameters());
    }


}

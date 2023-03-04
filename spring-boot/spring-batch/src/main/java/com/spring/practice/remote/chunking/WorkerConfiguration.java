package com.spring.practice.remote.chunking;

import com.spring.practice.remote.chunking.autoconfiguration.WorkerRepliesChannel;
import com.spring.practice.remote.chunking.autoconfiguration.WorkerRequestChannel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.batch.core.step.item.SimpleChunkProcessor;
import org.springframework.batch.integration.chunk.ChunkProcessorChunkHandler;
import org.springframework.batch.integration.chunk.ChunkRequest;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.Assert;

@Configuration
public class WorkerConfiguration {

    @Bean
    @WorkerRequestChannel
    @ConditionalOnMissingBean
    public DirectChannel workerRequest() {
        return MessageChannels
                .direct()
                .get();
    }

    @Bean
    @WorkerRepliesChannel
    @ConditionalOnMissingBean
    public DirectChannel workerReplies() {
        return MessageChannels
                .direct()
                .get();
    }

    @Bean
    public IntegrationFlow workerInboundAdaptor(ConnectionFactory connectionFactory,
                                                @WorkerRequestChannel DirectChannel channel) {
        return IntegrationFlow
                .from(Amqp.inboundAdapter(connectionFactory, "requests"))
                .channel(channel)
                .get();
    }

    @Bean
    public IntegrationFlow workerOutBoundAdaptor(AmqpTemplate amqpTemplate,
                                                 @WorkerRepliesChannel DirectChannel channel) {
        return IntegrationFlow //
                .from(channel)
                .handle(Amqp.outboundAdapter(amqpTemplate))
                .get();
    }

    @Bean
    @ServiceActivator(inputChannel = "workerRequest", outputChannel = "workerReplies")
    public ChunkProcessorChunkHandler<?> chunkProcessorChunkHandler() {
        final var chunkHandler = new ChunkProcessorChunkHandler<>();
        chunkHandler.setChunkProcessor(new SimpleChunkProcessor<>(chunkProcessor(), chunkWriter()));
        return chunkHandler;
    }

    private ItemWriter<Object> chunkWriter() {
        return chunk -> {
            System.out.println("Writer");
        };
    }

    private ItemProcessor<Object, Object> chunkProcessor() {
        return item -> item;
    }

    @Bean
    @SuppressWarnings("unchecked")
    IntegrationFlow chunkProcessorChunkHandlerIntegrationFlow(
            @WorkerRepliesChannel DirectChannel request,
            @WorkerRequestChannel DirectChannel replies,
            ChunkProcessorChunkHandler<Object> chunkProcessorChunkHandler) {
        return IntegrationFlow//
                .from(request)//
                .handle(message -> {
                    final var payload = message.getPayload();
                    if (payload instanceof ChunkRequest<?> chunkRequest) {
                        try {
                            final var chunkResponse = chunkProcessorChunkHandler.handleChunk((ChunkRequest<Object>) chunkRequest);
                            replies.send(MessageBuilder.withPayload(chunkResponse).build());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    Assert.state(payload instanceof ChunkRequest<?>, "Payload should be chunk request");
                })//
                .get();
    }
}

package com.spring.practice.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    Queue requestQueue() {
        return new org.springframework.amqp.core.Queue("requests", false);
    }

    @Bean
    Queue repliesQueue() {
        return new Queue("replies", false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("remote-chunking-exchange");
    }

    @Bean
    Binding repliesBinding(TopicExchange exchange) {
        return BindingBuilder.bind(repliesQueue()).to(exchange).with("replies");
    }

    @Bean
    Binding requestBinding(TopicExchange exchange) {
        return BindingBuilder.bind(requestQueue()).to(exchange).with("requests");
    }

}

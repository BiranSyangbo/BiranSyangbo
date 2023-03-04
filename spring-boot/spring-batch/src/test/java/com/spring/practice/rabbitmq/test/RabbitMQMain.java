package com.spring.practice.rabbitmq.test;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class RabbitMQMain {

    private static final String QUEUE_NAME = "TEST";

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("user");
        connectionFactory.setPassword("password");
        try (Connection connection = connectionFactory.newConnection()) {
            final Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            channel.basicPublish("", QUEUE_NAME, null, "Hello This is the first and test message".getBytes());
            Thread.sleep(1000);
            final String s = channel.basicConsume(QUEUE_NAME,
                    (consumerTag, message) -> System.out.println(new String(message.getBody())),
                    System.out::println);
        } catch (IOException | TimeoutException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}

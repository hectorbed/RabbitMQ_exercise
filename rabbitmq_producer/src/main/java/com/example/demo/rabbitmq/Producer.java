package com.example.demo.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Producer {

    private final String EXCHANGE_NAME = "exchange_name";
    private final String QUEUE_NAME = "rabbitmq.queue";
    private final String ROUTING_KEY = "routing_key";

    public void execute(String threadName) {
        ArrayList<String> messages = new ArrayList<>();
        messages.add(threadName + ": Message 1");
        messages.add(threadName + ": Message 2");
        messages.add(threadName + ": Message 3");
        messages.add(threadName + ": Message 4");

        messages.forEach(this::sendMessagesToRabbitMQ);
    }

    private void sendMessagesToRabbitMQ(String message) {
        ConnectionFactory factory = getConnectionFactory();
        sendMessage(message, factory);
    }

    private ConnectionFactory getConnectionFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        return factory;
    }

    private void sendMessage(String message, ConnectionFactory factory) {
        try (Connection connection = factory.newConnection()) {
            Channel channel = connection.createChannel();
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            channel.basicPublish(EXCHANGE_NAME, ROUTING_KEY, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
            channel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

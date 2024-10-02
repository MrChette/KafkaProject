package com.project.hibernate.kafkaServices;


import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.project.hibernate.entity.UserEntity;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String, UserEntity> kafkaTemplate;

    public void sendUserCreatedEvent(UserEntity user) {
        try {
            Message<UserEntity> message = MessageBuilder
                    .withPayload(user)
                    .setHeader(KafkaHeaders.TOPIC, "user-created-topic")
                    .build();

            CompletableFuture<SendResult<String, UserEntity>> future = kafkaTemplate.send(message);

            future.thenAccept(success -> {
                System.out.printf("\u001B[32mEvento de usuario creado para el usuario: %s%n\u001B[0m", user.getName()); // Verde
            }).exceptionally(failure -> {
                System.err.printf("\u001B[31mError enviando el evento de usuario a Kafka: %s%n\u001B[0m", failure.getMessage()); // Rojo
                failure.printStackTrace();
                return null;
            });
        } catch (Exception e) {
            throw new RuntimeException("Error enviando el evento a Kafka", e);
        }
    }
}


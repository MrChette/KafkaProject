package com.project.hibernate.kafkaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hibernate.entity.UserEntity;

@Service
public class KafkaProducerService {

    private static final String TOPIC = "user-created-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void sendUserCreatedEvent(UserEntity user) {
        try {
            // Convertir el objeto User a JSON
            String userJson = objectMapper.writeValueAsString(user);
            kafkaTemplate.send(TOPIC, userJson);
        } catch (Exception e) {
            throw new RuntimeException("Error serializando el objeto User", e);
        }
    }
}


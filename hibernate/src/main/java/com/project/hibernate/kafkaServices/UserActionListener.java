package com.project.hibernate.kafkaServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.hibernate.entity.UserEntity;
import com.project.hibernate.entity.UserHistoric;
import com.project.hibernate.repository.UserHistoricRepository;

@Component
public class UserActionListener {

    @Autowired
    private UserHistoricRepository userHistoricRepository;

    @Autowired
    private ObjectMapper objectMapper; // Asegúrate de inyectar ObjectMapper

    @KafkaListener(topics = "user-created-topic", groupId = "user-group")
    public void listen(String userJson) {
        try {
            // Convertir el JSON de vuelta a UserEntity
            UserEntity user = objectMapper.readValue(userJson, UserEntity.class);

            // Crear un nuevo UserHistoric basado en el User recibido
            UserHistoric historic = new UserHistoric();
            historic.setUser(user);
            historic.setTestUpdate("Usuario creado: " + user.getName());

            userHistoricRepository.save(historic);
        } catch (Exception e) {
            System.err.println("Error procesando el mensaje: " + e.getMessage());
        }
    }
}


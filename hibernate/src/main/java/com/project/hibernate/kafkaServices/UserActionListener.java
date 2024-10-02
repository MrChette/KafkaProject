package com.project.hibernate.kafkaServices;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.project.hibernate.entity.UserEntity;
import com.project.hibernate.entity.UserHistoric;
import com.project.hibernate.repository.UserHistoricRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserActionListener {

    private static final Logger logger = LoggerFactory.getLogger(UserActionListener.class);
    private final UserHistoricRepository userHistoricRepository;

    public UserActionListener(UserHistoricRepository userHistoricRepository) {
        this.userHistoricRepository = userHistoricRepository;
    }

    @KafkaListener(topics = "user-created-topic")
    public void listen(UserEntity user) {
        try {
            // Crear un nuevo UserHistoric sobre el User recibido
            UserHistoric historic = new UserHistoric(user, "Usuario creado: " + user.getName());

            userHistoricRepository.save(historic);
            logger.info("\u001B[32mUserHistoric guardado para el usuario: {}\u001B[0m", user.getName()); 
        } catch (Exception e) {
            logger.error("\u001B[31mError procesando el mensaje para el usuario: {}\u001B[0m", user.getName(), e);
        }
    }
}

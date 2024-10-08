package com.project.hibernate.kafkaServices;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.project.hibernate.commons.Commons;
import com.project.hibernate.commons.Parameters;
import com.project.hibernate.entity.MessageInboxEntity;
import com.project.hibernate.entity.UserEntity;
import com.project.hibernate.entity.UserHistoric;
import com.project.hibernate.repository.MessageInboxRepository;
import com.project.hibernate.repository.UserHistoricRepository;
import com.project.hibernate.service.MessagesService;

@Service
public class UserActionListener {
	
	@Autowired
	private MessagesService messagesService;
	
	@Autowired
	private MessageInboxRepository messageInboxRepository;
	
	@Autowired
	private Commons commons;


	private static String userCreatedMessage = "CREATED_USER_MESSAGE";
	private static final String userCreatedTopic = "user-created-topic";
	private static final Logger logger = LoggerFactory.getLogger(UserActionListener.class);    

    
	private final UserHistoricRepository userHistoricRepository;
    public UserActionListener(UserHistoricRepository userHistoricRepository) {
        this.userHistoricRepository = userHistoricRepository;
    }

    @KafkaListener(topics = userCreatedTopic, groupId = "user-group")
    public void userHistoricUserCreatedListener(UserEntity user) {
        try {
            // Crear un nuevo UserHistoric sobre el User recibido
            UserHistoric historic = new UserHistoric(user, "Usuario creado: " + user.getName());

            userHistoricRepository.save(historic);           
            
            logger.info("\u001B[32mUserHistoric guardado para el usuario: {}\u001B[0m", user.getName()); 
        } catch (Exception e) {
            logger.error("\u001B[31mError procesando el mensaje para el usuario: {}\u001B[0m", user.getName(), e);
        }
    }
    
    @KafkaListener(topics = userCreatedTopic, groupId = "user-group")
    public void messageInboxUserCreatedListener(UserEntity user) {
        try {
            
            String message = messagesService.getMessageByName(userCreatedMessage).getMessage();
            
            Map<String, String> parameters = new HashMap<>();
            parameters.put("name", user.getName());
            parameters.put("createdAt", user.getUpdatedAt().toString());
            
            String finalMessage = commons.generateMessage(message, parameters);
            
            Parameters params = new Parameters();
            MessageInboxEntity messageInbox = new MessageInboxEntity();
            messageInbox.setHeader(params.MESSAGE_INBOX_HEADER_USERCREATED);
            messageInbox.setMessage(finalMessage);
            messageInbox.setStatus(params.MESSAGE_INBOX_STATUS_WAITING);
            
            messageInboxRepository.save(messageInbox);          
            
            logger.info("\u001B[32m{}\u001B[0m", messageInbox.toString()); 
        } catch (Exception e) {
            logger.error("\u001B[31mError procesando messageInboxRepository \u001B[0m",  e.getMessage());
        }
    }
}



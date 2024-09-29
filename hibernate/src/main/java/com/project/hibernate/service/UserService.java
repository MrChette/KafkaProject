package com.project.hibernate.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hibernate.entity.UserEntity;
import com.project.hibernate.kafkaServices.KafkaProducerService;
import com.project.hibernate.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private KafkaProducerService userProducer;

	public UserEntity createUser(UserEntity user) {
		UserEntity savedUser = userRepository.save(user);
		userProducer.sendUserCreatedEvent(savedUser); // Enviar evento a Kafka
		return savedUser;
	}
}

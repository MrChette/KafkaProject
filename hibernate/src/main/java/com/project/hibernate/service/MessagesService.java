package com.project.hibernate.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.hibernate.dto.MessageModelDTO;
import com.project.hibernate.entity.MessagesModelEntity;
import com.project.hibernate.repository.MessagesModelRepository;

@Service
public class MessagesService {

	@Autowired
	private MessagesModelRepository messagesRepository;

	@Autowired
	private ModelMapper modelMapper;

	public MessageModelDTO getMessageByName(String name) {
	    List<MessagesModelEntity> messages = messagesRepository.findByName(name);

	    return messages.stream()
	                   .findFirst() 
	                   .map(message -> modelMapper.map(message, MessageModelDTO.class))
	                   .orElse(null); 
	}
}

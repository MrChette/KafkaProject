package com.project.hibernate.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.hibernate.entity.UserHistoric;
import com.project.hibernate.repository.UserHistoricRepository;

@Service
public class UserHistoricService {
	

    @Autowired
    private UserHistoricRepository userHistoricRepository;
    
    public UserHistoric createUserHistoric(UserHistoric userHistoric) {
    	return userHistoricRepository.save(userHistoric);
    }
    
}

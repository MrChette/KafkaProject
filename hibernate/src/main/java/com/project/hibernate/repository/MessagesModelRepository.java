package com.project.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hibernate.entity.MessagesInboxEntity;

@Repository
public interface MessagesModelRepository extends JpaRepository<MessagesInboxEntity, Long> {
    
	 List<MessagesInboxEntity> findByName(String name);
	
}

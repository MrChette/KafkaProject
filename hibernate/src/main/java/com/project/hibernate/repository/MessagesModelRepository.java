package com.project.hibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hibernate.entity.MessagesModelEntity;

@Repository
public interface MessagesModelRepository extends JpaRepository<MessagesModelEntity, Long> {
    
	 List<MessagesModelEntity> findByName(String name);
	
}

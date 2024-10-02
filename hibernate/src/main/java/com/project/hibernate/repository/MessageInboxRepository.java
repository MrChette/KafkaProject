package com.project.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hibernate.entity.MessageInboxEntity;

@Repository
public interface MessageInboxRepository extends JpaRepository<MessageInboxEntity, Long> {

	
}

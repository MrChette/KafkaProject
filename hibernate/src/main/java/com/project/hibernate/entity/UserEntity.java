package com.project.hibernate.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.project.hibernate.kafkaServices.UserActionListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
@EntityListeners(UserActionListener.class)
public class UserEntity {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY) 
	  private Long id;

	  @Column(name = "name", unique = true) 
	  private String name;

	  @Column(name = "isActive")
	  private Boolean  isActive;
	  
	  @Column(name = "updatedAt")
	  @CreationTimestamp
	  private LocalDateTime updatedAt;
	  
}

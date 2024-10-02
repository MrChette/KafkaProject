package com.project.hibernate.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "userHistoric")
public class UserHistoric {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne
    @JoinColumn(name = "user_id", nullable = false) // Clave foránea a User
    private UserEntity user;
	
	@Column(name = "testUpdate") 
	private String testUpdate;

	public UserHistoric(UserEntity user, String testUpdate) {
		super();
		this.user = user;
		this.testUpdate = testUpdate;
	}
	
	
}

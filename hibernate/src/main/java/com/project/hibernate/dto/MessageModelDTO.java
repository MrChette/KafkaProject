package com.project.hibernate.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MessageModelDTO {

	private Long id;
	private String name;
	private String message;
	private boolean display;
	private LocalDateTime createdAt;

}

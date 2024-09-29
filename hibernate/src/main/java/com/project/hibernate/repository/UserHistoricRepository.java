package com.project.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hibernate.entity.UserHistoric;

@Repository
public interface UserHistoricRepository extends JpaRepository<UserHistoric, Long> {
    // Métodos adicionales si es necesario
}

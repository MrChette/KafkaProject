package com.project.hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.hibernate.entity.UserEntity; // Asegúrate de que esta línea esté correcta

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    // Puedes agregar métodos personalizados aquí si lo necesitas
}

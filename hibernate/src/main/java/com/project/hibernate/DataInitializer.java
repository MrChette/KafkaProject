//package com.project.hibernate;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import com.project.hibernate.entity.UserEntity;
//import com.project.hibernate.service.UserService;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Crear un nuevo usuario
//        UserEntity user = new UserEntity();
//        user.setName("John Doe"); // Establecer los atributos del usuario
//        user.setIsActive(true);
//        // Agrega otros atributos según tu modelo User
//
//        userService.createUser(user); // Crear el usuario
//    }
//}
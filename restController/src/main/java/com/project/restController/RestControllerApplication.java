package com.project.restController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.project.hibernate")
public class RestControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestControllerApplication.class, args);
    }
}

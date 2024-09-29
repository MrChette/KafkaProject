package com.project.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.hibernate.repository")
public class SpringBootApplicationHibernate {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationHibernate.class, args);
    }
}

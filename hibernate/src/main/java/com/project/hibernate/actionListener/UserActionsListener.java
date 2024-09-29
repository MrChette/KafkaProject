package com.project.hibernate.actionListener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserActionsListener {

    private final RestTemplate restTemplate;

    public UserActionsListener(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @KafkaListener(topics = "user-actions", groupId = "user-group")
    public void listen(String message) {
        // Lógica para llamar al endpoint
        String endpointUrl = "http://tu-api-endpoint.com/user-action";

        // Aquí puedes ajustar el cuerpo de la solicitud según lo necesites
        restTemplate.postForObject(endpointUrl, message, String.class);
    }
}
package com.calendar.social.application.messaging;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaUserEventsListener {

    private static final String USER_CREATED_TOPIC = "USER_CREATED";

    @KafkaListener(topics = USER_CREATED_TOPIC)
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}

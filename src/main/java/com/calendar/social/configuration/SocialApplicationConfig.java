package com.calendar.social.configuration;

import com.calendar.social.domain.ports.RelationshipRepositoryPort;
import com.calendar.social.domain.ports.UserRepositoryPort;
import com.calendar.social.domain.services.RelationshipService;
import com.calendar.social.domain.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SocialApplicationConfig {

    @Bean
    public RelationshipService relationshipService(
            UserRepositoryPort userRepositoryPort,
            RelationshipRepositoryPort relationshipRepositoryPort) {
        return new RelationshipService(userRepositoryPort, relationshipRepositoryPort);
    }

    @Bean
    public UserService userService(UserRepositoryPort userRepositoryPort) {
        return new UserService(userRepositoryPort);
    }
}

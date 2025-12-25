package com.calendar.social.domain.services;

import com.calendar.social.domain.models.UserCreatedEventDTO;
import com.calendar.social.domain.models.UserResult;
import com.calendar.social.domain.models.UserSocialDTO;
import com.calendar.social.domain.ports.UserRepositoryPort;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

public class UserService {

    private final UserRepositoryPort userRepositoryPort;

    public UserService(UserRepositoryPort userRepositoryPort) {
        this.userRepositoryPort = userRepositoryPort;
    }

    public Mono<Void> writeUser(UserCreatedEventDTO userCreatedEventDTO) {
        return userRepositoryPort.save(userCreatedEventDTO);
    }

    public Flux<UserResult> readAllWithSocialStatus(Long userId, String friendshipsStatus) {

        if (Objects.isNull(friendshipsStatus)) return userRepositoryPort.findAllWithSocialStatus(userId).cast(UserResult.class);

        return switch (friendshipsStatus) {
            case "PENDING_INCOMING" -> userRepositoryPort.findIncomingRequests(userId).cast(UserResult.class);
            case "PENDING_OUTGOING" -> userRepositoryPort.findOutgoingRequests(userId).cast(UserResult.class);
            case "FRIENDS" -> userRepositoryPort.findAllFriends(userId).cast(UserResult.class);
            default -> Flux.empty();
        };
    }
}

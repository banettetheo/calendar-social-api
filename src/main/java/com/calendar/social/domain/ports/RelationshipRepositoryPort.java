package com.calendar.social.domain.ports;

import com.calendar.social.domain.models.RelationshipDTO;
import reactor.core.publisher.Mono;

public interface RelationshipRepositoryPort {

    Mono<RelationshipDTO> deleteFriendship(Long userId, Long friendId);
}

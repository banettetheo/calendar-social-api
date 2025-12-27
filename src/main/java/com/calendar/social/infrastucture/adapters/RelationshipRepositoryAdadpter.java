package com.calendar.social.infrastucture.adapters;

import com.calendar.social.domain.models.RelationshipDTO;
import com.calendar.social.domain.ports.RelationshipRepositoryPort;
import com.calendar.social.infrastucture.mappers.RelationshipMapper;
import com.calendar.social.infrastucture.repositories.RelationshipRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RelationshipRepositoryAdadpter implements RelationshipRepositoryPort {

    private final RelationshipRepository relationshipRepository;
    private final RelationshipMapper relationshipMapper;

    public RelationshipRepositoryAdadpter(RelationshipRepository relationshipRepository, RelationshipMapper relationshipMapper) {
        this.relationshipRepository = relationshipRepository;
        this.relationshipMapper = relationshipMapper;
    }

    public Mono<RelationshipDTO> deleteFriendship(Long userId, Long friendId) {
        return relationshipRepository.deleteFriendship(userId, friendId).map(relationshipMapper::toRelationshipDTO);
    }
}

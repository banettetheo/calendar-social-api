package com.calendar.social.infrastucture.persistence.mappers;

import com.calendar.social.domain.models.RelationshipDTO;
import com.calendar.social.infrastucture.persistence.models.entities.RelationshipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationshipMapper {

    RelationshipDTO toRelationshipDTO(RelationshipEntity relationshipEntity);
}

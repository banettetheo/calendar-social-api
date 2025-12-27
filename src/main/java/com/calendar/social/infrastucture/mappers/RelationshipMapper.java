package com.calendar.social.infrastucture.mappers;

import com.calendar.social.domain.models.RelationshipDTO;
import com.calendar.social.infrastucture.models.entities.RelationshipEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RelationshipMapper {

    RelationshipDTO toRelationshipDTO(RelationshipEntity relationshipEntity);
}

package com.calendar.social.infrastucture.repositories;

import com.calendar.social.infrastucture.models.dtos.UserSocialDBDTO;
import com.calendar.social.infrastucture.models.entities.UserNodeEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface UserNodeRepository extends ReactiveNeo4jRepository<UserNodeEntity, Long> {

    @Query("MATCH (me:User {userId: $userId})\n" +
            "MATCH (other:User) \n" +
            "WHERE other.userId <> me.userId\n" +
            "OPTIONAL MATCH (me)-[r:FRIENDSHIP]-(other)\n" +
            "RETURN DISTINCT\n" +
            "    other.userId AS userId,\n" +
            "    other.userName AS userName,\n" +
            "    other.profilePicUrl AS profilePicUrl,\n" +
            "    CASE \n" +
            "        WHEN r IS NULL THEN 'NONE'\n" +
            "        WHEN r.status = 'ACCEPTED' THEN 'FRIENDS'\n" +
            "        WHEN r.status = 'PENDING' AND startNode(r) = me THEN 'SENT_BY_ME'\n" +
            "        WHEN r.status = 'PENDING' AND startNode(r) = other THEN 'SENT_BY_THEM'\n" +
            "        ELSE 'NONE'\n" +
            "    END AS relationStatus\n" +
            "ORDER BY userName ASC")
    Flux<UserSocialDBDTO> findAllWithSocialStatus(Long userId);
}

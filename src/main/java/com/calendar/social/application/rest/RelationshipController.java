package com.calendar.social.application.rest;

import com.calendar.social.application.rest.dtos.FriendRequestDTO;
import com.calendar.social.domain.models.UserNodeDTO;
import com.calendar.social.domain.services.RelationshipService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("relationships")
public class RelationshipController {

    private final RelationshipService relationshipService;

    public RelationshipController(RelationshipService relationshipService) {
        this.relationshipService = relationshipService;
    }

    @PostMapping("request")
    public Mono<ResponseEntity<UserNodeDTO>> sendFriendRequest(@RequestHeader("X-Internal-User-Id") Long userId, @RequestBody @Valid FriendRequestDTO friendRequestDTO) {
        return relationshipService.sendFriendRequest(userId, friendRequestDTO.userTag()).map(ResponseEntity::ok);
    }

    @PutMapping("accept/{senderId}")
    public Mono<ResponseEntity<UserNodeDTO>> acceptFriendRequest(@RequestHeader("X-Internal-User-Id") Long userId, @PathVariable Long senderId) {
        return relationshipService.acceptFriendRequest(userId, senderId).map(ResponseEntity::ok);
    }

    @PutMapping("reject/{senderId}")
    public Mono<ResponseEntity<UserNodeDTO>> rejectFriendRequest(@RequestHeader("X-Internal-User-Id") Long userId, @PathVariable Long senderId) {
        return relationshipService.rejectFriendRequest(userId, senderId).map(ResponseEntity::ok);
    }

    @DeleteMapping("{friendId}")
    public Mono<Void> deleteFriendship(@RequestHeader("X-Internal-User-Id") Long userId, @PathVariable Long friendId) {
        return relationshipService.deleteFriendship(userId, friendId);
    }
}

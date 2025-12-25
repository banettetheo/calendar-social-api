package com.calendar.social.application.rest;

import com.calendar.social.domain.models.UserResult;
import com.calendar.social.domain.services.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public Flux<UserResult> readAllWithSocialStatus(
            @RequestHeader("X-Internal-User-Id") Long userId,
            @RequestParam(required = false) String friendshipStatus) {
        return userService.readAllWithSocialStatus(userId, friendshipStatus);
    }
}

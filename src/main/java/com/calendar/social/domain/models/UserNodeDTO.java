package com.calendar.social.domain.models;

public record UserNodeDTO(
        Long userId,
        String userName,
        String profilePicUrl
) implements UserResult {
}

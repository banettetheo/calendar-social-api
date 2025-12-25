package com.calendar.social.domain.models;

public record UserSocialDTO(
        Long userId,
        String userName,
        String profilePicUrl,
        String relationStatus
) implements UserResult {}
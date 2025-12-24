package com.calendar.social.infrastucture.models.dtos;

public record UserSocialDBDTO(
        Long userId,
        String userName,
        String profilePicUrl,
        String relationStatus
) {}
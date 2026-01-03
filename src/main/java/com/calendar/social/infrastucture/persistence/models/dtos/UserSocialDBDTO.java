package com.calendar.social.infrastucture.persistence.models.dtos;

public record UserSocialDBDTO(
        Long userId,
        String userName,
        String profilePicUrl,
        String relationStatus
) {}
package com.calendar.social.infrastucture.persistence.models.dtos;

public record UserSocialDBDTO(
        String userId,
        String userName,
        String profilePicUrl,
        String relationStatus
) {}
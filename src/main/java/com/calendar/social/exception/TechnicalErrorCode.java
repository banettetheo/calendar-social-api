package com.calendar.social.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum TechnicalErrorCode {

    DATABASE_ERROR("SCL_TEC_001", "Erreur lors de la communication avec la base de données");

    private final String code;
    private final String message;
}

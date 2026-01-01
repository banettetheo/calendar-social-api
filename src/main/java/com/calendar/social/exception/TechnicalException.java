package com.calendar.social.exception;

public class TechnicalException extends RuntimeException {

    private final TechnicalErrorCode errorCode;

    public TechnicalException(TechnicalErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

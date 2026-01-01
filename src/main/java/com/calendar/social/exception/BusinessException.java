package com.calendar.social.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {

    private final BusinessErrorCode errorCode;

    public BusinessException(BusinessErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

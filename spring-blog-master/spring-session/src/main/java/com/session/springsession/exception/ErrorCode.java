package com.session.springsession.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {

    AUTHENTICATION_FAILED(401, "AUTH_001", " AUTHENTICATION_FAILED."),
    LOGIN_FAILED(401, "AUTH_002", " LOGIN_FAILED.");

    private final String code;
    private final String massage;
    private int status;

    ErrorCode(final int status, final String code, final String message) {
        this.status = status;
        this.massage = message;
        this.code = code;
    }
}

package com.session.springsession.exception;

public class CustomAuthenticationException extends RuntimeException{

    public CustomAuthenticationException() {
        super(ErrorCode.AUTHENTICATION_FAILED.getMassage());
    }

    public CustomAuthenticationException(Exception ex) {
        super(ex);
    }
}

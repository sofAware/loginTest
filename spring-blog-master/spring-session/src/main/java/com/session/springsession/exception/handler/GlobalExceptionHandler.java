package com.session.springsession.exception.handler;

import com.session.springsession.exception.CommonResponse;
import com.session.springsession.exception.CustomAuthenticationException;
import com.session.springsession.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomAuthenticationException.class)
    protected ResponseEntity<CommonResponse> handleCustomAuthenticationException(CustomAuthenticationException e) {

        log.info("handleCustomAuthenticationException", e);
        // 에러 발생 시
        CommonResponse response = CommonResponse.builder()
                .code(ErrorCode.AUTHENTICATION_FAILED.getCode())
                .message(e.getMessage())
                .status(ErrorCode.AUTHENTICATION_FAILED.getStatus())
                .build();

        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
}

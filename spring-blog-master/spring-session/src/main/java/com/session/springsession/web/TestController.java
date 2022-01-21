package com.session.springsession.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// Session 기능 확인하기 위한 test session
@Slf4j // 로그 보기 위한 어노테이션
@RestController
public class TestController {

    @GetMapping("/api/v1/test")
    public String getTest(HttpSession session, HttpServletRequest httpServletRequest) {
        log.info(session.getId());

        return "test";
    }

}

package com.session.springsession.interceptor;

import com.session.springsession.domain.user.Role;
import com.session.springsession.exception.CustomAuthenticationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.session.springsession.domain.user.SecurityConstants.KEY_ROLE;

@Slf4j
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
        throws Exception {
        log.info("preHandle!!");

        // 권한이 있고, USER 권한일 경우
        if((request.getSession().getAttribute(KEY_ROLE) != null )
                && request.getSession().getAttribute(KEY_ROLE).equals(Role.USER.name())) {
            return true;
        } else {
            throw new CustomAuthenticationException();
        }
    }
}

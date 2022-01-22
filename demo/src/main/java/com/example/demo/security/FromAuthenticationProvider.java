package com.example.demo.security;

import com.example.demo.entity.UserContext;
import com.example.demo.service.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FromAuthenticationProvider implements AuthenticationProvider {
    private final CustomUserDetailsService customUserDetailsService;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();

        UserContext userContext = (UserContext) customUserDetailsService.loadUserByUsername(username);
        String passwordFromDb = userContext.getUser().getPassword();

        if (!passwordEncoder.matches(password, passwordFromDb)) {
            throw new BadCredentialsException("비밀번호가 틀립니다.");
        }

        return new UsernamePasswordAuthenticationToken(userContext.getUser(), null, userContext.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
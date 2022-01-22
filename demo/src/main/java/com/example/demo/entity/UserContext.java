package com.example.demo.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.Collections;

@Getter
public class UserContext extends User {
    private final com.example.demo.entity.User user;

    public UserContext(com.example.demo.entity.User user) {
        super(user.getUsername(), user.getPassword(), getAuthorities(user.getRole()));
        this.user = user;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(UserRole role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.getKey()));
    }
}

package com.example.demo.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserRole {
    STUDENT("ROLE_STUDENT", "학생"),
    PROFESSOR("ROLE_PROFESSOR", "교수"),
    ADMIN("ROLE_ADMIN", "관리자");

    private final String key;
    private final String title;
}

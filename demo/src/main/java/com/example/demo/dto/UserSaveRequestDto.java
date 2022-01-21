package com.example.demo.dto;

import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String username;
    private String password;
    private UserRole role;

    @Builder
    public UserSaveRequestDto(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .role(role).build();
    }
}

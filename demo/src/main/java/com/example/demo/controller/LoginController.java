package com.example.demo.controller;

import com.example.demo.dto.UserSaveRequestDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(UserSaveRequestDto requestDto) {
        userService.save(requestDto);
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}

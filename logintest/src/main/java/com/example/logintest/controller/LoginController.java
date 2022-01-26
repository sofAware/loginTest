package com.example.logintest.controller;

import com.example.logintest.dto.ProfessorDto;
import com.example.logintest.dto.StudentDto;
import com.example.logintest.service.ProfessorService;
import com.example.logintest.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class LoginController {

    //registry.addViewController("/signup").setViewName("signup");
    //registry.addViewController("/login").setViewName("login");
    //registry.addViewController("/admin").setViewName("admin");

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final ProfessorService professorService;

    //회원가입 GET
    @GetMapping("/signup")
    public String getSignup() {
        return "signup";
    }

    //회원가입 POST 요청
    @PostMapping("/signup")
    public String postSignup(@RequestParam("auth") String auth, StudentDto studentDto, ProfessorDto professorDto) {

        if(auth.equals("ROLE_STUDENT"))
            studentService.save(studentDto);
        else
            professorService.save(professorDto);

        return "redirect:/login";
    }

    //로그인
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    //학생페이지
    @GetMapping("/student")
    public String student() { return "student"; }

    //교수페이지
    @GetMapping("/professor")
    public String professor() { return "professor"; }

    @GetMapping("/logout") // logout by GET 요청
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder
                .getContext().getAuthentication());
        return "redirect:/login";
    }
}

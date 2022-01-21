package com.session.springsession.web;

import com.session.springsession.service.CoffeeService;
import com.session.springsession.web.dto.CoffeeDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    // log info
    @GetMapping("/api/v1/coffees")
    public List<CoffeeDto> getAllCoffees(HttpSession session) {
        log.info(session.getId());
        log.info(String.valueOf(session.getAttribute("email")));
        log.info(String.valueOf(session.getAttribute("role")));

        return coffeeService.findAll().orElse(Collections.emptyList());
    }
}

package com.session.springsession.service;

import com.session.springsession.domain.coffee.CoffeeUseCase;
import com.session.springsession.web.dto.CoffeeDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService implements CoffeeUseCase {
    @Override
    public Optional<List<CoffeeDto>> findAll() {
        return Optional.of(
                Arrays.asList(
                        CoffeeDto.builder()
                            .name("latte")
                            .price(2000).build(),
                        CoffeeDto.builder()
                            .name("macchiato")
                            .price(3000).build())
        );
    }
}

package com.session.springsession.domain.coffee;

import com.session.springsession.web.dto.CoffeeDto;

import java.util.List;
import java.util.Optional;

public interface CoffeeUseCase {
    Optional<List<CoffeeDto>> findAll();
}

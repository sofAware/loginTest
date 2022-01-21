package com.session.springsession.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class CoffeeDto {
    private String name;
    private int price;

    @Builder
    public CoffeeDto(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

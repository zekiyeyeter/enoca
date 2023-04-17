package com.example.enoca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerResponse {

    private Long id;
    private String name;
    private int age;
}

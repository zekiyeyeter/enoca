package com.example.enoca.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class CustomerCreateRequest {

    @NotBlank(message = "Customer name cannot be blank.")
    @NotNull(message = "Customer name cannot be null.")
    private String name;

    @Min(1)
    @Max(100)
    @NotNull(message = "Customer age cannot be null.")
    private int age;
}
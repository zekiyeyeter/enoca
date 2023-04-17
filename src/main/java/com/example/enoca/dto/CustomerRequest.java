package com.example.enoca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
public class CustomerRequest {

    @NotBlank(message = "Customer name cannot be blank.")
    @NotNull(message = "Customer name cannot be null.")
    private String name;

    @Size(min = 1,max = 100,message = "Age must be in range of [1,100]")
    private int age;


}

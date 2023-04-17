package com.example.enoca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private double totalPrice;
    private LocalDateTime createdAt;
}

package com.example.enoca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
public class OrderWithDateRequest {
    private Long customerId;
    private double totalPrice;
    private LocalDateTime createdAt;
}

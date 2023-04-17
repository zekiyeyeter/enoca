package com.example.enoca.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderRequest {

    private double totalPrice;
    private Long customerId;

}

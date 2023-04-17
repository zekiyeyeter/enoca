package com.example.enoca.mapper;

import com.example.enoca.dto.OrderRequest;
import com.example.enoca.dto.OrderResponse;
import com.example.enoca.entity.Orders;
import org.springframework.stereotype.Component;

@Component
public interface OrderMapper {

    OrderResponse entityToResponse(Orders orders);
    Orders requestToEntity(Orders target, OrderRequest source);
}

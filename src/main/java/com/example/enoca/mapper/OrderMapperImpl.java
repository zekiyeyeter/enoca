package com.example.enoca.mapper;

import com.example.enoca.dto.OrderRequest;
import com.example.enoca.dto.OrderResponse;
import com.example.enoca.entity.Customer;
import com.example.enoca.entity.Orders;
import com.example.enoca.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class OrderMapperImpl implements OrderMapper {

    private CustomerService customerService;

    @Override
    public OrderResponse entityToResponse(Orders orders) {

        return new OrderResponse(
                orders.getId(),
                orders.getTotalPrice(),
                orders.getCreatedAt()
        );
    }

    @Override
    public Orders requestToEntity(Orders target, OrderRequest source) {
        target.setTotalPrice(source.getTotalPrice());
        if (source.getCustomerId() != null) {
            Customer customer = customerService.findOneCustomer(source.getCustomerId());
            target.setCustomer(customer);
        }
        return target;
    }
}

package com.example.enoca.mapper;

import com.example.enoca.dto.CustomerCreateRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.dto.CustomerSearchResponse;
import com.example.enoca.dto.CustomerUpdateRequest;
import com.example.enoca.entity.Customer;
import com.example.enoca.entity.Orders;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerMapperImpl implements CustomerMapper {
    @Override
    public Customer updateRequestToEntity(Customer target, CustomerUpdateRequest source) {
        target.setName(source.getName());
        target.setAge(source.getAge());
        return target;
    }

    @Override
    public Customer createRequestToEntity(Customer target, CustomerCreateRequest source) {
        target.setName(source.getName());
        target.setAge(source.getAge());
        return target;
    }

    @Override
    public CustomerResponse entityToResponse(Customer customer) {
        return new CustomerResponse(
                customer.getCustomerId(),
                customer.getName(),
                customer.getAge()
        );
    }


    @Override
    public CustomerSearchResponse entityToSearchResponse(Customer customer) {
        List<Long> ordersId = customer.getOrders().stream().map(Orders::getId).collect(Collectors.toList());

        return new CustomerSearchResponse(
                customer.getCustomerId(),
                ordersId
        );
    }
}

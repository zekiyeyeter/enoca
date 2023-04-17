package com.example.enoca.mapper;

import com.example.enoca.dto.CustomerRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper{
    @Override
    public Customer requestToEntity(Customer target, CustomerRequest source) {
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


}

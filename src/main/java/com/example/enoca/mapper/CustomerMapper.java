package com.example.enoca.mapper;

import com.example.enoca.dto.CustomerRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerMapper {


    Customer requestToEntity(Customer target,CustomerRequest source);

    CustomerResponse entityToResponse(Customer customer);

}

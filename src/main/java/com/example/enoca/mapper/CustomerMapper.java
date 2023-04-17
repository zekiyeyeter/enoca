package com.example.enoca.mapper;

import com.example.enoca.dto.*;
import com.example.enoca.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public interface CustomerMapper {


    Customer createRequestToEntity(Customer target, CustomerCreateRequest source);
    Customer updateRequestToEntity(Customer target, CustomerUpdateRequest source);

    CustomerResponse entityToResponse(Customer customer);

    CustomerSearchResponse entityToSearchResponse(Customer customer);



}

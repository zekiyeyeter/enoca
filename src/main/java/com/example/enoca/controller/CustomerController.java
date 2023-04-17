package com.example.enoca.controller;

import com.example.enoca.dto.CustomerRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.mapper.CustomerMapper;
import com.example.enoca.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    @GetMapping("{customerId}")
    public CustomerResponse findOneCustomer(@PathVariable Long customerId) {
        return customerMapper.entityToResponse(customerService.findOneCustomer(customerId));
    }

    @GetMapping
    public List<CustomerResponse> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @DeleteMapping("{customerId}")
    public String deleteCustomer(@PathVariable Long customerId) {
        return customerService.deleteCustomer(customerId);
    }

    @PostMapping
    public CustomerResponse saveCustomer(@RequestBody @Valid CustomerRequest customerRequest) {
        return customerService.saveCustomer(customerRequest);
    }

    @PutMapping("{customerId}")
    public CustomerResponse updateCustomer(@RequestBody @Valid CustomerRequest customerRequest,@PathVariable Long customerId) {
        return customerService.updateCustomer(customerRequest, customerId);
    }


}

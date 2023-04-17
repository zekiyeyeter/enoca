package com.example.enoca.controller;

import com.example.enoca.dto.CustomerCreateRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.dto.CustomerSearchResponse;
import com.example.enoca.dto.CustomerUpdateRequest;
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
    public CustomerResponse saveCustomer(@RequestBody @Valid CustomerCreateRequest customerCreateRequest) {
        return customerService.saveCustomer(customerCreateRequest);
    }

    @PutMapping("{customerId}")
    public CustomerResponse updateCustomer(@RequestBody CustomerUpdateRequest customerUpdateRequest, @PathVariable Long customerId) {
        return customerService.updateCustomer(customerUpdateRequest, customerId);
    }

    @GetMapping("/no-order")
    public List<CustomerResponse> findAllByOrdersEmpty(){
        return customerService.findAllByOrdersEmpty();
    }

    @GetMapping(params = {"search"})
    public List<CustomerSearchResponse> searchForCustomer(@RequestParam String search){
        return customerService.searchForCustomer(search);
    }



}

package com.example.enoca.service;

import com.example.enoca.dto.CustomerRequest;
import com.example.enoca.dto.CustomerResponse;
import com.example.enoca.entity.Customer;
import com.example.enoca.exception.InvalidRequestException;
import com.example.enoca.exception.ResourceNotFoundException;
import com.example.enoca.mapper.CustomerMapper;
import com.example.enoca.repos.CustomerRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    private final CustomerMapper customerMapper;

     /*
        -findOneCustomer(Long id)
        -findAllCustomers()
        -deleteCustomer(Long id)
        -saveCustomer(Customer customer)
        -updateCustomer(Customer customer, Long id)
     */


    public Customer findOneCustomer(Long customerId) {
        if (customerId == null) {
            throw new InvalidRequestException("Invalid customer id!");
        }

       return customerRepo.findById(customerId).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Customer with id %s not found.", customerId)));
    }

    public List<CustomerResponse> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();

        if (allCustomers.size() == 0) {
            throw new ResourceNotFoundException("There is no customer registered yet.");
        }
        return allCustomers.stream().map(customer -> customerMapper.entityToResponse(customer)).collect(Collectors.toList());
    }

    public String deleteCustomer(Long customerId) {
        findOneCustomer(customerId); //check if the customer exists
        customerRepo.deleteById(customerId);
        return String.format("Customer with id %s is removed", customerId);
    }

    public CustomerResponse saveCustomer(CustomerRequest customerRequest) {
        if (customerRequest == null) {
            throw new InvalidRequestException("Invalid create request.");
        }
        Customer customer = customerMapper.requestToEntity(new Customer(), customerRequest);
        Customer savedCustomer = customerRepo.save(customer);
        return customerMapper.entityToResponse(savedCustomer);
    }

    public CustomerResponse updateCustomer(CustomerRequest customerRequest, Long customerId) {
        if (customerRequest == null || customerId == null) {
            throw new InvalidRequestException("Invalid update request.");
        }

        Customer customer = findOneCustomer(customerId); // found customer in db
        Customer updatedCustomer = customerMapper.requestToEntity(customer, customerRequest); // fill customers from
        Customer savedCustomer = customerRepo.save(updatedCustomer); //save filled customer to db.

        return customerMapper.entityToResponse(savedCustomer); // map saved customer to response
    }


}

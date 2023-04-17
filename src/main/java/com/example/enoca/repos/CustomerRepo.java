package com.example.enoca.repos;

import com.example.enoca.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer, Long> {


    List<Customer> findAllByOrdersEmpty();

    @Query("select c from Customer c where c.name LIKE %:search% ")
    List<Customer> searchForCustomer(String search);
}

package com.example.enoca.repos;

import com.example.enoca.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo  extends JpaRepository<Customer,Long> {




}

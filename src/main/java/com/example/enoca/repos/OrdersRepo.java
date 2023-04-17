package com.example.enoca.repos;


import com.example.enoca.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrdersRepo extends JpaRepository<Orders,Long> {

    List<Orders> findAllByCustomerCustomerId(Long customerId);
    List<Orders> findAllByCreatedAtAfter(Date createdAt );

}

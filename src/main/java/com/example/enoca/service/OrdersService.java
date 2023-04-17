package com.example.enoca.service;

import com.example.enoca.dto.OrderRequest;
import com.example.enoca.dto.OrderResponse;
import com.example.enoca.entity.Orders;
import com.example.enoca.exception.InvalidRequestException;
import com.example.enoca.exception.ResourceNotFoundException;
import com.example.enoca.mapper.OrderMapper;
import com.example.enoca.repos.OrdersRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrdersService {

    private final OrdersRepo ordersRepo;
    private final OrderMapper orderMapper;
    private final CustomerService customerService;

      /*
        -findOneOrder(Long id)
        -findAllOrders()
        -deleteOrder(Long id)
        -saveOrder(Orders order)
        -updateOrder(Order customer, Long orderId)
        -getCustomersOrders(Long customerId)
     */

    public Orders findOneOrder(Long id) {
        if (id == null) {
            throw new InvalidRequestException("Invalid order id!");
        }
        return ordersRepo.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(String.format("Order with id %s not found.", id)));

    }

    public List<OrderResponse> getAllOrders() {
        List<Orders> allOrders = ordersRepo.findAll();

        if (allOrders.size() == 0) {
            throw new ResourceNotFoundException("There is no order.");
        }
        return allOrders.stream().map(order ->
                orderMapper.entityToResponse(order)).collect(Collectors.toList());
    }

    public String deleteOrder(Long orderId){
        findOneOrder(orderId);
        ordersRepo.deleteById(orderId);
        return String.format("Order with id %s is removed", orderId);
    }

    public OrderResponse saveOrder(OrderRequest orderRequest){
        if (orderRequest == null) {
            throw new InvalidRequestException("Invalid create request.");
        }
        Orders order = orderMapper.requestToEntity(new Orders(), orderRequest);
        Orders savedOrder = ordersRepo.save(order);
        return orderMapper.entityToResponse(savedOrder);
    }

    public OrderResponse updateOrder(OrderRequest orderRequest, Long orderId){
        if (orderRequest == null || orderId == null) {
            throw new InvalidRequestException("Invalid update request.");
        }
        Orders order = findOneOrder(orderId);
        Orders updatedOrder = orderMapper.requestToEntity(order, orderRequest);
        Orders savedOrder = ordersRepo.save(updatedOrder);
        return orderMapper.entityToResponse(savedOrder);
    }

    public List<OrderResponse> getCustomersOrders(Long customerId){
        customerService.findOneCustomer(customerId); //check whether customer exists.
        List<Orders> allOrders = ordersRepo.findAllByCustomerCustomerId(customerId);
        if (allOrders.size() == 0) {
            throw new ResourceNotFoundException("There is no order.");
        }
        return allOrders.stream().map(order ->
                orderMapper.entityToResponse(order)).collect(Collectors.toList());

    }


    public List<Orders> getOrderListAfterDate( Date createdAt) {
        List<Orders> ordersByCreatedAtAfter = ordersRepo.findOrdersByCreatedAtAfter(createdAt);
        if(ordersByCreatedAtAfter.size()==0) {
            throw new ResourceNotFoundException("bu tarihten önce olan order liste bulunamadı");
        }
        return ordersByCreatedAtAfter;
        }
    }


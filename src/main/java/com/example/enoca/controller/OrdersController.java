package com.example.enoca.controller;

import com.example.enoca.dto.OrderRequest;
import com.example.enoca.dto.OrderResponse;
import com.example.enoca.entity.Orders;
import com.example.enoca.mapper.OrderMapper;
import com.example.enoca.service.OrdersService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;


import java.util.Date;

import java.util.List;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrdersController {

    private final OrdersService ordersService;
    private final OrderMapper orderMapper;
      /*
        -findOneOrder(Long id)
        -findAllOrders()
        -deleteOrder(Long id)
        -saveOrder(Orders order)
        -updateOrder(Order customer, Long orderId)
        -getCustomersOrders(Long customerId)
     */

    @GetMapping("{orderId}")
    public OrderResponse findOneOrder(@PathVariable Long orderId) {
        Orders order = ordersService.findOneOrder(orderId);
        return orderMapper.entityToResponse(order);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return ordersService.getAllOrders();
    }

    @DeleteMapping("{orderId}")
    public String deleteOrder(@PathVariable Long orderId) {
        return ordersService.deleteOrder(orderId);
    }

    @PostMapping
    public OrderResponse saveOrder(@RequestBody OrderRequest orderRequest) {
        return ordersService.saveOrder(orderRequest);
    }

    @PutMapping("{orderId}")
    public OrderResponse updateOrder(@RequestBody OrderRequest orderRequest, @PathVariable Long orderId) {
        return ordersService.updateOrder(orderRequest, orderId);
    }

    @GetMapping(params = {"customerId"})
    public List<OrderResponse> getCustomersOrders(@RequestParam("customerId") Long customerId) {
        return ordersService.getCustomersOrders(customerId);
    }
    @GetMapping (params = {"created-at"})
    public List<OrderResponse> getOrderListAfterDate(@RequestParam("created-at")@DateTimeFormat(pattern="dd-MM-yyyy") Date createdAt) {
        return ordersService.getOrderListAfterDate(createdAt);
    }
}

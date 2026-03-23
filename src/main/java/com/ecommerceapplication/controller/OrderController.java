package com.ecommerceapplication.controller;


import com.ecommerceapplication.entity.Order;
import com.ecommerceapplication.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //placeorder
    @PostMapping("/{userId}")
    public Order placeOrder(@PathVariable int userId){
        return orderService.placeOrder(userId);
    }

    //getorders
    @GetMapping("/{userId}")
    public List<Order> getOrder(@PathVariable int userId){
        return orderService.getOrders(userId);
    }





}

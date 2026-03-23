package com.ecommerceapplication.repository;

import com.ecommerceapplication.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findByUserId(int userId);
}

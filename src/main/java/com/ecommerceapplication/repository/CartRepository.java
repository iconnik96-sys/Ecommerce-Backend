package com.ecommerceapplication.repository;

import com.ecommerceapplication.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<Cart,Integer> {

    public List<Cart> findByUserId(int userId);
    public Cart findByUserIdAndProductId(int userId,int productId);
}

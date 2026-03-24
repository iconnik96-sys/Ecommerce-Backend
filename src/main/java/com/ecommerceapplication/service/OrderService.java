package com.ecommerceapplication.service;

import com.ecommerceapplication.entity.Cart;
import com.ecommerceapplication.entity.Order;
import com.ecommerceapplication.entity.Product;
import com.ecommerceapplication.repository.CartRepository;
import com.ecommerceapplication.repository.OrderRepository;
import com.ecommerceapplication.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Order placeOrder( int userId){
        //get cart
        List<Cart> cartitems = cartRepository.findByUserId(userId);

        if (cartitems.isEmpty()){
            throw new RuntimeException("Cart is empty");
        }
            double total =0;
        for(Cart items:cartitems){

            Product product = productRepository.findById(items.getProductId()).orElseThrow(()->new RuntimeException("Product not found"));

            total += product.getPrice()* items.getQuantity();
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("PLACED");
        order.setTotalamount(total);

        order = orderRepository.save(order);
        cartRepository.deleteAll(cartitems);
        return order;
    }

    public List<Order> getOrders(int userId) {
        return orderRepository.findByUserId(userId);
    }






}

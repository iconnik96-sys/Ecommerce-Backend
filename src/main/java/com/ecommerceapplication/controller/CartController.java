package com.ecommerceapplication.controller;


import com.ecommerceapplication.entity.Cart;
import com.ecommerceapplication.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    //Add to Cart
    @PostMapping("/add")
    public Cart addToCart(@RequestParam int userId,
                          @RequestParam int productId,
                          @RequestParam int quantity){
        return cartService.addToCart(userId,productId,quantity);
    }

    //Get Cart by userId
    @GetMapping("{userId}")
    public List<Cart> getCart(@PathVariable int userId){
        return cartService.getCart(userId);
    }

    //Delete from Cart
    @DeleteMapping("/remove/{cartId}")
    public String deleteCart(@PathVariable int cartId){
        cartService.removeFromCart(cartId);
        return "Item Removed";
    }



}

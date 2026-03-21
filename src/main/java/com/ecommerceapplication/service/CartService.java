package com.ecommerceapplication.service;


import com.ecommerceapplication.entity.Cart;
import com.ecommerceapplication.entity.Product;
import com.ecommerceapplication.repository.CartRepository;
import com.ecommerceapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;

    //Add to Cart
    public Cart addToCart(int userId,int productId,int quantity){
        Product product = productRepository.findById(productId).orElseThrow(()->new RuntimeException("Product not found"));
        Cart existing = cartRepository.findByUserIdAndProductId(userId,productId);

        if (quantity<=0) {
            throw new RuntimeException("Quantity should be more than 0");
        }

        if (product.getQuantity() < quantity){
            throw new RuntimeException("Insufficient Stock. Available Stock is : "+product.getQuantity());
        }
        if (existing!=null){
            int newquantity = existing.getQuantity()+quantity;

            if (newquantity>product.getQuantity()){
                throw new RuntimeException("Cannot Add more. Available Stock is : "+product.getQuantity());
            }

            existing.setQuantity(newquantity);
            return cartRepository.save(existing);
        }

        Cart cart = new Cart();
        cart.setUserId(userId);
        cart.setQuantity(quantity);
        cart.setProductId(productId);
        return cartRepository.save(cart);
        }

        //get Cart by User
    public List<Cart> getCart(int userId){
        return cartRepository.findByUserId(userId);
    }

    //Remove items
    public void removeFromCart(int cartId){
        Cart existing = cartRepository.findById(cartId).orElseThrow(()->new RuntimeException("You don't have this item in cart"));
         cartRepository.delete(existing);
    }






}

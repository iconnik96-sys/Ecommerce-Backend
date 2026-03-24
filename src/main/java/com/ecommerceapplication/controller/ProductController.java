package com.ecommerceapplication.controller;

import com.ecommerceapplication.entity.Product;
import com.ecommerceapplication.service.ProductService;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("https://ecommerce-frontend-bm3q.onrender.com")
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product products){
        return productService.addProduct(products);
    }

    @GetMapping
    public List<Product> getall(){
        return productService.getAll();
    }

    @GetMapping("{id}")
    public Product getbyId(@PathVariable int id){
        return productService.getbyID(id);
    }

    @DeleteMapping("{id}")
    public void deletebyID(@PathVariable int id){
        productService.deletebyId(id);
    }

}

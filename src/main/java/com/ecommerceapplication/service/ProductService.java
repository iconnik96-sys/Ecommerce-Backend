package com.ecommerceapplication.service;

import com.ecommerceapplication.entity.Product;
import com.ecommerceapplication.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    //AddProduct Method
    public Product addProduct(Product products){
        if (products.getName()==null || products.getName().isEmpty()){
            throw new RuntimeException("Name should not be empty");
        }
        if(products.getPrice()<0){
            throw new RuntimeException("Price should be greater than 0");
        }
        return productRepository.save(products);
    }

    //GetAll Method
    public List<Product> getAll(){
        return productRepository.findAll();
    }

    //GetProductByID
    public Product getbyID(int id){
        return productRepository.findById(id).orElseThrow(()->new RuntimeException("product not found"));
    }

    //DeleteProduct
    public void  deletebyId(int id){
        Product product= productRepository.findById(id).orElseThrow(()->new RuntimeException("Product not found"));
         productRepository.delete(product);
    }




}

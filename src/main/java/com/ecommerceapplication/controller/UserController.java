package com.ecommerceapplication.controller;


import com.ecommerceapplication.dto.UserrequestDTO;
import com.ecommerceapplication.entity.User;
import com.ecommerceapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping
    public User save(@RequestBody User user){
        return service.saveuser(user);
    }

    @GetMapping
    public List<User> findall(){
        return service.getallusers();
    }













}

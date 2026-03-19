package com.ecommerceapplication.service;

import com.ecommerceapplication.entity.User;
import com.ecommerceapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User saveuser(User user){
        return repository.save(user);
    }

    public List<User> getallusers(){
        return repository.findAll();
    }



}

package com.ecommerceapplication.service;

import com.ecommerceapplication.dto.UserrequestDTO;
import com.ecommerceapplication.entity.User;
import com.ecommerceapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;


    public User saveuser(User user){
        Optional<User> existing = repository.findByEmail(user.getEmail());
        if (existing.isPresent()){
            throw new RuntimeException("User already exist");
        }
        if (user.getName()==null || user.getName().isEmpty()){
            throw  new RuntimeException("Name is compulsory");
        }
        if (user.getPassword().length()<8){
            throw new RuntimeException("Password must be at least 8 characters");
        }
        return repository.save(user);
    }

    public List<User> getallusers(){
        return repository.findAll();
    }



}

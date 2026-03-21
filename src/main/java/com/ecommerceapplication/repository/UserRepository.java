package com.ecommerceapplication.repository;

import com.ecommerceapplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
Optional<User> findByEmail(String email);
}

package com.ecommerceapplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int userId;

    private String status;

    private double totalamount;



}

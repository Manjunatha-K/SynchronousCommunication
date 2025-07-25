package com.service.OrderService.Model;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private int id;
    private String name;
    private double amount;

    public Product(){

    }
    public Product(int id, String name,double amount){
        this.id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

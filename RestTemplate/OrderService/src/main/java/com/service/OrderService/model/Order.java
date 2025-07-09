package com.service.OrderService.model;


import org.springframework.stereotype.Component;

@Component
public class Order {
    Integer id;
    String name;

    public Order(){

    }
    public Order(Integer id, String name){
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

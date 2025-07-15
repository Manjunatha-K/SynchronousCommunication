package com.service.OrderService.Model;

import org.springframework.stereotype.Component;

@Component
public class Product {

    private int id;
    private String name;
    private String category;

    public Product(){

    }
    public Product(int id, String name,String category){
        this.id = id;
        this.name = name;
        this.category = category;
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

    public String getAmount() {
        return category;
    }

    public void setAmount(String amount) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

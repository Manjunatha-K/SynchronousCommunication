package com.service.OrderService.Controllers;
import com.service.OrderService.Repo.OrderRepo;
import com.service.OrderService.model.Order;
import com.service.OrderService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/OrderService")
public class OrderController {
    OrderRepo orderRepo;
    RestTemplate restTemplate;

    @Autowired
    private OrderController(OrderRepo orderRepo, RestTemplate restTemplate) {
        this.orderRepo = orderRepo;
        this.restTemplate = restTemplate;
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders() {
       ResponseEntity<List<Product>> productEntity = restTemplate.exchange(
               "http://localhost:8081/ProductService/product",
               HttpMethod.GET,
               null,
               new ParameterizedTypeReference<List<Product>>() {
               });
        System.out.println("List from product service output");
        List<Product> products = productEntity.getBody();
        products.stream().forEach(obj -> System.out.println(obj.getId() +" -- "+ obj.getName()));
       return new ResponseEntity<>(orderRepo.getAllOrders(), HttpStatus.OK);
    }

    @PostMapping("/order")
    public ResponseEntity<String> addOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderRepo.addOrder(order), HttpStatus.CREATED);
    }

    @PutMapping("/order")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderRepo.updateOrder(order), HttpStatus.CREATED);
    }

    @DeleteMapping("/order")
    public ResponseEntity<String> deleteOrder(@RequestParam("id") Integer id) {
        return new ResponseEntity<>(orderRepo.deleteOrder(id), HttpStatus.CREATED);
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product) {
        return restTemplate.postForEntity(
                "http://localhost:8081/ProductService/product",
                product,
                String.class
        );
    }

}

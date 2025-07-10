package com.service.OrderService.Controller;

import com.service.OrderService.Model.Order;
import com.service.OrderService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders(){

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
    @PostMapping("/order")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        return new ResponseEntity<>(orderService.addOrderService(order), HttpStatus.CREATED);
    }
    @PutMapping("/order")
    public ResponseEntity<Order> updateProduct(@RequestBody Order order){

        return new ResponseEntity<>(orderService.updateOrderService(order), HttpStatus.FOUND);
    }
    @DeleteMapping("/order")
    public ResponseEntity<List<Order>> deleteOrder(@RequestParam(name = "id") int id){

        return new ResponseEntity<>(orderService.deleteOrderService(id), HttpStatus.FOUND);
    }
}

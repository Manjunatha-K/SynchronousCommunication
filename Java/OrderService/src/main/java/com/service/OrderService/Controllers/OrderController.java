package com.service.OrderService.Controllers;

import com.service.OrderService.HttpConnection.ConnectionClass;
import com.service.OrderService.Repo.OrderRepo;
import com.service.OrderService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OrderService")
public class OrderController {
    OrderRepo orderRepo;
    ConnectionClass connectionClass;

    @Autowired
    private OrderController(OrderRepo orderRepo, ConnectionClass connectionClass) {
        this.orderRepo = orderRepo;
        this.connectionClass = connectionClass;
    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getAllOrders() {
        connectionClass.getHttppConnection();
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

}

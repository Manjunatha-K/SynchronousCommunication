package com.service.OrderService.Service;

import com.service.OrderService.Dao.OrderStore;
import com.service.OrderService.Model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderStore repo;
    public List<Order> getAllOrders() {
       return repo.allOrderRepo();
    }

    public Order addOrderService(Order order) {
       return repo.createOrderRepo(order);
    }

    public Order updateOrderService(Order order) {
        return repo.updateOrderRepo(order);
    }

    public List<Order> deleteOrderService(int id) {
        return  repo.deleteOrderRepo(id);
    }
}

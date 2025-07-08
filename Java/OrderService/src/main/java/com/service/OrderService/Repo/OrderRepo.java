package com.service.OrderService.Repo;

import com.service.OrderService.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@Repository
public class OrderRepo {
    HashMap<Integer, Order> map = new HashMap<>();

    public List<Order> getAllOrders() {
        List<Order> orders =  map.values().stream().map(order -> (Order) order).toList();
        if (orders.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Order List is Empty");
        else
            return orders;
    }

    public String addOrder(Order order) {
        if (map.put(order.getId(), order) == null)
            return "Order has been added successfully";
        else
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Order with ID already exists");
    }

    public Order updateOrder(Order order) {
        Order savedOrder = map.get(order.getId());
        if (savedOrder != null) {
            savedOrder.setName(order.getName());
            map.replace(order.getId(), savedOrder);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order with ID doesn't exists");
        return savedOrder;
    }

    public String deleteOrder(Integer id) {
        Order deletedOrder = map.remove(id);
        if(deletedOrder != null)
            return "Order has been deleted successfully";
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide valid Id");
    }
}

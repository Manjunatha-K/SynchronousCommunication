package com.service.OrderService.Dao;

import com.service.OrderService.Model.Order;
import com.service.OrderService.Service.OrderService;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OrderStore {
    Map<Integer, Order> store = new HashMap<>();

    public List<Order> allOrderRepo() {
        return new ArrayList<>( store.values());
    }

    public Order createOrderRepo(Order order) {
        return store.put(order.getId(), order);
    }

    public Order updateOrderRepo(Order order) {
        Map<Integer, Order> updateOrder = store.entrySet().stream()
                .filter(entry -> entry.getKey() == order.getId())
                .peek(entry -> entry.setValue(order))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return updateOrder.get(order.getId());
    }

    public List<Order> deleteOrderRepo(int id) {
        return store.entrySet().stream()
                .filter(entry -> entry.getKey() != id)
                .map(entry -> entry.getValue())
                .collect(Collectors.toSet()).stream().toList();
    }
}



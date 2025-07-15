package com.service.ProductService.Dao;

import com.service.ProductService.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ProductStore {
    Map<Integer, Product> store = new HashMap<>();
    
    public List<Product> getAllProductsRepo() {
        return  new ArrayList<>(store.values());
    }

    public Product addProductRepo(Product product) {
        return store.put(product.getId(), product);
    }

    public Product updateProductStore(Product product) {
        return store.entrySet().stream()
                .filter(entry -> entry.getKey() == product.getId())
                .peek(entry -> entry.setValue(product))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)).get(product.getId());

    }

    public List<Product> deleteProductStore(int id) {
        return store.entrySet().stream()
                .filter(entry -> entry.getKey() != id)
                .map(entry -> entry.getValue())
                .collect(Collectors.toSet()).stream().toList();
    }
}

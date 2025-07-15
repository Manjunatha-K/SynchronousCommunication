package com.service.OrderService.feignClient;

import com.service.OrderService.Model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8081/Product")
public interface ProductFeignClient {

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts();

    @PostMapping("/product")
    public ResponseEntity<Product> addProduct( @RequestBody Product product);
}

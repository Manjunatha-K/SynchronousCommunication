package com.service.ProductService.Controllers;

import com.service.ProductService.Repo.ProductRepo;
import com.service.ProductService.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ProductService")
public class ProductController {
    ProductRepo productRepo;

    @Autowired
    private ProductController(ProductRepo productRepo){
        this.productRepo = productRepo;
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>(productRepo.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return new ResponseEntity<>(productRepo.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        return new ResponseEntity<>(productRepo.updateProduct(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/product")
    public ResponseEntity<String> deleteProduct(@RequestParam("id") Integer id){
        return new ResponseEntity<>(productRepo.deleteProduct(id), HttpStatus.CREATED);
    }

}

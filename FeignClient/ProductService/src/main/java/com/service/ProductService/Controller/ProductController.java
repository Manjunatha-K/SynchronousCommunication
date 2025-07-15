package com.service.ProductService.Controller;


import com.service.ProductService.Model.Product;
import com.service.ProductService.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        return new ResponseEntity<>( productService.getAllProducts(), HttpStatus.OK);
    }
    @PostMapping("/product")
    public ResponseEntity<Product> addProduct( @RequestBody Product product){
        return new ResponseEntity<>( productService.addProductService(product), HttpStatus.CREATED);
    }
    @PutMapping("/product")
    public ResponseEntity<Product> updateproduct(@RequestBody Product product){
        return new ResponseEntity<>( productService.updateProductService(product), HttpStatus.FOUND);
    }
    @DeleteMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(@PathVariable(name = "id") int id){
        return new ResponseEntity<>( productService.deleteProductService(id), HttpStatus.FOUND);
    }
}

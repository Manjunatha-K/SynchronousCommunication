package com.service.ProductService.Repo;

import com.service.ProductService.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductRepo {
    HashMap<Integer, Product> map = new HashMap<>();

    public List<Product> getAllProducts() {
        List<Product> products =  map.values().stream().map(product -> (Product) product).toList();
        if (products.isEmpty())
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Product List is Empty");
        else
            return products;
    }

    public String addProduct(Product product) {
        if (map.put(product.getId(), product) == null)
            return "Product has been added successfully";
        else
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Product with ID already exists");
    }

    public Product updateProduct(Product product) {
        Product savedProduct = map.get(product.getId());
        if (savedProduct != null) {
            savedProduct.setName(product.getName());
            map.replace(product.getId(), savedProduct);
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with ID doesn't exists");
        return savedProduct;
    }

    public String deleteProduct(Integer id) {
        Product deletedProduct = map.remove(id);
        if(deletedProduct != null)
            return "Product has been deleted successfully";
        else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Please provide valid Id");
    }
}

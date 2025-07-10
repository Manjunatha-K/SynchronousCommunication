package com.service.ProductService.Service;

import com.service.ProductService.Dao.ProductStore;
import com.service.ProductService.Model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    
    @Autowired
    ProductStore productStore;

    public List<Product> getAllProducts() {
      return  productStore.getAllProductsRepo();
    }

    public Product addProductService(Product product) {
        return  productStore.addProductRepo(product);
    }

    public Product updateProductService(Product product) {
        return  productStore.updateProductStore(product);
    }

    public List<Product> deleteProductService(int id) {
        return  productStore.deleteProductStore(id);
    }
}

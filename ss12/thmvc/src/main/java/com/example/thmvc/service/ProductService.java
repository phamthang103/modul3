package com.example.thmvc.service;

import com.example.thmvc.model.Product;

import java.util.List;

public interface ProductService {
    List<Product>findAll();
    void addNewProduct(Product product);
    Product findProductById(int id);
    List<Product> searchProductByName(String name);
    void updateProduct(int id,Product product);
    void deleteProduct(int id);
}

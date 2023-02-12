package com.example.quan_li_sp.service;

import com.example.quan_li_sp.model.Product;

import java.util.List;

public interface ProduceService {
    List<Product>findAll();
    void save(Product product);
    void update(int id,Product product);
    void remove(int id);
    Product findById(int id);
    List<Product>searchNameProduce(String nameProduce);

}

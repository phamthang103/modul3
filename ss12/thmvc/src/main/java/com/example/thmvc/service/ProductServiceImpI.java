package com.example.thmvc.service;

import com.example.thmvc.model.Product;
import com.example.thmvc.repository.IProductRepository;
import com.example.thmvc.repository.ProductRepositoryImpI;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpI implements ProductService{
    private IProductRepository iProductRepository=new ProductRepositoryImpI();

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(iProductRepository.findAll());
    }

    @Override
    public void addNewProduct(Product product) {
iProductRepository.addNewProduct(product);
    }

    @Override
    public Product findProductById(int id) {
      return   iProductRepository.findProductById(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        return iProductRepository.searchProductByName(name);
    }

    @Override
    public void updateProduct(int id, Product product) {
iProductRepository.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(int id) {
iProductRepository.deleteProduct(id);
    }
}

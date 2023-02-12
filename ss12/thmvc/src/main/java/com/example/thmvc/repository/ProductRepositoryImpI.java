package com.example.thmvc.repository;

import com.example.thmvc.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpI implements IProductRepository{
    private static Map<Integer,Product >productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"Mec-G63",1200,"Car","Hyadai"));
        productMap.put(2,new Product(2,"Audi",1100,"Car","Duc"));
        productMap.put(3,new Product(3,"Tesla",600,"Car","My"));
        productMap.put(4,new Product(4,"ToyoTa",1500,"Car","Nhat"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void addNewProduct(Product product) {
productMap.put(product.getId(),product);
    }

    @Override
    public Product findProductById(int id) {
        return productMap.get(id);
    }

    @Override
    public List<Product> searchProductByName(String name) {
        List<Product>productList=findAll();
        List<Product>result=new ArrayList<>();
        for (Product product:productList){
            if (product.getProductName().equals(name)){
                result.add(product);
            }
        }
        return result;
    }

    @Override
    public void updateProduct(int id, Product product) {
productMap.put(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        productMap.remove(id);
    }
}

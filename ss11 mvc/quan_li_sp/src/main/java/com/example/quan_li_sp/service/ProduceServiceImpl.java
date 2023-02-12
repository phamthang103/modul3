package com.example.quan_li_sp.service;

import com.example.quan_li_sp.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProduceServiceImpl implements ProduceService{
    private static Map<Integer,Product>productMap;
    static {
        productMap=new HashMap<>();
        productMap.put(1,new Product(1,"May giat",7500));
        productMap.put(2,new Product(2,"Tu lanh",12000));
        productMap.put(3,new Product(3,"Ti vi",18000));
        productMap.put(4,new Product(4,"Ban la",2500));
        productMap.put(5,new Product(5,"May rua chen",7000));
        productMap.put(6,new Product(6,"May hut bui",4500));
}
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
productMap.put(product.getId(),product);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id,product);
    }

    @Override
    public void remove(int id) {
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {return productMap.get(id);
    }

    @Override
    public List<Product> searchNameProduce(String nameProduce) {
        List<Product>products=new ArrayList<>();
        nameProduce=nameProduce.toLowerCase();
for (Product product:productMap.values()){
    String name=product.getName().toLowerCase();
    if (name.indexOf(nameProduce)>=0){
        products.add(product);
    }
}return products;
    }
}

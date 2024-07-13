package com.fpoly.assignmentjava6.service;

import com.fpoly.assignmentjava6.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product findById(Integer id);
    void create(Product product);
    void udpate(Product product);
    void delete(Integer id);
}

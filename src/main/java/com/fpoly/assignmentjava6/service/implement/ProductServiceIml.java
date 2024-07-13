package com.fpoly.assignmentjava6.service.implement;

import com.fpoly.assignmentjava6.model.Product;
import com.fpoly.assignmentjava6.repository.ProductRepository;
import com.fpoly.assignmentjava6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceIml implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void create(Product product) {
        productRepository.save(product);
    }

    @Override
    public void udpate(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Integer id) {
        for (Product product: productRepository.findAll()){
            if(product.getId().equals(id)){
                productRepository.delete(product);
            }
        }
    }
}

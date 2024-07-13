package com.fpoly.assignmentjava6.repository;

import com.fpoly.assignmentjava6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}

package com.fpoly.assignmentjava6.service;

import com.fpoly.assignmentjava6.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();
    void crate(Category category);
    Category findById(Integer id);
    void update(Category category);
    void delete(Integer id);
    List<Category> searchCategory(String keyword);
    Page<Category> pageAll(int page);
    Page<Category> pageSearch(String keyword,int page);
}

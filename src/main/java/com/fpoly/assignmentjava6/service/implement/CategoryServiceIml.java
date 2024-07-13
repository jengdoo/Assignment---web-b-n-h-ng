package com.fpoly.assignmentjava6.service.implement;

import com.fpoly.assignmentjava6.model.Category;
import com.fpoly.assignmentjava6.repository.CategoryRepository;
import com.fpoly.assignmentjava6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceIml implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void crate(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void update(Category category) {
    categoryRepository.save(category);
    }

    @Override
    public void delete(Integer id) {
        for (Category category: categoryRepository.findAll()){
            if(category.getId().equals(id)){
                categoryRepository.delete(category);
            }
        }
    }

    @Override
    public List<Category> searchCategory(String keyword) {
        return categoryRepository.searchCategory(keyword);
    }

    @Override
    public Page<Category> pageAll(int page) {
        Pageable pageable = PageRequest.of(page-1,2);
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Page<Category> pageSearch(String keyword, int page) {
        List list = searchCategory(keyword);
        Pageable pageable = PageRequest.of(page-1,2);
        int start = (int) pageable.getOffset();
        int end = (int)  ((pageable.getOffset() + pageable.getPageSize()) > list.size() ? list.size() : pageable.getOffset() + pageable.getPageSize());
        list = list.subList(start,end);
        return new PageImpl<Category>(list,pageable,searchCategory(keyword).size());
    }
}

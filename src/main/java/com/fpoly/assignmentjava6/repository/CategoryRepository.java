package com.fpoly.assignmentjava6.repository;

import com.fpoly.assignmentjava6.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query("select c from Category c where c.categoryName like %?1%")
    List<Category> searchCategory(String keyword);
}

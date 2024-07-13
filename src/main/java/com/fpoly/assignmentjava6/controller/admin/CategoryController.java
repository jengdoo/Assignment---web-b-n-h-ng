package com.fpoly.assignmentjava6.controller.admin;

import com.fpoly.assignmentjava6.model.Category;
import com.fpoly.assignmentjava6.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @GetMapping("/category")
    public String index(Model model,@RequestParam(name = "p",defaultValue = "1") int page,@Param("keyword") String keyword){
        Page<Category> listCategory = categoryService.pageAll(page);
        if(keyword!=null){
            listCategory = categoryService.pageSearch(keyword,page);
            model.addAttribute("keyword",keyword);
        }
        model.addAttribute("totalPages",listCategory.getTotalPages());
        model.addAttribute("currentPage",page);
        model.addAttribute("listCategory",listCategory);
    return "admin/category/index";
    }
    @GetMapping("/add")
    public String createCategory(Model model){
        model.addAttribute("category",new Category());
        return "admin/category/create";
    }
    @PostMapping("/add")
    public String addCategory(@ModelAttribute("category") Category category){
        categoryService.crate(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/edit-category/{id}")
    public String edit(@PathVariable("id") Integer id, Model model){
        model.addAttribute("category",categoryService.findById(id));
        return "admin/category/update";
    }
    @PostMapping("/edit-category")
    public String udpate(@ModelAttribute("category") Category category){
        categoryService.update(category);
        return "redirect:/admin/category";
    }
    @GetMapping("/delete")
    public String delete(@RequestParam("id") Integer id){
        categoryService.delete(id);
        return "forward:/admin/category";
    }
}

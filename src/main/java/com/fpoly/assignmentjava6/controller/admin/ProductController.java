package com.fpoly.assignmentjava6.controller.admin;

import com.fpoly.assignmentjava6.model.Category;
import com.fpoly.assignmentjava6.model.Product;
import com.fpoly.assignmentjava6.service.CategoryService;
import com.fpoly.assignmentjava6.service.ProductService;
import com.fpoly.assignmentjava6.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    StorageService storageService;
    @GetMapping("/product")
    public String index(Model model){
        model.addAttribute("listProduct",productService.getAll());
        return "admin/product/index";
    }
    @GetMapping("/add-product")
    public String createProduct(Model model){
        model.addAttribute("product",new Product());
        return "admin/product/create";
    }
    @PostMapping("/add-product")
    public String addProduct(@ModelAttribute("product") Product product, @RequestParam("fileImage")MultipartFile fileImage) {
        storageService.store(fileImage);
        String fileName = fileImage.getOriginalFilename();
        product.setProductImage(fileName);
        productService.create(product);
        return "redirect:/admin/product";
    }
    @GetMapping("/update-product/{id}")
    public String detailUpdateProduct(@PathVariable("id") Integer id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "admin/product/update";
    }
    @PostMapping("/update-product")
    public String updateProduct(@ModelAttribute("product") Product product,@RequestParam("fileImage") MultipartFile fileImage) throws IOException {
        String fileName = fileImage.getOriginalFilename();
        boolean isEmpty =  fileName==null || fileName.isEmpty();
        if(!isEmpty){
            storageService.store(fileImage);
            product.setProductImage(fileName);
        }
        productService.udpate(product);
        return "redirect:/admin/product";
    }
    @ModelAttribute("lstCategory")
    public List<Category> getAllCategory(){
        return categoryService.getAll();
    }
}


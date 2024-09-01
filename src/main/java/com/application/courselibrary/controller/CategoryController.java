package com.application.courselibrary.controller;


import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.service.AuthorService;
import com.application.courselibrary.service.BookService;
import com.application.courselibrary.service.CategoryService;
import com.application.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/categories")
    public String getAllCategories(Model model){
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories",categories);
        return "categories";
    }

    @GetMapping("/update-category/{id}")
    public String getCategory(@PathVariable Long id , Model model){
        Category category = categoryService.getCategory(id);
        model.addAttribute("category",category);
        return "update-category";
    }

    @PostMapping("/save-category/{id}")
    public String saveCategory(@PathVariable Long id , Category category, BindingResult result , Model model){
        if(result.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/delete-category/{id}")
    public String deleteCategory(@PathVariable Long id , Model model){
        categoryService.removeCategory(id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "/categories";
    }

    @GetMapping("/add-category")
    public String addCategory(Category category , Model model){
        model.addAttribute("category",category);
        return "add-category";
    }

    @PostMapping("/save-category")
    public String saveAddedCategory(Category category, BindingResult result , Model model){
        if(result.hasErrors()){return "/add-category";}
        categoryService.createCategory(category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }

}

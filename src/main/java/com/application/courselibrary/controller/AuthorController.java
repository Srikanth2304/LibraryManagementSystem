package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.service.AuthorService;
import com.application.courselibrary.service.BookService;
import com.application.courselibrary.service.CategoryService;
import com.application.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/authors")
    public String getAllAuthors(Model model){
        List<Author>authors = authorService.getAllAuthors();
        model.addAttribute("authors",authors);
        return "authors";
    }

    @GetMapping("/update-author/{id}")
    public String updateAuthor(@PathVariable Long id , Model model){
        Author author = authorService.getAnAuthor(id);
        model.addAttribute("author",author);
        return "update-author";
    }

    @PostMapping("/save-author/{id}")
    public String saveAuthor(@PathVariable Long id , Author author , BindingResult result , Model model){
        if(result.hasErrors()){return "update-author";}
        authorService.updateAuthor(author);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "redirect:/authors";
    }

    @GetMapping("/delete-author/{id}")
    public String deleteAuthor(@PathVariable Long id , Model model){
        authorService.removeAuthor(id);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "authors";
    }

    @GetMapping("/add-author")
    public String createAuthor(Author author , Model model){
        model.addAttribute("author",author);
        return "add-author";
    }

    @PostMapping("/save-author")
    public String saveAddedAuthor(Author author , BindingResult result , Model model){
        if(result.hasErrors()){return "add-author";}
        authorService.createAuthor(author);
        model.addAttribute("authors",authorService.getAllAuthors());
        return "redirect:/authors";
    }
}

package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Book;
import com.application.courselibrary.entity.Category;
import com.application.courselibrary.entity.Publisher;
import com.application.courselibrary.service.AuthorService;
import com.application.courselibrary.service.BookService;
import com.application.courselibrary.service.CategoryService;
import com.application.courselibrary.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/books")
    public String getAllBooks(Model model) {
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/books/{id}")
    public String getBook(@PathVariable Long id , Model model){
        Book book = bookService.findBook(id);
        model.addAttribute("book" , book);
        return "list-book";
    }


    @GetMapping ("/update-book/{id}")
    public String updateBook(@PathVariable Long id , Model model){
       Book book = bookService.findBook(id);
       model.addAttribute("book",book);
       model.addAttribute("categories",categoryService.getAllCategories());
       model.addAttribute("authors",authorService.getAllAuthors());
       model.addAttribute("publishers",publisherService.findAllPublisers());
       return "update-book";
    }

    @PostMapping("/save-update/{id}")
    public String updateBook(@PathVariable Long id ,Book book, BindingResult result , Model model){
        if(result.hasErrors()){return "update-book";}
        bookService.updateBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }

//
    @GetMapping("/delete-book/{id}")
    public String deleteBook(@PathVariable Long id , Model model){
        bookService.removeBook(id);
        model.addAttribute("books", bookService.findAllBooks());
        return "books";
    }

    @GetMapping("/add-book")
    public String addBook(Book book ,Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        model.addAttribute("authors",authorService.getAllAuthors());
        model.addAttribute("publishers",publisherService.findAllPublisers());
        return "add-book";
    }

    @PostMapping("/save-book")
    public String saveBook(Book book, BindingResult result , Model model){
        if(result.hasErrors()){return "add-book";}
        bookService.createBook(book);
        model.addAttribute("books",bookService.findAllBooks());
        return "redirect:/books";
    }


}



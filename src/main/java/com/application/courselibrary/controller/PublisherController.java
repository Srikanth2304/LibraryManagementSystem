package com.application.courselibrary.controller;

import com.application.courselibrary.entity.Publisher;
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

import java.nio.file.Path;
import java.util.List;

@Controller
public class PublisherController {
    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PublisherService publisherService;

    @GetMapping("/publishers")
    public String getAllPublishers(Model model){
        List<Publisher> publishers = publisherService.findAllPublisers();
        model.addAttribute("publishers",publishers);
        return "publishers";
    }

    @GetMapping("/update-publisher/{id}")
    public String updatePublisher(@PathVariable Long id , Model model){
        Publisher publisher = publisherService.findPublisher(id);
        model.addAttribute("publisher",publisher);
        return "update-publisher";
    }

    @PostMapping("/save-publisher/{id}")
    public String savePublisher(Publisher publisher , BindingResult result , Model model){
        if(result.hasErrors()){return "update-publisher";}
        publisherService.updatePublisher(publisher);
        model.addAttribute("publisher",publisherService.findAllPublisers());
        return "redirect:/publishers";
    }

    @GetMapping("/delete-publisher/{id}")
    public String deletePublisher(@PathVariable Long id, Model model){
        publisherService.removePublisher(id);
        model.addAttribute("publishers",publisherService.findAllPublisers());
        return "publishers";
    }

    @GetMapping("/add-publisher")
    public String addPublisher(Publisher publisher , Model model){
        model.addAttribute("publisher",publisher);
        return "add-publisher";
    }

    @PostMapping("/save-publisher")
    public String saveAddedPublisher(Publisher publisher , BindingResult result , Model model){
        if(result.hasErrors()){return "add-publisher";}
        publisherService.createPublisher(publisher);
        model.addAttribute("publishers",publisherService.findAllPublisers());
        return "redirect:/publishers";
    }

}

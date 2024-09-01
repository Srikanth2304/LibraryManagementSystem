package com.application.courselibrary.service;

import com.application.courselibrary.entity.Book;
import com.application.courselibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public List<Book> findAllBooks(){
        return bookRepository.findAll();
    }

    public Book findBook(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public void createBook(Book book){
        bookRepository.save(book);
    }

    public void removeBook(Long id){
       Book book = bookRepository.findById(id).orElseThrow(() ->new RuntimeException("Book not found"));
       bookRepository.deleteById(id);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

}

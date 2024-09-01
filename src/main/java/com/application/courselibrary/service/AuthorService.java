package com.application.courselibrary.service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public Author getAnAuthor(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found!"));
    }

    public void createAuthor(Author author){
        authorRepository.save(author);
    }

    public void removeAuthor(Long id){
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found!"));
        authorRepository.delete(author);
    }

    public void updateAuthor(Author author){
        authorRepository.save(author);
    }
}

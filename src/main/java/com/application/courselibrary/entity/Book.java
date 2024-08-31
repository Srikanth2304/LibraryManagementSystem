package com.application.courselibrary.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "isbn",length = 50 , nullable = false , unique = true)
    private String isbn;

    @Column(name = "name",length = 50 , nullable = false )
    private String name;

    @Column(name = "description",length = 150 , nullable = false)
    private String description;

    //Relations
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BookAuthor",
        joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "AuthorId")}
    )
    private Set<Author>authors = new HashSet<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BookPublisher",
        joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "PublisherId")}
    )
    private Set<Publisher>publishers = new HashSet<Publisher>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BookCategory",
            joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "CategoryId")}
    )
    private Set<Category>categories = new HashSet<Category>();



    //Constructors

    public Book() {
    }

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    //Getters & Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }




}

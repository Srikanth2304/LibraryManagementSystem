package com.application.courselibrary.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "isbn",length = 50 , nullable = false , unique = true)
    private String isbn;

    @Column(name = "name",length = 50 , nullable = false )
    private String name;

    @Column(name = "description",length = 150 , nullable = false)
    private String description;

    public Book(String isbn, String name, String description) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
    }

    //Relations
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "BookAuthor",
        joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "AuthorId")}
    )
    private Set<Author>authors = new HashSet<Author>();

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "BookPublisher",
        joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "PublisherId")}
    )
    private Set<Publisher>publishers = new HashSet<Publisher>();

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "BookCategory",
            joinColumns = {@JoinColumn(name = "BookId")},
            inverseJoinColumns = {@JoinColumn(name = "CategoryId")}
    )
    private Set<Category>categories = new HashSet<Category>();

    private void removePublisher(Publisher publisher){
        this.publishers.remove(publisher);
        publisher.getBooks().remove(this);
    }

    public void addPublisher(Publisher publisher){
        this.publishers.add(publisher);
        publisher.getBooks().add(this);
    }

    private void removeAuthor(Author author){
        this.authors.remove(author);
        author.getBooks().remove(this);
    }

    public void addAuthor(Author author){
        this.authors.add(author);
        author.getBooks().add(this);
    }

    private void removeCategory(Category category){
        this.categories.remove(category);
        category.getBooks().remove(this);
    }

    public void addCategory(Category category){
        this.categories.add(category);
        category.getBooks().add(this);
    }
}

package com.application.courselibrary.entity;

import jakarta.persistence.*;

        import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description",length = 250 , nullable = false)
    private String description;

    @Column(name = "name",length = 100,nullable = false,unique = true)
    private String name;

    //relations
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "")
//    Set<Book>books = new HashSet<>();


    //constructors

    public Author() {
    }

    public Author(String description, String name) {
        this.description = description;
        this.name = name;
    }

    //Getters & Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.application.courselibrary.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 50 , nullable = false ,unique = true)
    private String name;

    //Realtions
    @ManyToMany(mappedBy = "categories")
    private Set<Book>books = new HashSet<Book>();

    //Constructors

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    //Getters & Setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

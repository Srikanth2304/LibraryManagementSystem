package com.application.courselibrary.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name",length = 50 , nullable = false , unique = false)
    private String name;

    //Relations
    @ManyToMany(mappedBy = "publishers")
    private Set<Book>books = new HashSet<Book>();


    //Constructor

    public Publisher() {
    }

    public Publisher(String name) {
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

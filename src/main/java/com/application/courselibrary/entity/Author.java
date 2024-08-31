package com.application.courselibrary.entity;

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
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();



}

package com.flux.flux_ex.Entity;

import org.springframework.data.annotation.Id;
public class Book {
    @Id
    private int id;
    private String name;
    private String author;
    private String description;
    
    public Book() {
    }

    public int getId() {
        return id;
    }
    public Book(int id, String name, String author, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
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
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

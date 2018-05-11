package com.hk.bookstore.Model;

import javax.persistence.*;

@Entity
public class Book{
    private int id;
    private String name;
    private BookCategory bookCategory;

    public Book() {

    }

    public Book(String name) {
        this.name = name;
    }

    public Book(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "BOOKCATEGORYID")
    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
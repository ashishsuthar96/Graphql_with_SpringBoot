package com.example.demo.controller;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class BookController {

    private BookService service;
    @Autowired
    public BookController(BookService s){
        this.service=s;
    }
    @QueryMapping("getAll")
    public List<Book> getAll() {
        return this.service.getAll();
    }


    @MutationMapping("create")
    public Book create(@Argument BookInput book){
        Book b= new Book();
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        b.setPrice(book.getPrice());
        return this.service.create(b);
    }
    @QueryMapping("get")
    public Book get(@Argument int bookId){
        return this.service.get(bookId);
    }


}
class BookInput{
    private String name;
    private String author;
    private int pages;
    private int price;

    public BookInput() {
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

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
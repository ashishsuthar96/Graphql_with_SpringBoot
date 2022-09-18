package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepo bookRepo;

    @Autowired
   public BookService(BookRepo repo){
        this.bookRepo= repo;
    }


    public Book create(Book book){
        return  this.bookRepo.save(book);
    }
    public List<Book> getAll(){
        return this.bookRepo.findAll();
    }

    public Book get(int bookId){
        return this.bookRepo.findById(bookId).orElseThrow(()-> new RuntimeException("id not present"));
    }
}

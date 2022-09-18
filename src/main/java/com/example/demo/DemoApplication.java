package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner {
	@Autowired
     private BookService service;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book b1= new Book("java","ashish", 400, 200 );
		Book b2= new Book("spring","ravi", 400, 200 );
		Book b3= new Book("react","bittu", 400, 200 );

		this.service.create(b1);
		this.service.create(b2);
		this.service.create(b3);


	}
}

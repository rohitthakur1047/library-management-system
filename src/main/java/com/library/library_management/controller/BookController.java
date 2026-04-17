package com.library.library_management.controller;

import com.library.library_management.entity.Book;
import com.library.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // ✅ ADD BOOK
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // ✅ GET ALL BOOKS
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
package com.library.library_management.service;


import com.library.library_management.entity.Book;
import com.library.library_management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public Book addBook(Book book) {
        book.setAvailable(book.getQuantity());
        return repo.save(book);
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }
}
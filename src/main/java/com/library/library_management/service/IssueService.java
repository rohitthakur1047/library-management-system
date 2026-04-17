package com.library.library_management.service;

import com.library.library_management.entity.Book;
import com.library.library_management.entity.IssuedBook;
import com.library.library_management.entity.User;
import com.library.library_management.repository.BookRepository;
import com.library.library_management.repository.IssuedBookRepository;
import com.library.library_management.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class IssueService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    // ✅ ISSUE BOOK
    public String issueBook(Long userId, Long bookId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        if (book.getQuantity() <= 0) {
            return "Book not available";
        }

        IssuedBook issuedBook = new IssuedBook();
        issuedBook.setUser(user);
        issuedBook.setBook(book);
        issuedBook.setIssueDate(LocalDate.now());
        issuedBook.setReturned(false);
        issuedBook.setFine(0.0); // IMPORTANT (SQL error fix)

        // decrease quantity
        book.setQuantity(book.getQuantity() - 1);

        issuedBookRepository.save(issuedBook);
        bookRepository.save(book);

        return "Book issued successfully";
    }

    // ✅ RETURN BOOK
    public String returnBook(Long issueId) {

        IssuedBook issuedBook = issuedBookRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        if (issuedBook.isReturned()) {
            return "Book already returned";
        }

        issuedBook.setReturned(true);
        issuedBook.setReturnDate(LocalDate.now());

        // increase quantity
        Book book = issuedBook.getBook();
        book.setQuantity(book.getQuantity() + 1);

        issuedBookRepository.save(issuedBook);
        bookRepository.save(book);

        return "Book returned successfully";
    }

    // ✅ USER DASHBOARD (Issued Books)
    public List<IssuedBook> getUserBooks(Long userId) {
        return issuedBookRepository.findByUserId(userId);
    }

    public Map<String, List<IssuedBook>> getUserDashboard(Long userId) {
        return Map.of("issuedBooks", getUserBooks(userId));
    }
}
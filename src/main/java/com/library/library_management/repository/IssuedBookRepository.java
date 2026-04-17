package com.library.library_management.repository;

import com.library.library_management.entity.IssuedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;

public interface IssuedBookRepository extends JpaRepository<IssuedBook, Long> {

    Optional<IssuedBook> findByUserIdAndBookIdAndReturnedFalse(Long userId, Long bookId);


    List<IssuedBook> findByUserIdAndReturnedFalse(Long userId); // issued books

    List<IssuedBook> findByUserIdAndReturnedTrue(Long userId);  // returned books
    List<IssuedBook> findByUserId(Long userId);
}
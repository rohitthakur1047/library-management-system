package com.library.library_management.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "issued_book")   // 🔥 IMPORTANT FIX
@Data
@NoArgsConstructor
@AllArgsConstructor

public class IssuedBook {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double fine = 0.0;

    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean returned;


    @ManyToOne
    @JoinColumn(name = "user_id")   // 🔥 MUST MATCH DB
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")   // 🔥 MUST MATCH DB
    private Book book;
}
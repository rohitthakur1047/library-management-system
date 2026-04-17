package com.library.library_management.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String category;
    private int quantity;
    private int available;
}
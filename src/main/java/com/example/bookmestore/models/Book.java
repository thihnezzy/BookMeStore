package com.example.bookmestore.models;

import com.example.bookmestore.constant.BookCondition;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer pageCount;

    @Column(nullable = false)
    private String publisher;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BookCondition condition;

    // Other fields like price, shipping fee, etc. based on your UML diagram

    @Column(nullable = true)
    private BigDecimal price;

    @Column(nullable = true)
    private BigDecimal shippingFee;


}

package com.example.bookmestore.controller;

import com.example.bookmestore.models.Book;
import com.example.bookmestore.repository.SellerRepository;
import com.example.bookmestore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seller")
public class SellerController {
    @Autowired
    private BookService bookService;

    @Autowired
    private SellerRepository sellerRepository;


}

package com.example.bookmestore.controller;

import com.example.bookmestore.dto.BookDTO;
import com.example.bookmestore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        System.out.println("Get all books");
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        BookDTO bookDTO = bookService.findBookById(id);
        return bookDTO != null ? ResponseEntity.ok(bookDTO) : ResponseEntity.notFound().build();
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<BookDTO>> searchBook(@PathVariable String keyword) {
        return ResponseEntity.ok(bookService.searchBook(keyword));
    }
}

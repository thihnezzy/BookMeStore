package com.example.bookmestore.service;

import com.example.bookmestore.dto.BookDTO;
import com.example.bookmestore.models.Book;
import com.example.bookmestore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> findAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            bookDTOs.add(convertToDTO(book));
        }
        return bookDTOs;
    }

    public BookDTO findBookById(Long id) {
        return bookRepository
                .findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    // Add methods for create, update, delete if needed

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setAuthor(book.getAuthor());
        bookDTO.setPageCount(book.getPageCount());
        bookDTO.setPublisher(book.getPublisher());
//        bookDTO.setCondition(book.getCondition().toString());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setShippingFee(book.getShippingFee());
        return bookDTO;
    }

    public List<BookDTO> searchBook(String keyword) {
        List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOs = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                bookDTOs.add(convertToDTO(book));
            }
        }
        return bookDTOs;
    }

}
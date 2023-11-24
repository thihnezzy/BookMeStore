package com.example.bookmestore.service;

import com.example.bookmestore.dto.BookDTO;
import com.example.bookmestore.models.Book;
import com.example.bookmestore.repository.BookRepository;
import com.example.bookmestore.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bookmestore.models.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private SellerRepository sellerRepository;
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
        bookDTO.setCondition(book.getCondition().toString());
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

    public Book listBook(Book book, String sellerEmail) {
        Optional<Seller> sellerOpt = sellerRepository.findByEmail(sellerEmail);
        if (sellerOpt.isPresent() && sellerOpt.get().isApproved()) {
            // The seller is approved, proceed with listing the book
            return bookRepository.save(book);
        } else {
            throw new IllegalStateException("Seller is not approved or does not exist.");
        }
    }
}
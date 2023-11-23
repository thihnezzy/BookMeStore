package com.example.bookmestore.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer pageCount;
    private String publisher;
    private String condition;
    private Number price;
    private Number shippingFee;
}

package com.example.bookmestore.dto;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private Integer pageCount;
    private String publisher;
    private String condition;
    private BigDecimal price;
    private BigDecimal shippingFee;
}

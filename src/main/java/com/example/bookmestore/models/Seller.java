package com.example.bookmestore.models;


import com.example.bookmestore.constant.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@DiscriminatorValue("SELLER")
@Setter
@Getter
public class Seller extends BaseAccount {
    private boolean isApproved = false;
//    private List<Book> sellingBooks;
    private String address;
    public Seller() {
        super();
    }


}

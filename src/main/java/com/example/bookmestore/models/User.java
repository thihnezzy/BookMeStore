package com.example.bookmestore.models;

import com.example.bookmestore.constant.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("USER")
public class User extends BaseAccount {
    public User() {
        super();
    }
    private String address;
    // Must add
}

package com.example.bookmestore.models;

import com.example.bookmestore.constant.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends BaseAccount{
    public Admin() {
        super();
    }

    public Admin(String username, String password, String email, String phone, String address, String fullName, String avatar, String role) {
        super(username, password, email, phone, address, fullName, avatar, role);
    }
}

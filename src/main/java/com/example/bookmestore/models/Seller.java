package com.example.bookmestore.models;

public class Seller extends BaseAccount {
    public Seller() {
        super();
    }

    public Seller(String username, String password, String email, String phone, String address, String fullName, String avatar, String role) {
        super(username, password, email, phone, address, fullName, avatar, role);
    }
}

package com.example.bookmestore.models;

public class User extends BaseAccount {
    public User() {
        super();
    }

    public User(String username, String password, String email, String phone, String address, String fullName, String avatar, String role) {
        super(username, password, email, phone, address, fullName, avatar, role);
    }
}

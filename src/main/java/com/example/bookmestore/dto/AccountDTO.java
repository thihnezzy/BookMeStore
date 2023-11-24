package com.example.bookmestore.dto;

import com.example.bookmestore.constant.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String address;
    private String role;
}

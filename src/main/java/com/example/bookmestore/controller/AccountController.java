package com.example.bookmestore.controller;

import com.example.bookmestore.constant.Role;
import com.example.bookmestore.dto.AccountDTO;
import com.example.bookmestore.models.BaseAccount;
import com.example.bookmestore.repository.AccountRepository;
import com.example.bookmestore.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api/auth")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @PostMapping("login")
    public ResponseEntity<BaseAccount> login(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO);
        BaseAccount account = accountService.login(accountDTO);
        return ResponseEntity.ok(account);
    }
    @PostMapping("/register")
    public ResponseEntity<BaseAccount> register(@RequestBody AccountDTO accountDTO) {
        BaseAccount account = accountService.register(accountDTO);
        return ResponseEntity.ok(account);
    }

}

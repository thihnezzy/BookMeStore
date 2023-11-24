package com.example.bookmestore.service;

import com.example.bookmestore.constant.Role;
import com.example.bookmestore.dto.AccountDTO;
import com.example.bookmestore.models.Admin;
import com.example.bookmestore.models.BaseAccount;
import com.example.bookmestore.models.Seller;
import com.example.bookmestore.models.User;
import com.example.bookmestore.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public BaseAccount register(AccountDTO accountDTO) {
        System.out.println(accountDTO);
        BaseAccount account;
        String role = accountDTO.getRole();
        switch (role) {
            case "ADMIN":
                account = new Admin();
                break;
            case "SELLER":
                account = new Seller();
                break;
            case "USER":
                account = new User();
                break;
            default:
                throw new IllegalArgumentException("Invalid role type");
        }

        account.setName(accountDTO.getName());
        account.setEmail(accountDTO.getEmail());
        account.setPassword(accountDTO.getPassword());
        account.setPhone(accountDTO.getPhone());
        return accountRepository.save(account);
    }
    public BaseAccount login(AccountDTO accountDTO) {
        BaseAccount account = accountRepository.findByEmail(accountDTO.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email/password supplied"));
        if (!account.getPassword().equals(accountDTO.getPassword())) {
            throw new IllegalArgumentException("Invalid email/password supplied");
        }
        return account;
    }
}

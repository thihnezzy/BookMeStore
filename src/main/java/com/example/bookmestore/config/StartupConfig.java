package com.example.bookmestore.config;

import com.example.bookmestore.constant.Role;
import com.example.bookmestore.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StartupConfig {
    @Bean
    CommandLineRunner initDatabase(AccountService accountService) {
        return args -> {
            accountService.createAccount("Default User", "user@example.com", "password", "1234567890", Role.USER);
            accountService.createAccount("Default Seller", "seller@example.com", "password", "9876543210", Role.SELLER);
            accountService.createAccount("Default Admin", "admin@example.com", "password", "", Role.ADMIN);
        };
    }
}

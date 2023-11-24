package com.example.bookmestore.repository;

import com.example.bookmestore.dto.AccountDTO;
import com.example.bookmestore.models.BaseAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<BaseAccount, Long> {
    Optional<BaseAccount> findByEmail(String email);
}

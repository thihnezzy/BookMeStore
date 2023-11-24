package com.example.bookmestore.repository;

import com.example.bookmestore.models.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
    @Query("SELECT s FROM Seller s WHERE s.email = :email")
    Optional<Seller> findByEmail(String email);
}

package com.example.bookmestore.service;

import com.example.bookmestore.models.Seller;
import com.example.bookmestore.repository.SellerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;
    public Seller approveSeller(String email) {
        Optional<Seller> sellerOpt = sellerRepository.findByEmail(email);
        if (sellerOpt.isPresent()) {
            Seller seller = sellerOpt.get();
            seller.setApproved(true);
            return sellerRepository.save(seller);
        } else {
            throw new EntityNotFoundException("Seller not found with email: " + email);
        }
    }

}

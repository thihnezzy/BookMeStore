package com.example.bookmestore.controller;

import com.example.bookmestore.models.Seller;
import com.example.bookmestore.dto.EmailDTO;
import com.example.bookmestore.service.SellerService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    SellerService sellerService;
    @PutMapping("/approve-seller")
    public ResponseEntity<?> approveSeller(@RequestBody EmailDTO emailDTO) {
        try {
            Seller seller = sellerService.approveSeller(emailDTO.getEmail());
            return new ResponseEntity<>("Seller with email " + emailDTO.getEmail() + " approved.", HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}

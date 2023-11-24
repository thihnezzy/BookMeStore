package com.example.bookmestore.models;

import com.example.bookmestore.constant.Role;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ADMIN")
public class Admin extends BaseAccount{
    public Admin() {
        super();
    }

}

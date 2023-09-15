package com.simplon.dvdstore.services.clients;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ClientServiceModel {
    private Optional<Long> id;
    private String firstname;
    private String lastname;
    private String address;


    public ClientServiceModel(String lastname,String firstname, String address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public ClientServiceModel(Optional<Long> id, String lastname,String firstname, String address){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
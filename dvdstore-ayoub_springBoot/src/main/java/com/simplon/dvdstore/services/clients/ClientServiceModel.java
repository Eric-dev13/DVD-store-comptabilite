package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
//@AllArgsConstructor
public class ClientServiceModel {
    private Optional<Long> id;
    private String firstname;
    private String lastname;
    private String address;
    private List<VenteRepositoryModel> achats;


    public ClientServiceModel(String firstname, String lastname, String address){
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public ClientServiceModel(Optional<Long> id, String firstname, String lastname, String address){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }
}
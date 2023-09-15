package com.simplon.dvdstore.repositories.clients;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="client")
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "address")
    private String address;

    public ClientRepositoryModel(String lastname, String firstname, String address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public ClientRepositoryModel( Long id,String lastname,String firstname,String address){
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }


}

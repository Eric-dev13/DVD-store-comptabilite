package com.simplon.dvdstore.repositories;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Entity
@Getter
@Table(name = "dvdstore")
public class DvdStoreRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="genre")
    private String genre;


    public DvdStoreRepositoryModel(String name, String genre){
        this.name = name;
        this.genre = genre;
    }


}

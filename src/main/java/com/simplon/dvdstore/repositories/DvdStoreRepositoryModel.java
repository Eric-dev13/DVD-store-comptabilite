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

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
}

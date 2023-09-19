package com.simplon.dvdstore.repositories.dvd;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@NoArgsConstructor
@Entity
@Data
@Table(name = "dvd")
public class DvdStoreRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="genre")
    private String genre;

    @Column(name="quantity")
    private int quantity;

    @Column(name="price")
    private BigDecimal price;

//    public DvdStoreRepositoryModel(String name, String genre, BigDecimal price){
//        this.name = name;
//        this.genre = genre;
//        this.price = price;
//    }

//    public DvdStoreRepositoryModel(Long id, String name, String genre, BigDecimal price){
//        this.id = id;
//        this.name = name;
//        this.genre = genre;
//        this.price = price;
//    }

    public DvdStoreRepositoryModel(String name, String genre, int quantity, BigDecimal price){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }

    public DvdStoreRepositoryModel(Long id, String name, String genre, int quantity, BigDecimal price){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }


}

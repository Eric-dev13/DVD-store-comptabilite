package com.simplon.dvdstore.repositories.dvd;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;


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
    private float price;

    @Column(name= "filename")
    private String filename;

    @OneToMany(mappedBy = "dvdStoreRepositoryModel", orphanRemoval = true)
    private Set<VenteRepositoryModel> venteRepositoryModels = new LinkedHashSet<>();

    public DvdStoreRepositoryModel(String name, String genre, int quantity, float price, String filename){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
        this.filename = filename;
    }

    public DvdStoreRepositoryModel(Long id, String name, String genre, int quantity, float price, String filename){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
        this.filename = filename;
    }


}

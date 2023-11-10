package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreServiceModel {
    private Long id;
    private String name;
    private String genre;
    private String realisateur;
    private String acteur;
    private int quantity;
    private float price;
    private String filename;
    private String synopsis;


//    public DvdStoreServiceModel(Optional<Long> id, String name, String genre, String realisateur, String acteur, int quantity, float price, String synopsis) {
//        this.id = id;
//        this.name = name;
//        this.genre = genre;
//        this.realisateur = realisateur;
//        this.acteur = acteur;
//        this.quantity = quantity;
//        this.price = price;
//        this.synopsis = synopsis;
//    }

}

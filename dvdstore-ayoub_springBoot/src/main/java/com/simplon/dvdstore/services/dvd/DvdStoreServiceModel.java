package com.simplon.dvdstore.services.dvd;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Optional;

@Data
@NoArgsConstructor
public class DvdStoreServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;
    private int quantity;
    private float price;
    private String filename;

    public DvdStoreServiceModel(String name, String genre, float price){
        this.name = name;
        this.genre = genre;
        this.price = price;
    }

    public DvdStoreServiceModel(String name, String genre, int quantity, float price){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }

    public DvdStoreServiceModel(String name, String genre, int quantity, float price, String filename){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
        this.filename = filename;
    }


    public DvdStoreServiceModel(Optional<Long> id,String name, String genre, int quantity, float price, String filename){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
        this.filename = filename;
    }


}

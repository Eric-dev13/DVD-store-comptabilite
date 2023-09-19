package com.simplon.dvdstore.services.dvd;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Optional;

@Data
@NoArgsConstructor
public class DvdStoreServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;
    private int quantity;
    private BigDecimal price;

    public DvdStoreServiceModel(String name, String genre, BigDecimal price){
        this.name = name;
        this.genre = genre;
        this.price = price;
    }


    public DvdStoreServiceModel(String name, String genre, int quantity, BigDecimal price){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }



    public DvdStoreServiceModel(Optional<Long> id,String name, String genre, int quantity, BigDecimal price){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
        this.price = price;
    }

}

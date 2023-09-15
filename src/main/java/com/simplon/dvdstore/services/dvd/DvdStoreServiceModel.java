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

    public DvdStoreServiceModel(String name, String genre){
        this.name = name;
        this.genre = genre;
    }

//    public DvdStoreServiceModel(Optional<Long> id,String name, String genre){
//        this.id = id;
//        this.name = name;
//        this.genre = genre;
//    }


    public DvdStoreServiceModel(String name, String genre, int quantity){
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
    }



    public DvdStoreServiceModel(Optional<Long> id,String name, String genre, int quantity){
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.quantity = quantity;
    }

}

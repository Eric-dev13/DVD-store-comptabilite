package com.simplon.dvdstore.services;


import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class DvdStoreServiceModel {
    private String name;
    private String genre;

    public DvdStoreServiceModel(String name, String genre){
        this.name = name;
        this.genre = genre;
    }

//    public String getName() {
//        return name;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
}

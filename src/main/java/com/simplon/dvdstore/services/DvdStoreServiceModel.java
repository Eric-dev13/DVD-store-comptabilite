package com.simplon.dvdstore.services;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class DvdStoreServiceModel {
    private Optional<Long> id;
    private String name;
    private String genre;

    public DvdStoreServiceModel(String name, String genre){
        this.name = name;
        this.genre = genre;
    }

    public DvdStoreServiceModel(Optional<Long> id, String name, String genre){
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

}

package com.simplon.dvdstore.controllers.dvd;


public record DvdStoreGetDto(
        Long id,
        String name,
        String genre,
        String realisateur,
        String acteur,
        int quantity,
        float price,
        String filename,
        String synopsis){}

package com.simplon.dvdstore.controllers.dvd;


public record DvdStoreDTO(String name, String genre, String realisateur, String acteur, int quantity, float price, String filename, String synopsis){}

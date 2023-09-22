package com.simplon.dvdstore.controllers.dvd;


public record DvdStoreGetDto(Long id, String name, String genre, int quantity, float price, String filename){}

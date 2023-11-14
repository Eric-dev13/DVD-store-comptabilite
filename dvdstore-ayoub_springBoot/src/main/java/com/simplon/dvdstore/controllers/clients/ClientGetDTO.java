package com.simplon.dvdstore.controllers.clients;

public record ClientGetDTO(
        Long id,
        String firstname,
        String lastname,
        String address) { }

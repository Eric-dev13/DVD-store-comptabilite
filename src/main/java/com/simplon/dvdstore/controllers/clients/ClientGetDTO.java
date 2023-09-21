package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.controllers.dvd.DvdStoreDtoWithOption;
import com.simplon.dvdstore.controllers.ventes.VenteGetDTO;

import java.util.Optional;

public record ClientGetDTO(Long id, String firstname, String lastname, String address) { }

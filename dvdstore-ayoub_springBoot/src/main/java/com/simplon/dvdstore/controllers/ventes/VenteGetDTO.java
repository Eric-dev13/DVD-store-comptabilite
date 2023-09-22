package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDto;

import java.time.LocalDateTime;

public record VenteGetDTO(Long id,LocalDateTime dateAchat, int quantity, float price, ClientGetDTO client, DvdStoreGetDto dvd) { }

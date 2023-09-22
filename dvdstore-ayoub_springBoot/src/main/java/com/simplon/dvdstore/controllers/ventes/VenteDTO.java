package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDto;

public record VenteDTO(int quantity, ClientGetDTO clientGetDTO, DvdStoreGetDto dvdGetDTO) { }

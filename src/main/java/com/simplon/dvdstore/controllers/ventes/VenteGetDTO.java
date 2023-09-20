package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientDTO;
import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDtoWithOption;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record VenteGetDTO(Long id,LocalDateTime dateAchat, int quantity, float price, ClientGetDTO clientGetDTO, DvdStoreDtoWithOption dvdGetDTO) { }

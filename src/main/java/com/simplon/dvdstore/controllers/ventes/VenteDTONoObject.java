package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDtoWithOption;

import java.math.BigDecimal;

public record VenteDTONoObject(int quantity, Long client, Long dvd) { }

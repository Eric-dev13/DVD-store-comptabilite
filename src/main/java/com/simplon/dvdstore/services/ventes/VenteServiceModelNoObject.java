package com.simplon.dvdstore.services.ventes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModelNoObject {
    private Optional<Long> id;
    private LocalDateTime dateAchat;
    private int quantity;
    private float price;
    private Long client;
    private Long dvd;


    // POST
    public VenteServiceModelNoObject(int quantity, Long client, Long dvd) {
        this.quantity = quantity;
        this.client = client;
        this.dvd = dvd;
    }
}


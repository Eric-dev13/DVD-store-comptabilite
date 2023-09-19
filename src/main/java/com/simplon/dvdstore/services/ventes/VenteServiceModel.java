package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.controllers.clients.ClientDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDTO;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {
    private Optional<Long> id;
    private LocalDateTime dateAchat;
    private BigDecimal price;
    private ClientServiceModel clientServiceModel;
    private DvdStoreServiceModel dvdStoreServiceModel;


    // POST
    public VenteServiceModel(BigDecimal price, ClientServiceModel clientServiceModel, DvdStoreServiceModel dvdStoreServiceModel) {
        this.price = price;
        this.clientServiceModel = clientServiceModel;
        this.dvdStoreServiceModel = dvdStoreServiceModel;
    }

    // GET

//    public VenteServiceModel(Optional<Long> id, LocalDateTime dateAchat, BigDecimal price, ClientServiceModel clientServiceModel, DvdStoreServiceModel dvdStoreServiceModel) {
//        this.id = id;
//        this.dateAchat = dateAchat;
//        this.price = price;
//        this.clientServiceModel = clientServiceModel;
//        this.dvdStoreServiceModel = dvdStoreServiceModel;
//    }
}

package com.simplon.dvdstore.cart.controller.dto;

import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;

public record PanierDvdDto(Long id,
                           Long dvdId,
                           int dvdQuantity,
                           Float dvdPrice,
                           PanierRepositoryModel panier) {

}

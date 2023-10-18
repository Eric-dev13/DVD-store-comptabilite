package com.simplon.dvdstore.repositories.feignclient.dto;


public record PanierDvdDto(Long id,
                           Long dvdId,
                           int dvdQuantity,
                           Float dvdPrice
                           //PanierRepositoryModel panier
) {

}

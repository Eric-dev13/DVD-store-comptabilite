package com.simplon.dvdstore.cart.service.model;


import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;

public record PanierDvdServiceModel(Long id,
                                    Long dvdId,
                                    int dvdQuantity,
                                    Float dvdPrice,
                                    PanierRepositoryModel panier
                                    ) { }


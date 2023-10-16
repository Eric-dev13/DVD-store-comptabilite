package com.simplon.dvdstore.cart.service;

import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import org.mapstruct.factory.Mappers;

public interface PanierDvdServiceMapper {
    PanierDvdServiceMapper INSTANCE = Mappers.getMapper(PanierDvdServiceMapper.class);

    /* POST ET PUT --->  ---> */
    PanierDvdServiceMapper toRepository(PanierServiceModel panierServiceModel);

    /* <--- <--- GET ALL et GET ONE */
    PanierServiceModel toService(PanierDvdServiceMapper panierDvdServiceMapper);
}

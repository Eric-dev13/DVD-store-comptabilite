package com.simplon.dvdstore.cart.service.mapper;

import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierServiceMapper {
    PanierServiceMapper INSTANCE = Mappers.getMapper(PanierServiceMapper.class);

    /* POST ET PUT --->  ---> */
    PanierRepositoryModel toRepository(PanierServiceModel panierServiceModel);

    /* <--- <--- GET ALL et GET ONE */
    PanierServiceModel toService(PanierRepositoryModel panierRepositoryModel);
}

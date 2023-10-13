package com.simplon.dvdstore.cart.service;

import com.simplon.dvdstore.cart.controller.PanierDto;
import com.simplon.dvdstore.cart.controller.PanierDtoMapper;
import com.simplon.dvdstore.cart.controller.PanierGetDto;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
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

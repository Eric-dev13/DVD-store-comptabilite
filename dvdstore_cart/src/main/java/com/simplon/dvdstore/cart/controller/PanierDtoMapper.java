package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.service.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierDtoMapper {
    PanierDtoMapper INSTANCE = Mappers.getMapper(PanierDtoMapper.class);

    /* POST ET PUT --->  ---> */
    PanierServiceModel toService(PanierDto panierDto);

    /* <--- <--- GET ALL et GET ONE */
    PanierGetDto toDto(PanierServiceModel panierServiceModel);
}

package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.controller.dto.PanierDto;
import com.simplon.dvdstore.cart.service.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierDvdDtoMapper {
    PanierDvdDtoMapper INSTANCE = Mappers.getMapper(PanierDvdDtoMapper.class);

    /* POST ET PUT --->  ---> */
    PanierServiceModel toService(PanierDto panierDto);

    /* <--- <--- GET ALL et GET ONE */
//    PanierGetDto toDto(PanierDvdServiceModel panierServiceModel);
}

package com.simplon.dvdstore.cart.controller.mapper;

import com.simplon.dvdstore.cart.controller.dto.PanierDvdDto;
import com.simplon.dvdstore.cart.service.model.PanierDvdServiceModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierDvdDtoMapper {
    PanierDvdDtoMapper INSTANCE = Mappers.getMapper(PanierDvdDtoMapper.class);

    /* POST ET PUT --->  ---> */
    PanierDvdServiceModel toService(PanierDvdDto panierDvdDto);

    /* <--- <--- GET ALL et GET ONE */

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PanierDvdServiceModel partialUpdate(PanierDvdDto panierDvdDto, @MappingTarget PanierDvdServiceModel panierDvdServiceModel);
}

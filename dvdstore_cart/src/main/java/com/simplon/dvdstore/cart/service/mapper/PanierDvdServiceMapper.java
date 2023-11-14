package com.simplon.dvdstore.cart.service.mapper;

import com.simplon.dvdstore.cart.controller.dto.PanierDto;
import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.service.model.PanierDvdServiceModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PanierDvdServiceMapper {
    PanierDvdServiceMapper INSTANCE = Mappers.getMapper(PanierDvdServiceMapper.class);

    /* POST ET PUT --->  ---> */
    PanierDvdRepositoryModel toRepository(PanierDvdServiceModel panierDvdServiceModel);

    /* <--- <--- GET ALL et GET ONE */
    PanierDvdServiceModel toService(PanierDvdRepositoryModel panierDvdRepositoryModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    PanierDvdRepositoryModel partialUpdate(PanierDvdServiceModel panierDvdServiceModel, @MappingTarget PanierDvdRepositoryModel panierDvdRepositoryModel);
}

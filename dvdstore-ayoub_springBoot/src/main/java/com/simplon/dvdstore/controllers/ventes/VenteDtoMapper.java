package com.simplon.dvdstore.controllers.ventes;


import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import com.simplon.dvdstore.services.ventes.VenteServiceModelNoObject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface VenteDtoMapper {
    VenteDtoMapper INSTANCE = Mappers.getMapper(VenteDtoMapper.class);

    // POST ET PUT
    VenteServiceModelNoObject venteGetDtoToVenteServiceModel(VenteDTO venteDTO);

    // GET ALL et GET ONE
    @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType")
    VenteGetDTO venteServiceModelToVenteGetDTO(VenteServiceModel venteServiceModel);

    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }

//    @Named("typeToOptional")
//    default <T> Optional<T> typeToOptional(T source) throws Exception {
//        return Optional.ofNullable(source);
//    }
}

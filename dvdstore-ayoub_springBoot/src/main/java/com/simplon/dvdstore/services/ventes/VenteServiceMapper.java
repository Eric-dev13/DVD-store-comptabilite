package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface VenteServiceMapper {
    VenteServiceMapper INSTANCE = Mappers.getMapper(VenteServiceMapper.class);

    // POST ET PUT
    @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType")
    VenteRepositoryModel venteServiceModelNoObjectToVenteRepositoryModel (VenteServiceModelNoObject venteServiceModelNoObject);

    // GET ALL et GET ONE
    @Mapping(source = "id", target = "id", qualifiedByName = "typeToOptional")
    VenteServiceModel venteRepositoryModelToVenteServiceModel(VenteRepositoryModel venteRepositoryModel);

    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }

    @Named("typeToOptional")
    default <T> Optional<T> typeToOptional(T source) throws Exception {
        return Optional.ofNullable(source);
    }
}

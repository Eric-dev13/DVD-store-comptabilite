package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface DvdDtoMapper {

    DvdDtoMapper INSTANCE = Mappers.getMapper(DvdDtoMapper.class);

    // POST ET PUT
    @Mapping(source = "filename", target = "filename", qualifiedByName = "typeToOptional")
    DvdStoreServiceModel dvdGetDTOToDvdServiceModel(DvdStoreDTO dvdStoreDTO);

    // GET ALL et GET ONE
    @Mappings({
        @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType"),
        @Mapping(source = "filename", target = "filename", qualifiedByName = "optionalToType")
    })
    DvdStoreGetDto dvdServiceModelToDvdGetDTO(DvdStoreServiceModel dvdStoreServiceModel);

    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }

    @Named("typeToOptional")
    default <T> Optional<T> typeToOptional(T source) throws Exception {
        return Optional.ofNullable(source);
    }
}

package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface DvdDtoMapper {

    DvdDtoMapper INSTANCE = Mappers.getMapper(DvdDtoMapper.class);

    // POST ET PUT
    DvdStoreServiceModel dvdGetDTOToDvdServiceModel(DvdStoreDTO dvdStoreDTO);

    // GET ALL et GET ONE
    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    DvdStoreGetDto dvdServiceModelToDvdGetDTO(DvdStoreServiceModel dvdStoreServiceModel);

    @Named("optionalLongToLong")
    default Long optionalLongToLong(Optional<Long> source) throws Exception {
        if (source == null) {
            return null;
            //throw new Exception("Id is null");
        }
        return source.get();
    }
}

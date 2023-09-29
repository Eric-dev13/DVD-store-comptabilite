package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface DvdServiceMapper {
    DvdServiceMapper INSTANCE = Mappers.getMapper(DvdServiceMapper.class);

    // POST ET PUT
    @Mappings({
    @Mapping(source = "id", target = "id", qualifiedByName = "optionalToType"),
    @Mapping(source = "filename", target = "filename", qualifiedByName = "optionalToType")
    })
    DvdStoreRepositoryModel dvdStoreServiceModelToDvdStoreRepositoryModel (DvdStoreServiceModel dvdStoreServiceModel);

    // GET ALL et GET ONE
    @Mappings({
    @Mapping(source = "id", target = "id", qualifiedByName = "typeToOptional"),
    @Mapping(source = "filename", target = "filename", qualifiedByName = "typeToOptional")
    })
    DvdStoreServiceModel DvdStoreRepositoryModelToDvdStoreServiceModel(DvdStoreRepositoryModel dvdStoreRepositoryModel);

    @Named("optionalToType")
    default <T> T optionalToType(Optional<T> source) throws Exception {
        return source.orElse(null);
    }

    @Named("typeToOptional")
    default <T> Optional<T> typeToOptional(T source) throws Exception {
        return Optional.ofNullable(source);
    }

}

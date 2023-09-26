package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface DvdServiceMapper {
    DvdServiceMapper INSTANCE = Mappers.getMapper(DvdServiceMapper.class);

    // POST ET PUT
    @Mapping(source = "id", target = "id", qualifiedByName = "optionalLongToLong")
    DvdStoreRepositoryModel dvdStoreServiceModelToDvdStoreRepositoryModel (DvdStoreServiceModel dvdStoreServiceModel);

    // GET ALL et GET ONE
    @Mapping(source = "id", target = "id", qualifiedByName = "LongToOptionalLong")
    DvdStoreServiceModel DvdStoreRepositoryModelToDvdStoreServiceModel(DvdStoreRepositoryModel dvdStoreRepositoryModel);


    @Named("optionalLongToLong")
    default Long optionalLongToLong(Optional<Long> source) throws Exception {
        if (source == null) {
            return null;
            //throw new Exception("Id is null");
        }
        return source.get();
    }

    @Named("LongToOptionalLong")
    default Optional<Long> LongToOptionalLong(Long source) throws Exception {
        if (source == null) {
            throw new Exception("Id is null");
        }
        return Optional.ofNullable(source);
    }
}

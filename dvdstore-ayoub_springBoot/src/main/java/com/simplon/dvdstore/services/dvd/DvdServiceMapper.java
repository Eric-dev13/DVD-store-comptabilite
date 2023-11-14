package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DvdServiceMapper {
    DvdStoreServiceModel toServiceModel(DvdStoreRepositoryModel dvdStoreRepositoryModel);

    DvdStoreRepositoryModel toRepositoryModel(DvdStoreServiceModel dvdStoreServiceModel);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DvdStoreServiceModel partialUpdate(DvdStoreRepositoryModel dvdStoreRepositoryModel, @MappingTarget DvdStoreServiceModel dvdStoreServiceModel);
}
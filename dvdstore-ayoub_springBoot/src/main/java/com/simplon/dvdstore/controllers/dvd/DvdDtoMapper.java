package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DvdDtoMapper {
    DvdStoreGetDto toDto(DvdStoreServiceModel dvdStoreServiceModel);

    DvdStoreServiceModel toServiceModel(DvdStoreGetDto dvdStoreGetDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    DvdStoreGetDto partialUpdate(DvdStoreServiceModel dvdStoreServiceModel, @MappingTarget DvdStoreGetDto dvdStoreGetDto);
}
package com.simplon.dvdstore.repositories.feignclient.dto;

public record DvdDto(Long id,
                     Long dvdId,
                     int dvdQuantity,
                     Float dvdPrice) {
}

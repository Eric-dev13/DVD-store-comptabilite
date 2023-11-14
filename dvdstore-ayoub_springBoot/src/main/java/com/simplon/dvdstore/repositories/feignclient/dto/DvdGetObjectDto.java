package com.simplon.dvdstore.repositories.feignclient.dto;

public record DvdGetObjectDto(Long id,
                              DvdDto dvd,
                              int dvdQuantity,
                              Float dvdPrice) {
}

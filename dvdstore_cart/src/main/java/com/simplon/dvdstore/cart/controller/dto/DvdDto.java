package com.simplon.dvdstore.cart.controller.dto;

public record DvdDto(Long id,
                     Long dvdId,
                     int dvdQuantity,
                     Float dvdPrice) {
}

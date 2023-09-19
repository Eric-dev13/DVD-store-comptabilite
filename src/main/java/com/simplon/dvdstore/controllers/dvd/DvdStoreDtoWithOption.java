package com.simplon.dvdstore.controllers.dvd;

import java.math.BigDecimal;
import java.util.Optional;

public record DvdStoreDtoWithOption(Long id, String name, String genre, int quantity, BigDecimal price){}

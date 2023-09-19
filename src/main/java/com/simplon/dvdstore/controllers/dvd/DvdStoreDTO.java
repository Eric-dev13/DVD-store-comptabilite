package com.simplon.dvdstore.controllers.dvd;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigDecimal;
import java.util.Optional;

//@Data
//public class DvdStoreDTO {
//    private String name;
//    private String genre;
//}

public record DvdStoreDTO(String name, String genre, int quantity, BigDecimal price){}

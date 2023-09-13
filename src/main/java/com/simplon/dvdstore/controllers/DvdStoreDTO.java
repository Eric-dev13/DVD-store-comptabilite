package com.simplon.dvdstore.controllers;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

//@Data
//public class DvdStoreDTO {
//    private String name;
//    private String genre;
//}

public record DvdStoreDTO(String name, String genre){}

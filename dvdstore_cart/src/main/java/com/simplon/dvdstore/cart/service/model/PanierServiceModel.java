package com.simplon.dvdstore.cart.service.model;

import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;


public record PanierServiceModel(Long id,
                                 LocalDateTime createdAt,
                                 Float amount,
                                 Long clientId,
                                 List<PanierDvdRepositoryModel> dvds) { }

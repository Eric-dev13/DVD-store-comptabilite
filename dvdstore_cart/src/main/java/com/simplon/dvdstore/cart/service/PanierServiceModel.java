package com.simplon.dvdstore.cart.service;

import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;


public record PanierServiceModel(Long id,
                                 LocalDateTime createdAt,
                                 Float amount,
                                 Long clientId,
                                 List<PanierDvdRepositoryModel> paniers) { }

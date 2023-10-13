package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

public record PanierGetDto(Long id,
                           LocalDateTime createdAt,
                           Float amount,
                           Long clientId,
                           List<PanierDvdRepositoryModel> paniers) { }

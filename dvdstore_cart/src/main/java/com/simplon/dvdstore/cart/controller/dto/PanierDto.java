package com.simplon.dvdstore.cart.controller.dto;

import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;

import java.time.LocalDateTime;
import java.util.List;

public record PanierDto(Long id,
                        LocalDateTime createdAt,
                        Float amount,
                        Long clientId,
                        List<PanierDvdDto> dvds) { }

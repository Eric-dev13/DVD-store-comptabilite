package com.simplon.dvdstore.repositories.feignclient.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;

public record PanierDto(Long id,
                        LocalDateTime createdAt,
                        Float amount,
                        Long clientId,
                        ArrayList<DvdDto> dvds
                    ) { }

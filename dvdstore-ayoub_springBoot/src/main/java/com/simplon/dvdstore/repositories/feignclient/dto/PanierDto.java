package com.simplon.dvdstore.repositories.feignclient.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public record PanierDto(Long id,
                        LocalDateTime createdAt,
                        Float amount,
                        Long clientId,
                        List<DvdDto> dvds
                    ) { }

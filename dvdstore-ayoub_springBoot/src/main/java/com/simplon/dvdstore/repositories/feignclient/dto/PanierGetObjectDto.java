package com.simplon.dvdstore.repositories.feignclient.dto;


import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public record PanierGetObjectDto(Long id,
                                 LocalDateTime createdAt,
                                 Float amount,
                                 ClientRepositoryModel client, List<DvdStoreRepositoryModel> dvds
) {

}

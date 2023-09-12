package com.simplon.dvdstore.services;

import com.simplon.dvdstore.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DvdStoreService {

    private final DvdModelRepository dvdStoreRepository;

    public DvdRepositoryModel add(DvdRepositoryModel dvdModel) {
        return dvdStoreRepository.save(dvdModel);
    }


    public Iterable<DvdRepositoryModel> getAll() {
        return dvdStoreRepository.findAll();
    }
}

package com.simplon.dvdstore.services;

import com.simplon.dvdstore.DvdModel;
import com.simplon.dvdstore.repositories.DvdModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DvdStoreService {

    private final DvdModelRepository dvdStoreRepository;

    public DvdModel add(DvdModel dvdModel) {
        return dvdStoreRepository.save(dvdModel);
    }


    public Iterable<DvdModel> getAll() {
        return dvdStoreRepository.findAll();
    }
}

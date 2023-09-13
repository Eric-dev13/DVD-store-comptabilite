package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepository;
import com.simplon.dvdstore.repositories.DvdStoreRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DvdStoreService {

    @Autowired
    private DvdRepository dvdStoreRepository;


    public boolean addDvdStore(DvdStoreServiceModel dvdStoreServiceModel) {
       DvdStoreRepositoryModel modelRepository = new DvdStoreRepositoryModel(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre());
        Object object =  dvdStoreRepository.save(modelRepository);
        return object != null;
    }

    public ArrayList<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
        ArrayList<DvdStoreServiceModel> dvdStoreServiceModels = new ArrayList<>();

        ArrayList<DvdStoreRepositoryModel> dvdStoreRepositoryModels = dvdStoreRepository.findAll();
        for(DvdStoreRepositoryModel dvdStoreRepositoryModel: dvdStoreRepositoryModels) {
            dvdStoreServiceModels.add(new DvdStoreServiceModel(dvdStoreRepositoryModel.getName(),dvdStoreRepositoryModel.getGenre()));
        }
        // Mappage en dvdServiceModel
        return dvdStoreServiceModels;
    }


}

package com.simplon.dvdstore.services;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.repositories.DvdRepository;
import com.simplon.dvdstore.repositories.DvdStoreRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DvdStoreService {

    @Autowired
    private DvdRepository dvdStoreRepository;


    public boolean addDvdStore(DvdStoreServiceModel dvdStoreServiceModel) {
       DvdStoreRepositoryModel modelRepository = new DvdStoreRepositoryModel(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre());
        Object object = dvdStoreRepository.save(modelRepository);
        return object != null;
    }

    public List<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
        List<DvdStoreServiceModel> dvdStoreServiceModels = new ArrayList<>();

        List<DvdStoreRepositoryModel> dvdStoreRepositoryModels = dvdStoreRepository.findAll();
        for(DvdStoreRepositoryModel dvdStoreRepositoryModel: dvdStoreRepositoryModels) {
            dvdStoreServiceModels.add(new DvdStoreServiceModel(Optional.ofNullable(dvdStoreRepositoryModel.getId()),dvdStoreRepositoryModel.getName(),dvdStoreRepositoryModel.getGenre()));
        }
        // Mappage en dvdServiceModel
        return dvdStoreServiceModels;
    }


    public DvdStoreServiceModel finById(Long id) {
        Optional<DvdStoreRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);
        if(dvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new DvdStoreServiceModel(dvdRepositoryModel.get().getName(),dvdRepositoryModel.get().getGenre());
        }
    }

    public boolean delete(Long id) {
        if(dvdStoreRepository.existsById(id)){
            dvdStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean patch(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId().get();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = new DvdStoreRepositoryModel();
            repositoryModel.setId(id);
            if(!dvdStoreServiceModel.getName().isBlank()){
                repositoryModel.setName(dvdStoreServiceModel.getName());
            }
            if(!dvdStoreServiceModel.getGenre().isBlank()){
                repositoryModel.setGenre(dvdStoreServiceModel.getGenre());
            }

            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }

    public boolean put(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId().get();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = new DvdStoreRepositoryModel(dvdStoreServiceModel.getId().get(),dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre());

            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }
}

package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class DvdStoreService {

    @Autowired
    private DvdRepository dvdStoreRepository;


    public List<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
        List<DvdStoreServiceModel> dvdStoreServiceModels = new ArrayList<>();

        List<DvdStoreRepositoryModel> dvdStoreRepositoryModels = dvdStoreRepository.findAll();
        for(DvdStoreRepositoryModel dvdStoreRepositoryModel: dvdStoreRepositoryModels) {
            dvdStoreServiceModels.add(new DvdStoreServiceModel(
                    Optional.ofNullable(dvdStoreRepositoryModel.getId()),
                    dvdStoreRepositoryModel.getName(),
                    dvdStoreRepositoryModel.getGenre(),
                    dvdStoreRepositoryModel.getQuantity(),
                    dvdStoreRepositoryModel.getPrice(),
                    dvdStoreRepositoryModel.getFilename()
                    )
            );
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
            return new DvdStoreServiceModel(
                    Optional.ofNullable(dvdRepositoryModel.get().getId()),
                    dvdRepositoryModel.get().getName(),
                    dvdRepositoryModel.get().getGenre(),
                    dvdRepositoryModel.get().getQuantity(),
                    dvdRepositoryModel.get().getPrice(),
                    dvdRepositoryModel.get().getFilename()
            );
        }
    }

    public boolean addDvdStore(DvdStoreServiceModel dvdStoreServiceModel) {
       DvdStoreRepositoryModel modelRepository = new DvdStoreRepositoryModel(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre(),dvdStoreServiceModel.getQuantity(), dvdStoreServiceModel.getPrice(),dvdStoreServiceModel.getFilename());
        Object object = dvdStoreRepository.save(modelRepository);
        return object != null;
    }


    public boolean delete(Long id) {
        if(dvdStoreRepository.existsById(id)){
            dvdStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

//    public boolean patch(DvdStoreServiceModel dvdStoreServiceModel) {
//        Long id = dvdStoreServiceModel.getId().get();
//        if(dvdStoreRepository.existsById(id)){
//            DvdStoreRepositoryModel repositoryModel = new DvdStoreRepositoryModel();
//            repositoryModel.setId(id);
//            if(!dvdStoreServiceModel.getName().isBlank()){
//                repositoryModel.setName(dvdStoreServiceModel.getName());
//            }
//            if(!dvdStoreServiceModel.getGenre().isBlank()){
//                repositoryModel.setGenre(dvdStoreServiceModel.getGenre());
//            }
//            if(dvdStoreServiceModel.getQuantity() > 0){
//                repositoryModel.setQuantity(dvdStoreServiceModel.getQuantity());
//            }
//
//            Object object = dvdStoreRepository.save(repositoryModel);
//            return object != null;
//        }
//        return false;
//    }

    public boolean put(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId().get();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = new DvdStoreRepositoryModel(
                                                            dvdStoreServiceModel.getId().get(),
                                                            dvdStoreServiceModel.getName(),
                                                            dvdStoreServiceModel.getGenre(),
                                                            dvdStoreServiceModel.getQuantity(),
                                                            dvdStoreServiceModel.getPrice(),
                                                            dvdStoreServiceModel.getFilename()
                                                        );

            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }
}

package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DvdStoreService {

    @Autowired
    private DvdRepository dvdStoreRepository;

    DvdServiceMapper dvdServiceMapper = DvdServiceMapper.INSTANCE;

    public List<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
        /*
        var dvdStoreServiceModels = dvdStoreRepository.findAll().stream().map((value) -> dvdServiceMapper.DvdStoreRepositoryModelToDvdStoreServiceModel(value)).collect(Collectors.toList());
        */
        return dvdStoreRepository.findAll().stream().map(dvdServiceMapper::DvdStoreRepositoryModelToDvdStoreServiceModel).collect(Collectors.toList());
    }


    public DvdStoreServiceModel finById(Long id) {
        Optional<DvdStoreRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if(dvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return dvdServiceMapper.DvdStoreRepositoryModelToDvdStoreServiceModel(dvdRepositoryModel.get());
        }
    }

    public boolean addDvdStore(DvdStoreServiceModel dvdStoreServiceModel) {
        DvdStoreRepositoryModel modelRepository = dvdServiceMapper.dvdStoreServiceModelToDvdStoreRepositoryModel(dvdStoreServiceModel);
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

    public boolean put(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId().get();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = dvdServiceMapper.dvdStoreServiceModelToDvdStoreRepositoryModel(dvdStoreServiceModel);
//            DvdStoreRepositoryModel repositoryModel = new DvdStoreRepositoryModel(
//                                                            dvdStoreServiceModel.getId().get(),
//                                                            dvdStoreServiceModel.getName(),
//                                                            dvdStoreServiceModel.getGenre(),
//                                                            dvdStoreServiceModel.getQuantity(),
//                                                            dvdStoreServiceModel.getPrice(),
//                                                            dvdStoreServiceModel.getFilename()
//                                                        );

            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }



}

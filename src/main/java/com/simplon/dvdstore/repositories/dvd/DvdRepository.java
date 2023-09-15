package com.simplon.dvdstore.repositories.dvd;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface DvdRepository extends CrudRepository<DvdStoreRepositoryModel, Long> {
    ArrayList<DvdStoreRepositoryModel> findAll();
//    DvdStoreRepositoryModel findById();

}

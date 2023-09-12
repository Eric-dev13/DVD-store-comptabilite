package com.simplon.dvdstore.repositories;

import com.simplon.dvdstore.DvdRepositoryModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DvdModelRepository extends CrudRepository<DvdRepositoryModel, Long> {
//    List<DvdModel> findByLastName(String lastName);

}

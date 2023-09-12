package com.simplon.dvdstore.repositories;

import com.simplon.dvdstore.DvdModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DvdModelRepository extends CrudRepository<DvdModel, Long> {
//    List<DvdModel> findByLastName(String lastName);

}

package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.repositories.DvdStoreRepositoryModel;
import com.simplon.dvdstore.services.DvdStoreService;
import com.simplon.dvdstore.services.DvdStoreServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // N'accepte que des données JSON ou XML
//@RequiredArgsConstructor
@RequestMapping("api/dvdstore")
public class DvdStoreController {

    // Via la constante (final) l'annotation @RequiredArgsConstructor Lombok va injecter le service dans le constructeur

    @Autowired
    private DvdStoreService dvdStoreService;

    @GetMapping
    public ArrayList<DvdStoreDTO> findAll(){
        // Retourne un tableau
        ArrayList<DvdStoreDTO> dvdStoreDTOS = new ArrayList<>();
        ArrayList<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        for(DvdStoreServiceModel dvdStoreServiceModel: dvdStoreServiceModels){
            dvdStoreDTOS.add(new DvdStoreDTO(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre()));
        }
        return dvdStoreDTOS;
    }

    @GetMapping("/{id}")
    public DvdStoreDTO findById(@PathVariable("id") Long id){
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        return new DvdStoreDTO(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre());
    }

    @PostMapping
    public boolean addDvdStore(@RequestBody DvdStoreDTO dvdStoreDTO){
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(dvdStoreDTO.name(),dvdStoreDTO.genre());
        return dvdStoreService.addDvdStore(dvdStoreServiceModel);
    }
}

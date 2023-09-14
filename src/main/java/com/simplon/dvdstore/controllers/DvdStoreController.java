package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.repositories.DvdStoreRepositoryModel;
import com.simplon.dvdstore.services.DvdStoreService;
import com.simplon.dvdstore.services.DvdStoreServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // N'accepte que des données JSON ou XML
//@RequiredArgsConstructor
@RequestMapping("api/dvdstore")
public class DvdStoreController {

    // Via la constante (final) l'annotation @RequiredArgsConstructor Lombok va injecter le service dans le constructeur

    @Autowired
    private DvdStoreService dvdStoreService;

    @GetMapping
    public List<DvdStoreDTO> findAll(){
        // Retourne un tableau
        List<DvdStoreDTO> dvdStoreDTOS = new ArrayList<>();
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        for(DvdStoreServiceModel dvdStoreServiceModel: dvdStoreServiceModels){
            dvdStoreDTOS.add(new DvdStoreDTO(dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre()));
        }
        return dvdStoreDTOS;
    }

    @GetMapping("/with-id")
    public List<DvdStoreDtoWithOption> findAllWithId(){
        List<DvdStoreDtoWithOption> dvdStoreDtoWithOptions = new ArrayList<>();
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        for(DvdStoreServiceModel dvdStoreServiceModel: dvdStoreServiceModels){
            dvdStoreDtoWithOptions.add(new DvdStoreDtoWithOption(dvdStoreServiceModel.getId().get(),dvdStoreServiceModel.getName(),dvdStoreServiceModel.getGenre()));
        }
        return dvdStoreDtoWithOptions;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreDTO> findById(@PathVariable("id") Long id) throws DvdNotFoundException {
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        if(dvdStoreServiceModel != null){
            return new ResponseEntity<DvdStoreDTO>(new DvdStoreDTO(dvdStoreServiceModel.getName(), dvdStoreServiceModel.getGenre()), HttpStatus.OK);
        } else {
            throw new DvdNotFoundException();
        }
    }

    @PostMapping
    public boolean addDvdStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(dvdStoreDTO.name(),dvdStoreDTO.genre());
        return dvdStoreService.addDvdStore(dvdStoreServiceModel);
    }

    @PatchMapping("/{id}")
    public boolean patch(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO){
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.ofNullable(id),dvdStoreDTO.name(),dvdStoreDTO.genre());
        return dvdStoreService.patch(dvdStoreServiceModel);
    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO){
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.ofNullable(id),dvdStoreDTO.name(),dvdStoreDTO.genre());
        return dvdStoreService.put(dvdStoreServiceModel);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return dvdStoreService.delete(id);
    }
}

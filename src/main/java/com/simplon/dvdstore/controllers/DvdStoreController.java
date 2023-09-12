package com.simplon.dvdstore.controllers;

import com.simplon.dvdstore.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController // N'accepte que des données JSON ou XML
@RequiredArgsConstructor
@RequestMapping("api/dvdstore")
public class DvdStoreController {

    // Via la constante (final) l'annotation @RequiredArgsConstructor Lombok va injecter le service dans le constructeur
    private final DvdStoreService dvdStoreService;

    @GetMapping
    public Iterable<DvdRepositoryModel> getAll(){
        return dvdStoreService.getAll();
    }

    @PostMapping
    public DvdRepositoryModel add(@RequestBody DvdRepositoryModel dvdModel){
        return dvdStoreService.add(dvdModel);
    }

}

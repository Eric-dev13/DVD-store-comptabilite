package com.simplon.dvdstore.repositories.feignclient;

import com.simplon.dvdstore.repositories.feignclient.dto.PanierDto;
import com.simplon.dvdstore.repositories.feignclient.dto.PanierDvdDto;
import com.simplon.dvdstore.repositories.feignclient.proxies.MicroserviceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("paniers")
public class FeignPanierController {

    private final MicroserviceProxy microserviceProxy;

    // RETOURNE TOUS LES PANIERS
    @GetMapping
    public ArrayList<PanierDto> findAll(){
        ArrayList<PanierDto> panierDtos = microserviceProxy.findAll();
        return panierDtos;
    }

    // RETOURNE UN PANIER
    @GetMapping("/{id}")
    public PanierDto findById(@PathVariable("id") Long id){
        PanierDto panierDto = microserviceProxy.findById(id);
        return panierDto;
    }

    // AJOUTE UN PANIER
    @PostMapping
    public boolean add(@RequestBody PanierDto panierDto){
        return microserviceProxy.add(panierDto);
    }

    // AJOUTER UN PRODUIT AU PANIER
    @PostMapping("/add-dvd")
    public boolean addNewDvd(@RequestBody PanierDvdDto panierDvdDto) {
        return false;
    }

    // SUPPRIMER UN PRODUIT DU PANIER
    @DeleteMapping
    public boolean deleteById(@PathVariable("id") Long id){
        return microserviceProxy.deleteById(id);
    }

}

package com.simplon.dvdstore.repositories.feignclient.proxies;

import com.simplon.dvdstore.repositories.feignclient.dto.PanierDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@FeignClient(name = "microservice-panier", url = "http://localhost:9001/paniers")
public interface MicroserviceProxy {

    // RETOURNE TOUS LES PANIERS
    @GetMapping
    ArrayList<PanierDto> findAll();

    // RETOURNE UN PANIER
    @GetMapping(value = "/{id}")
    PanierDto findById(@PathVariable("id") Long id);

    // AJOUTE UN PANIER
    @PostMapping(value = "/{id}")
    boolean add(@RequestBody PanierDto panierDto);


    // SUPPRIMER UN PRODUIT DU PANIER
    @DeleteMapping(value = "/dvd/{id}")
    boolean deleteById(Long id);
}

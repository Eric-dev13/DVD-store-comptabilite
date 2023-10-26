package com.simplon.dvdstore.repositories.feignclient;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import com.simplon.dvdstore.repositories.feignclient.dto.DvdDto;
import com.simplon.dvdstore.repositories.feignclient.dto.PanierDto;
import com.simplon.dvdstore.repositories.feignclient.dto.PanierDvdDto;
import com.simplon.dvdstore.repositories.feignclient.dto.PanierGetObjectDto;
import com.simplon.dvdstore.repositories.feignclient.proxies.MicroserviceProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/paniers")
public class FeignPanierController {

    private final MicroserviceProxy microserviceProxy;

    private final ClientRepository clientRepository;

    private final DvdRepository dvdRepository;

    // RETOURNE TOUS LES PANIERS
    @GetMapping
    public List<PanierGetObjectDto> findAll(){
        List<PanierDto> panierDtos = microserviceProxy.findAll();
        List<PanierGetObjectDto> panierGetObjectDtos = new ArrayList<>();
        for(PanierDto panierDto : panierDtos){

            List<DvdStoreRepositoryModel> dvdStoreRepositoryModels = new ArrayList<>();
            for(DvdDto dvd :panierDto.dvds()) {
                dvdStoreRepositoryModels.add(dvdRepository.findById(dvd.dvdId()).orElse(null));
            }

            PanierGetObjectDto panierGetObjectDto = new PanierGetObjectDto(
                    panierDto.id(),
                    panierDto.createdAt(),
                    panierDto.amount(),
                    // retourne le client
                    clientRepository.findById(panierDto.clientId()).orElse(null),
                    // retourne le dvd dans la liste des dvds
                    dvdStoreRepositoryModels
            );
                    panierGetObjectDtos.add(panierGetObjectDto);
            }
        return panierGetObjectDtos;
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

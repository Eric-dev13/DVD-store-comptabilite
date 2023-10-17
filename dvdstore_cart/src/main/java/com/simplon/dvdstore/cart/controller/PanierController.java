package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.controller.dto.PanierDto;
import com.simplon.dvdstore.cart.controller.mapper.PanierDtoMapper;
import com.simplon.dvdstore.cart.controller.dto.PanierDvdDto;
import com.simplon.dvdstore.cart.controller.mapper.PanierDvdDtoMapper;
import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.PanierService;
import com.simplon.dvdstore.cart.service.model.PanierDvdServiceModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/panier")
public class PanierController {

    private final PanierService panierService;
    private final PanierRepository panierRepository;

    // RECUPERE TOUS LES PANIERS
    @GetMapping
    public List<PanierDto> findAll(){
        List<PanierServiceModel> panierServiceModels =  panierService.findAll();
        List<PanierDto> panierDto = panierServiceModels.stream().map((value)-> PanierDtoMapper.INSTANCE.toDto(value)).collect(Collectors.toList());
        return panierDto;
    }

    // RECUPERE UN PANIER
    @GetMapping("/{id}")
    public PanierDto findById(@PathVariable Long id) {
        return PanierDtoMapper.INSTANCE.toDto(panierService.findById(id));
    }

    // AJOUTE UN PANIER
    @PostMapping
    public boolean add(@RequestBody PanierDto panierDto){
        return panierService.add(PanierDtoMapper.INSTANCE.toService(panierDto));
    }

    // AJOUTER UN PRODUIT AU PANIER
    @PostMapping("/add-dvd")
    public boolean addNewDvd(@RequestBody PanierDvdDto panierDvdDto){
        PanierDvdServiceModel panierDvdServiceModel = PanierDvdDtoMapper.INSTANCE.toService(panierDvdDto);
        return panierService.addNewDvd(panierDvdServiceModel);
    }

    // CALCULER LE TOTAL DU PANIER
    @PutMapping("/calcul/{id}")
    public void updateAmoutCart(@PathVariable("id") Long id){
        panierRepository.updateAmoutCart(id);
    }







}

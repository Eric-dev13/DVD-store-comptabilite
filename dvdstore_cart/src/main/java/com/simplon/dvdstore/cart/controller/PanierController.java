package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.PanierService;
import com.simplon.dvdstore.cart.service.PanierServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/panier")
public class PanierController {

    private final PanierService panierService;
    private final PanierRepository panierRepository;

    @GetMapping
    public List<PanierGetDto> findAll(){
        List<PanierServiceModel> panierServiceModels =  panierService.findAll();
        List<PanierGetDto> panierGetDto = panierServiceModels.stream().map((value)->PanierDtoMapper.INSTANCE.toDto(value)).collect(Collectors.toList());
        return panierGetDto;
    }

    @PostMapping
    public boolean add(@RequestBody PanierDto panierDto){
        return panierService.add(PanierDtoMapper.INSTANCE.toService(panierDto));
    }


    public void panierRepository(@PathVariable("id") int id){
        panierRepository.updateAmoutCart(id);
    }


}

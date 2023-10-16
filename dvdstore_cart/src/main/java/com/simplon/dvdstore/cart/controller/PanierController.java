package com.simplon.dvdstore.cart.controller;

import com.simplon.dvdstore.cart.controller.dto.PanierDto;
import com.simplon.dvdstore.cart.controller.dto.PanierDtoMapper;
import com.simplon.dvdstore.cart.controller.dto.PanierDvdDto;
import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.service.PanierService;
import com.simplon.dvdstore.cart.service.PanierServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/panier")
public class PanierController {

    private final PanierService panierService;
    private final PanierRepository panierRepository;


    @GetMapping
    public List<PanierDto> findAll(){
        List<PanierServiceModel> panierServiceModels =  panierService.findAll();
        List<PanierDto> panierDto = panierServiceModels.stream().map((value)-> PanierDtoMapper.INSTANCE.toDto(value)).collect(Collectors.toList());
        return panierDto;
    }


    @GetMapping("/{id}")
    public PanierDto findById(@PathVariable Long id) {
        return PanierDtoMapper.INSTANCE.toDto(panierService.findById(id));
    }

    @PostMapping
    public boolean add(@RequestBody PanierDto panierDto){
        return panierService.add(PanierDtoMapper.INSTANCE.toService(panierDto));
    }

    // Ajouter un produit au panier
    @PostMapping("/{id}")
    public void addDvd(@PathVariable("id") int id, @RequestBody PanierDvdDto panierDvdDto){
        //panierDvdRepository.save()
    }

    @PutMapping("/calcul/{id}")
    public void updateAmoutCart(@PathVariable("id") int id){
        panierRepository.updateAmoutCart(id);
    }





}

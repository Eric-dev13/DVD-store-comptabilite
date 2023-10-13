package com.simplon.dvdstore.cart.service;


import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PanierService {
    private final PanierRepository panierRepository;

    public List<PanierServiceModel> findAll() {
        return panierRepository.findAll().stream().map((value)->PanierServiceMapper.INSTANCE.toService(value)).collect(Collectors.toList());
    }

    public boolean add(PanierServiceModel serviceModel) {

        Object object = panierRepository.save(PanierServiceMapper.INSTANCE.toRepository(serviceModel));
        return object != null;
    }
}

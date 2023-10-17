package com.simplon.dvdstore.cart.service;


import com.simplon.dvdstore.cart.repository.PanierDvdRepository;
import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.mapper.PanierDvdServiceMapper;
import com.simplon.dvdstore.cart.service.mapper.PanierServiceMapper;
import com.simplon.dvdstore.cart.service.model.PanierDvdServiceModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PanierService {

    private final PanierRepository panierRepository;
    private final PanierDvdRepository panierDvdRepository;

    // RECUPERE TOUS LES PANIERS
    public List<PanierServiceModel> findAll() {
        return panierRepository.findAll().stream().map((value)-> PanierServiceMapper.INSTANCE.toService(value)).collect(Collectors.toList());
    }

    // AJOUTE UN PANIER
    public boolean add(PanierServiceModel serviceModel) {
        Object object = panierRepository.save(PanierServiceMapper.INSTANCE.toRepository(serviceModel));
        return object != null;
    }

    // RECUPERE UN PANIER
    public PanierServiceModel findById(Long id) {
        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(id);
        if(panierRepositoryModel.isPresent()){
            return PanierServiceMapper.INSTANCE.toService(panierRepositoryModel.get());
        }
        return null;
    }

    // AJOUTE UN PRODUIT AU PANIER
    public boolean dvd(Long id, PanierDvdServiceModel panierDvdServiceModel) {
        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(id);
        if(panierRepositoryModel.isPresent()){
        }
        return false;
    }

    // AJOUTE UN PRODUIT AU PANIER
    public boolean addNewDvd(PanierDvdServiceModel panierDvdServiceModel) {
        PanierDvdRepositoryModel panierDvdRepositoryModel = PanierDvdServiceMapper.INSTANCE.toRepository(panierDvdServiceModel);

        PanierDvdRepositoryModel newPanierDvdRepositoryModel =  panierDvdRepository.save(panierDvdRepositoryModel);

        // Récupere l'id du nouvel enregistrement dvd-panier
        //Long panierId = newPanierDvdRepositoryModel.getPanier().getId();

        // Retourne l'ID du panier
        Long panierId = panierDvdServiceModel.panier().getId();

        // CALCULER LE TOTAL DU PANIER
        panierRepository.updateAmoutCart(panierId);

        return newPanierDvdRepositoryModel != null;

    }
}

package com.simplon.dvdstore.cart.service;


import com.simplon.dvdstore.cart.repository.PanierDvdRepository;
import com.simplon.dvdstore.cart.repository.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repository.PanierRepository;
import com.simplon.dvdstore.cart.repository.PanierRepositoryModel;
import com.simplon.dvdstore.cart.service.mapper.PanierDvdServiceMapper;
import com.simplon.dvdstore.cart.service.mapper.PanierServiceMapper;
import com.simplon.dvdstore.cart.service.model.PanierDvdServiceModel;
import com.simplon.dvdstore.cart.service.model.PanierServiceModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;
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
    private final EntityManager entityManager;

    // RETOURNE TOUS LES PANIERS
    public List<PanierServiceModel> findAll() {
        return panierRepository.findAll().stream().map((value)-> PanierServiceMapper.INSTANCE.toService(value)).collect(Collectors.toList());
    }

    // AJOUTE UN PANIER
    public boolean add(PanierServiceModel serviceModel) {
        Object object = panierRepository.save(PanierServiceMapper.INSTANCE.toRepository(serviceModel));
        return object != null;
    }

    // RETOURNE UN PANIER
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

        // Retourne l'ID du panier
        Long panierId = panierDvdServiceModel.panier().getId();

        // EXECUTER UNE PROCEDURE STOCKEE - CALCULER LE TOTAL DU PANIER
        //panierRepository.updateAmountCart(panierId);

        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("calcul_total_panier");
        // Paramètres (si la procédure en a)
        query.registerStoredProcedureParameter("panier_id", int.class, ParameterMode.IN);
        query.setParameter("panier_id", panierId);

        // Exécutez la procédure stockée
        query.execute();

        return newPanierDvdRepositoryModel != null;
    }

    // SUPPRIMER UN PRODUIT DU PANIER
    public boolean deleteById(Long id) {
        if(panierDvdRepository.existsById(id)){
            panierDvdRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

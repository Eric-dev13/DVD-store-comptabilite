package com.simplon.dvdstore.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PanierRepository extends JpaRepository<PanierRepositoryModel, Long> {
    ArrayList<PanierRepositoryModel> findAll();

    @Query(value="CALL calcul_total_panier(:panier_id)", nativeQuery = true)
    void updateAmoutCart(Long panier_id);
}
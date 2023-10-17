package com.simplon.dvdstore.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanierDvdRepository extends JpaRepository<PanierDvdRepositoryModel, Long> {

};
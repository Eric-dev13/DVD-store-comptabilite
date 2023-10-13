package com.simplon.dvdstore.cart.repository;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="panier_dvd")
public class PanierDvdRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long dvdId;

    private int dvdQuantity;

    private Float dvdPrice;

    @ManyToOne
    @JoinColumn(name = "panier_id")
    private PanierRepositoryModel panier;

}

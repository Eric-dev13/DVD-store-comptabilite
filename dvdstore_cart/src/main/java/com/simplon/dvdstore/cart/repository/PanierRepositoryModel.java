package com.simplon.dvdstore.cart.repository;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "panier")
public class PanierRepositoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdAt;

    private Float amount;

    private Long clientId;

    @OneToMany(mappedBy = "panier", orphanRemoval = true)
    private List<PanierDvdRepositoryModel> dvds = new ArrayList<>();

//    public PanierRepositoryModel(Long clientId) {
//        this.clientId = clientId;
//    }

    @PrePersist
    public void prePersist(){
        this.createdAt = LocalDateTime.now();
    }
}

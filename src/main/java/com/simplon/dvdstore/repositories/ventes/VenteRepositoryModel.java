package com.simplon.dvdstore.repositories.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="vente")
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name = "date_achat")
    private LocalDateTime dateAchat;

    @Column(name = "prix")
    private BigDecimal prix;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private ClientRepositoryModel clientRepositoryModel;

    @ManyToOne
    @JoinColumn(name = "dvd_store_repository_model_id")
    private DvdStoreRepositoryModel dvdStoreRepositoryModel;


    public VenteRepositoryModel(BigDecimal prix, ClientRepositoryModel clientRepositoryModel, DvdStoreRepositoryModel dvdStoreRepositoryModel) {
        this.prix = prix;
        this.clientRepositoryModel = clientRepositoryModel;
        this.dvdStoreRepositoryModel = dvdStoreRepositoryModel;
    }

    @PrePersist
    public void prePersist(){
        dateAchat = LocalDateTime.now();
    }


}

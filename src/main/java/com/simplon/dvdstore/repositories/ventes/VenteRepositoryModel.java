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
//@AllArgsConstructor
@Table(name="vente")
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // id auto-incrémente
    private Long id;

    @Column(name = "date_achat")
    private LocalDateTime dateAchat;

    @Column(name="quantity")
    private int quantity;

    @Column(name = "prix")
    private float prix;



    @ManyToOne
    @JoinColumn(name = "client_id", nullable = true)
    private ClientRepositoryModel clientRepositoryModel;

    @ManyToOne
    @JoinColumn(name = "dvd_id")
    private DvdStoreRepositoryModel dvdStoreRepositoryModel;

    @ManyToOne
    @JoinColumn(name = "testclient_repository_model_id")
    private ClientRepositoryModel testclientRepositoryModel;

    // POST
    public VenteRepositoryModel(int quantity, float prix, ClientRepositoryModel clientRepositoryModel, DvdStoreRepositoryModel dvdStoreRepositoryModel) {
        this.quantity = quantity;
        this.prix = prix;
        this.clientRepositoryModel = clientRepositoryModel;
        this.dvdStoreRepositoryModel = dvdStoreRepositoryModel;
    }

    // Get
    public VenteRepositoryModel(long id, LocalDateTime dateAchat, int quantity, float prix, ClientRepositoryModel clientRepositoryModel, DvdStoreRepositoryModel dvdStoreRepositoryModel) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.quantity = quantity;
        this.prix = prix;
        this.clientRepositoryModel = clientRepositoryModel;
        this.dvdStoreRepositoryModel = dvdStoreRepositoryModel;
    }

    @PrePersist
    public void prePersist(){
        dateAchat = LocalDateTime.now();
    }


}

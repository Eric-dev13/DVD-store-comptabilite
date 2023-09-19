package com.simplon.dvdstore.repositories.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
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

    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "dvd_id")
    private List<DvdStoreRepositoryModel> dvdStoreRepositoryModels = new ArrayList<>();

    public VenteRepositoryModel(BigDecimal prix) {
        this.prix = prix;
    }

    public VenteRepositoryModel(Long id, BigDecimal prix){
        this.id = id;
        this.prix = prix;
    }

    @PrePersist
    public void prePersist(){
        dateAchat = LocalDateTime.now();
    }


}

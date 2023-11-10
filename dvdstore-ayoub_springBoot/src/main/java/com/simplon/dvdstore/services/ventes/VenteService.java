package com.simplon.dvdstore.services.ventes;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import com.simplon.dvdstore.services.dvd.DvdServiceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Service
public class VenteService {


    private final VenteRepository venteRepository;

    private final ClientRepository clientRepository;

    private final DvdRepository dvdRepository;

    private final DvdServiceMapper dvdServiceMapper;


    public List<VenteServiceModel> findAll() {
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();

        // Mapping
        for(VenteRepositoryModel venteRepositoryModel : venteRepositoryModels){

            // Mapping vente.client
            ClientServiceModel clientServiceModel = new ClientServiceModel(
                Optional.ofNullable(venteRepositoryModel.getClientRepositoryModel().getId()),
                venteRepositoryModel.getClientRepositoryModel().getLastname(),
                venteRepositoryModel.getClientRepositoryModel().getFirstname(),
                venteRepositoryModel.getClientRepositoryModel().getAddress()

            );

            // Mappage vente.dvd
            DvdStoreServiceModel dvdStoreServiceModel = dvdServiceMapper.toServiceModel(venteRepositoryModel.getDvdStoreRepositoryModel());
                    // DvdStoreServiceModel dvdStoreServiceModel = DvdServiceMapper.INSTANCE.DvdStoreRepositoryModelToDvdStoreServiceModel(venteRepositoryModel.getDvdStoreRepositoryModel());
//            DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(
//                    Optional.ofNullable(venteRepositoryModel.getDvdStoreRepositoryModel().getId()),
//                    venteRepositoryModel.getDvdStoreRepositoryModel().getName(),
//                    venteRepositoryModel.getDvdStoreRepositoryModel().getGenre(),
//                    venteRepositoryModel.getDvdStoreRepositoryModel().getQuantity(),
//                    venteRepositoryModel.getDvdStoreRepositoryModel().getPrice()
//            );

            venteServiceModels.add(new VenteServiceModel(
                    Optional.ofNullable(venteRepositoryModel.getId()),
                    venteRepositoryModel.getDateAchat(),
                    venteRepositoryModel.getQuantity(),
                    venteRepositoryModel.getPrix(),
                    clientServiceModel,
                    dvdStoreServiceModel
            ));
        }
        return venteServiceModels;
    }



    public boolean addVente(VenteServiceModel venteServiceModel) {

        // Mappage ClientServiceModel To ClientRepositoryModel
        ClientRepositoryModel clientRepositoryModel  = new ClientRepositoryModel();
        clientRepositoryModel.setId(venteServiceModel.getClientServiceModel().getId().get() );

        // Mappage DvdStoreServiceModel To DvdStoreRepositoryModel
        DvdStoreRepositoryModel dvdStoreRepositoryModel  = new DvdStoreRepositoryModel();
        dvdStoreRepositoryModel.setId(venteServiceModel.getDvdStoreServiceModel().getId());
        // 2 requete dvd et client
        float price = 0.0f;

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(venteServiceModel.getQuantity(), price, clientRepositoryModel, dvdStoreRepositoryModel);
        Object object = venteRepository.save(venteRepositoryModel);
        return object != null;
    }

    public boolean addVenteNoObject(VenteServiceModelNoObject venteServiceModelNoObject) {
        ClientRepositoryModel clientRepositoryModel =  clientRepository.findById(venteServiceModelNoObject.getClient()).get();
        DvdStoreRepositoryModel dvdStoreRepositoryModel = dvdRepository.findById(venteServiceModelNoObject.getDvd()).get();

        // Gestion du stocke, si le nombre de dvd est superieur ou egal

        int dvdEnStocke = dvdStoreRepositoryModel.getQuantity();
        int quantiteCommande =  venteServiceModelNoObject.getQuantity();

        if(quantiteCommande <= dvdEnStocke ){
            // Quantite restante
            int NouveauStockeDvd = dvdEnStocke - quantiteCommande;
            dvdStoreRepositoryModel.setQuantity(NouveauStockeDvd);
            dvdRepository.save(dvdStoreRepositoryModel);

            // Prix
           float newPrice =  (float)(quantiteCommande * dvdStoreRepositoryModel.getPrice());


            VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel(
                    venteServiceModelNoObject.getQuantity(),
                    newPrice,
                    clientRepositoryModel,
                    dvdStoreRepositoryModel
            );

            Object object = venteRepository.save(venteRepositoryModel);
            return object != null;

        } else {
            return false;
        }
        //venteServiceModelNoObject.getQuantity() * dvdStoreRepositoryModel.
    }


    public boolean delete(Long id){
        if(venteRepository.existsById(id)){
            venteRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public VenteServiceModel finById(Long id) {
       Optional<VenteRepositoryModel> venteRepositoryModel =  venteRepository.findById(id);

       if (venteRepositoryModel.isPresent()){
           VenteRepositoryModel vente = venteRepositoryModel.get();


           // Mapping vente.client
           ClientServiceModel clientServiceModel = new ClientServiceModel(
                   Optional.ofNullable(vente.getClientRepositoryModel().getId()),
                   vente.getClientRepositoryModel().getLastname(),
                   vente.getClientRepositoryModel().getFirstname(),
                   vente.getClientRepositoryModel().getAddress()
           );

           // Mapping vente.dvd
           DvdStoreServiceModel dvdStoreServiceModel = dvdServiceMapper.toServiceModel(vente.getDvdStoreRepositoryModel());
           //DvdStoreServiceModel dvdStoreServiceModel = DvdServiceMapper.INSTANCE.DvdStoreRepositoryModelToDvdStoreServiceModel(vente.getDvdStoreRepositoryModel());

           //Mapping vente
          return new VenteServiceModel(
                  Optional.ofNullable(vente.getId()),
                  vente.getDateAchat(),
                  vente.getQuantity(),
                  vente.getPrix(),
                  clientServiceModel,
                  dvdStoreServiceModel
           );

//           return VenteServiceMapper.INSTANCE.venteRepositoryModelToVenteServiceModel(venteRepositoryModel.get());

       }
       return null;
    }
}

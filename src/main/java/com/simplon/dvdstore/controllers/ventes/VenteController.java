package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientDTO;
import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDTO;
import com.simplon.dvdstore.controllers.dvd.DvdStoreDtoWithOption;
import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import com.simplon.dvdstore.services.ventes.VenteServiceModelNoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // N'accepte que des données JSON ou XML
@RequestMapping("api/vente")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @GetMapping
    public List<VenteGetDTO> findAll(){

        List<VenteGetDTO> venteGetDTOS = new ArrayList<>();

        List<VenteServiceModel> venteServiceModels = venteService.findAll();

        for(VenteServiceModel venteServiceModel: venteServiceModels){

            ClientGetDTO clientGetDTO = new ClientGetDTO(
                    venteServiceModel.getClientServiceModel().getId().get(),
                    venteServiceModel.getClientServiceModel().getLastname(),
                    venteServiceModel.getClientServiceModel().getFirstname(),
                    venteServiceModel.getClientServiceModel().getAddress()
            );

            DvdStoreDtoWithOption dvdStoreDtoWithOption = new DvdStoreDtoWithOption(
                    venteServiceModel.getDvdStoreServiceModel().getId().get(),
                    venteServiceModel.getDvdStoreServiceModel().getName(),
                    venteServiceModel.getDvdStoreServiceModel().getGenre(),
                    venteServiceModel.getDvdStoreServiceModel().getQuantity(),
                    venteServiceModel.getDvdStoreServiceModel().getPrice()
            );

            venteGetDTOS.add(new VenteGetDTO(
                    venteServiceModel.getId().get(),
                    venteServiceModel.getDateAchat(),
                    venteServiceModel.getQuantity(),
                    venteServiceModel.getPrice(),
                    clientGetDTO,
                    dvdStoreDtoWithOption
            ));
        }
        return venteGetDTOS;
    }

    @PostMapping
    public boolean addVente(@RequestBody VenteDTO venteDTO) {
        // Mappage clientDTO To ClientServiceModel
        ClientServiceModel clientServiceModel  = new ClientServiceModel();
        clientServiceModel.setId(Optional.ofNullable(venteDTO.clientGetDTO().id()) );

        // Mappage DvdStoreDtoWithOption To dvdServiceModel
        DvdStoreServiceModel dvdStoreServiceModel  = new DvdStoreServiceModel();
        dvdStoreServiceModel.setId(Optional.ofNullable(venteDTO.dvdGetDTO().id()));

        VenteServiceModel venteServiceModel = new VenteServiceModel(venteDTO.quantity() ,clientServiceModel, dvdStoreServiceModel);
        return venteService.addVente(venteServiceModel);
    }

    @PostMapping("/no-tranfert-object")
    public boolean addVenteWithId(@RequestBody VenteDTONoObject venteDTONoObject) {

       VenteServiceModelNoObject venteServiceModelNoObject = new VenteServiceModelNoObject(venteDTONoObject.quantity() , venteDTONoObject.client(), venteDTONoObject.dvd());
        return venteService.addVenteNoObject(venteServiceModelNoObject);
    }
}

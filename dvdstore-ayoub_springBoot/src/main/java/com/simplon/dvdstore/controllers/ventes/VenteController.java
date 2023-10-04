package com.simplon.dvdstore.controllers.ventes;

import com.simplon.dvdstore.controllers.clients.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvd.DvdDtoMapper;
import com.simplon.dvdstore.controllers.dvd.DvdStoreGetDto;
import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import com.simplon.dvdstore.services.ventes.VenteService;
import com.simplon.dvdstore.services.ventes.VenteServiceMapper;
import com.simplon.dvdstore.services.ventes.VenteServiceModel;
import com.simplon.dvdstore.services.ventes.VenteServiceModelNoObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // N'accepte que des données JSON ou XML
@RequestMapping("api/vente")
public class VenteController {

    @Autowired
    private VenteService venteService;

    @Autowired
    private VenteRepository venteRepository;

    @GetMapping
    public List<VenteGetDTO> findAll(){

        List<VenteServiceModel> venteServiceModels = venteService.findAll();
         //return venteServiceModels.stream().map(VenteDtoMapper.INSTANCE::venteServiceModelToVenteGetDTO).collect(Collectors.toList());

        List<VenteGetDTO> venteGetDTOS = new ArrayList<>();

        for(VenteServiceModel venteServiceModel: venteServiceModels){

            // vente.client
            ClientGetDTO clientGetDTO = new ClientGetDTO(
                    venteServiceModel.getClientServiceModel().getId().get(),
                    venteServiceModel.getClientServiceModel().getLastname(),
                    venteServiceModel.getClientServiceModel().getFirstname(),
                    venteServiceModel.getClientServiceModel().getAddress()
            );

            // MapStruct pour les dvds
            DvdStoreGetDto dvdStoreGetDto = DvdDtoMapper.INSTANCE.dvdServiceModelToDvdGetDTO(venteServiceModel.getDvdStoreServiceModel());

            // Mapping vente
            venteGetDTOS.add(new VenteGetDTO(
                    venteServiceModel.getId().get(),
                    venteServiceModel.getDateAchat(),
                    venteServiceModel.getQuantity(),
                    venteServiceModel.getPrice(),
                    clientGetDTO,
                    dvdStoreGetDto
            ));
        }
        return venteGetDTOS;
    }


    @GetMapping("/{id}")
    public ResponseEntity<VenteGetDTO> findById(@PathVariable("id") Long id) {
        VenteServiceModel venteServiceModel = venteService.finById(id);
        if(venteServiceModel != null){

            ClientGetDTO clientGetDTO = new ClientGetDTO(
                    venteServiceModel.getClientServiceModel().getId().get(),
                    venteServiceModel.getClientServiceModel().getLastname(),
                    venteServiceModel.getClientServiceModel().getFirstname(),
                    venteServiceModel.getClientServiceModel().getAddress()
            );

            // MapStruct pour les dvds
            DvdStoreGetDto dvdStoreGetDto = DvdDtoMapper.INSTANCE.dvdServiceModelToDvdGetDTO(venteServiceModel.getDvdStoreServiceModel());

            // Mapping vente
            VenteGetDTO venteGetDto =  new VenteGetDTO(
                    venteServiceModel.getId().get(),
                    venteServiceModel.getDateAchat(),
                    venteServiceModel.getQuantity(),
                    venteServiceModel.getPrice(),
                    clientGetDTO,
                    dvdStoreGetDto
            );

            // MAPPAGE AVEC MapStruct
//            VenteGetDTO venteGetDto = VenteDtoMapper.INSTANCE.venteServiceModelToVenteGetDTO(venteServiceModel);

            // Créer et renvoyer une ResponseEntity avec le DvdGetDTO en tant que corps
            return ResponseEntity.ok(venteGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public boolean addVenteWithId(@RequestBody VenteDTO venteDTO) {
       VenteServiceModelNoObject venteServiceModelNoObject = new VenteServiceModelNoObject(venteDTO.quantity(), venteDTO.client(), venteDTO.dvd());

        // VenteServiceModelNoObject venteServiceModelNoObject = VenteDtoMapper.INSTANCE.venteGetDtoToVenteServiceModel(venteDTO);

        return venteService.addVenteNoObject(venteServiceModelNoObject);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") Long id){
        return venteService.delete(id);
    }


    // VENTE PAR CLIENTS
    @GetMapping("/client/{id}")
    public List<VenteGetDTO> findAllVenteByClient(@PathVariable("id") Long id){
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAllVenteByClient(id);

        List<VenteServiceModel> venteServiceModels = venteRepositoryModels.stream().map((value) -> VenteServiceMapper.INSTANCE.venteRepositoryModelToVenteServiceModel(value)).collect(Collectors.toList());

        return venteServiceModels.stream().map((value) ->VenteDtoMapper.INSTANCE.venteServiceModelToVenteGetDTO(value)).collect(Collectors.toList());

    }


//    @PostMapping("/object")
//    public boolean addVenteWithObject(@RequestBody VenteDtoObject venteDTO) {
//        // Mappage clientDTO To ClientServiceModel
//        ClientServiceModel clientServiceModel  = new ClientServiceModel();
//        clientServiceModel.setId(Optional.ofNullable(venteDTO.clientGetDTO().id()) );
//
//
//        // Mappage DvdStoreDtoWithOption To dvdServiceModel
//        DvdStoreServiceModel dvdStoreServiceModel  = new DvdStoreServiceModel();
//        dvdStoreServiceModel.setId(Optional.ofNullable(venteDTO.dvdGetDTO().id()));
//
//        VenteServiceModel venteServiceModel = new VenteServiceModel(venteDTO.quantity() ,clientServiceModel, dvdStoreServiceModel);
//        return venteService.addVente(venteServiceModel);
//    }
}

package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.dvd.DvdServiceMapper;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController // N'accepte que des données JSON ou XML
//@CrossOrigin("http://localhost:4200")
@RequestMapping("api/dvd")
public class DvdStoreController {

    // Via la constante (final) l'annotation @RequiredArgsConstructor Lombok va injecter le service dans le constructeur

    @Autowired
    private DvdStoreService dvdStoreService;

    @GetMapping
    public List<DvdStoreGetDto> findAll(){
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        return dvdStoreServiceModels.stream().map(DvdDtoMapper.INSTANCE::dvdServiceModelToDvdGetDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreGetDto> findById(@PathVariable("id") Long id) throws DvdNotFoundException {
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        if(dvdStoreServiceModel != null){
            // MAPPAGE AVEC MapStruct
            DvdStoreGetDto dvdStoreGetDto = DvdDtoMapper.INSTANCE.dvdServiceModelToDvdGetDTO(dvdStoreServiceModel);

            // Créer et renvoyer une ResponseEntity avec le DvdGetDTO en tant que corps
            return ResponseEntity.ok(dvdStoreGetDto);
        } else {
            //return new ResponseEntity<>("n'existe pas",HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public boolean addDvdStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
        DvdStoreServiceModel dvdStoreServiceModel = DvdDtoMapper.INSTANCE.dvdGetDTOToDvdServiceModel(dvdStoreDTO);

        // DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(dvdStoreDTO.name(),dvdStoreDTO.genre(),dvdStoreDTO.quantity(),dvdStoreDTO.price());
        return dvdStoreService.addDvdStore(dvdStoreServiceModel);
    }

//    @PatchMapping("/{id}")
//    public boolean patch(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO){
//        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(
//                                                            Optional.ofNullable(id),
//                                                            dvdStoreDTO.name(),
//                                                            dvdStoreDTO.genre(),
//                                                            dvdStoreDTO.quantity(),
//                                                            dvdStoreDTO.price()
//                                                    );
//        return dvdStoreService.patch(dvdStoreServiceModel);
//    }

    @PutMapping("/{id}")
    public boolean put(@PathVariable("id") Long id, @RequestBody DvdStoreDTO dvdStoreDTO){
        DvdStoreServiceModel dvdStoreServiceModel = DvdDtoMapper.INSTANCE.dvdGetDTOToDvdServiceModel(dvdStoreDTO);
        // DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.ofNullable(id),dvdStoreDTO.name(),dvdStoreDTO.genre(),dvdStoreDTO.quantity(), dvdStoreDTO.price());
        return dvdStoreService.put(dvdStoreServiceModel);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return dvdStoreService.delete(id);
    }
}

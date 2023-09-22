package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController // N'accepte que des données JSON ou XML
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/dvd")
public class DvdStoreController {

    // Via la constante (final) l'annotation @RequiredArgsConstructor Lombok va injecter le service dans le constructeur

    @Autowired
    private DvdStoreService dvdStoreService;

    @GetMapping
    public List<DvdStoreDTO> findAll(){
        // Retourne un tableau
        List<DvdStoreDTO> dvdStoreDTOS = new ArrayList<>();
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        for(DvdStoreServiceModel dvdStoreServiceModel: dvdStoreServiceModels){
            dvdStoreDTOS.add(new DvdStoreDTO(
                                    dvdStoreServiceModel.getName(),
                                    dvdStoreServiceModel.getGenre(),
                                    dvdStoreServiceModel.getQuantity(),
                                    dvdStoreServiceModel.getPrice()
                    )
            );
        }
        return dvdStoreDTOS;
    }

    @GetMapping("/with-id")
    public List<DvdStoreGetDto> findAllWithId(){
        List<DvdStoreGetDto> dvdStoreGetDtos = new ArrayList<>();
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        for(DvdStoreServiceModel dvdStoreServiceModel: dvdStoreServiceModels){
            dvdStoreGetDtos.add(new DvdStoreGetDto(
                    dvdStoreServiceModel.getId().get(),
                    dvdStoreServiceModel.getName(),
                    dvdStoreServiceModel.getGenre(),
                    dvdStoreServiceModel.getQuantity(),
                    dvdStoreServiceModel.getPrice(),
                    dvdStoreServiceModel.getFilename()
                    )
            );
        }
        return dvdStoreGetDtos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreGetDto> findById(@PathVariable("id") Long id) throws DvdNotFoundException {
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        if(dvdStoreServiceModel != null){
            return new ResponseEntity<DvdStoreGetDto>(new DvdStoreGetDto(
                    dvdStoreServiceModel.getId().get(),
                    dvdStoreServiceModel.getName(),
                    dvdStoreServiceModel.getGenre(),
                    dvdStoreServiceModel.getQuantity(),
                    dvdStoreServiceModel.getPrice(),
                    dvdStoreServiceModel.getFilename()
            ), HttpStatus.OK);
        } else {
            //return new ResponseEntity<>("n'existe pas",HttpStatus.NOT_FOUND);
            throw new DvdNotFoundException();
        }
    }

    @PostMapping
    public boolean addDvdStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(dvdStoreDTO.name(),dvdStoreDTO.genre(),dvdStoreDTO.quantity(),dvdStoreDTO.price());
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
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.ofNullable(id),dvdStoreDTO.name(),dvdStoreDTO.genre(),dvdStoreDTO.quantity(), dvdStoreDTO.price());
        return dvdStoreService.put(dvdStoreServiceModel);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return dvdStoreService.delete(id);
    }
}

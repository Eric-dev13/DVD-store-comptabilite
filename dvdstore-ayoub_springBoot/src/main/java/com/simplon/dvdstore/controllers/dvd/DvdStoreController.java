package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import com.simplon.dvdstore.services.dvd.DvdServiceMapper;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController // N'accepte que des données JSON ou XML
@RequestMapping("api/dvd")
public class DvdStoreController {

    @Autowired
    private DvdStoreService dvdStoreService;

    @GetMapping
    public List<DvdStoreGetDto> findAll(){
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        return dvdStoreServiceModels.stream().map(DvdDtoMapper.INSTANCE::dvdServiceModelToDvdGetDTO).collect(Collectors.toList());
    }

    //
    // @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreGetDto> findById(@PathVariable("id") Long id) throws DvdNotFoundException {
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        if(dvdStoreServiceModel != null){
            // MAPPAGE AVEC MapStruct
            DvdStoreGetDto dvdStoreGetDto = DvdDtoMapper.INSTANCE.dvdServiceModelToDvdGetDTO(dvdStoreServiceModel);

            // Créer et renvoyer une ResponseEntity avec le DvdGetDTO en tant que corps
            return ResponseEntity.ok(dvdStoreGetDto);
        } else {
            // return new ResponseEntity<>("n'existe pas",HttpStatus.NOT_FOUND);
            return ResponseEntity.notFound().build();
        }
    }

//    @PostMapping("/add")
//    public boolean addDvdStore(@RequestBody DvdStoreDTO dvdStoreDTO) {
//        DvdStoreServiceModel dvdStoreServiceModel = DvdDtoMapper.INSTANCE.dvdGetDTOToDvdServiceModel(dvdStoreDTO);
//        return dvdStoreService.addDvdStore(dvdStoreServiceModel);
//    }

    @PostMapping
    public boolean addDvd(
            @RequestPart("mediaFile") Optional<MultipartFile> mediaFile,
            @RequestParam("name") String name,
            @RequestParam("genre") String genre,
            @RequestParam("realisateur") String realisateur,
            @RequestParam("acteur") String acteur,
            @RequestParam("quantity") int quantity,
            @RequestParam("price") Float price,
            @RequestParam("synopsis") String synopsis
    ) throws IOException {

        // MAPPAGE AVEC MapStruct
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.empty(),name,genre,realisateur,acteur,quantity,price,Optional.empty(),synopsis);

        // Si un fichier a été envoyé.
        if(!mediaFile.isEmpty()) {
            if(dvdStoreService.fileUpload(mediaFile.get())){
                // PERSISTANCE DES DONNEES EN BDD
                dvdStoreServiceModel.setFilename(Optional.ofNullable(mediaFile.get().getOriginalFilename()));
            }
        }

        // PERSISTANCE DES DONNEES EN BDD
        return dvdStoreService.addDvd(dvdStoreServiceModel);

    }


    @PutMapping("/{id}")
    public boolean put( @PathVariable("id") Long id,
                        @RequestPart("mediaFile") Optional<MultipartFile> mediaFile,
                        @RequestParam("name") String name,
                        @RequestParam("genre") String genre,
                        @RequestParam("realisateur") String realisateur,
                        @RequestParam("acteur") String acteur,
                        @RequestParam("quantity") int quantity,
                        @RequestParam("price") Float price,
                        @RequestParam("filename") String filename,
                        @RequestParam("synopsis") String synopsis)throws IOException {
        // MAPPAGE AVEC MapStruct
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(Optional.ofNullable(id),name,genre,realisateur,acteur,quantity,price,Optional.ofNullable(filename),synopsis);
        // Si un fichier a été envoyé.
        if(!mediaFile.isEmpty()) {
            if(dvdStoreService.fileUpload(mediaFile.get())){
                // MAPPAGE AVEC MapStruct
                // PERSISTANCE DES DONNEES EN BDD
                dvdStoreServiceModel.setFilename(Optional.ofNullable(mediaFile.get().getOriginalFilename()));
            }
        }

        // PERSISTANCE DES DONNEES EN BDD
        return dvdStoreService.updateDvd(dvdStoreServiceModel);
    }

    @DeleteMapping("{id}")
    public boolean delete(@PathVariable("id") Long id){
        return dvdStoreService.delete(id);
    }
}

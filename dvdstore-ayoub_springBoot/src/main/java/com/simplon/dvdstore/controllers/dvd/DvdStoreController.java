package com.simplon.dvdstore.controllers.dvd;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.dvd.DvdStoreService;
import com.simplon.dvdstore.services.dvd.DvdStoreServiceModel;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController // N'accepte que des données JSON ou XML
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("api/dvd")
public class DvdStoreController {

    private final DvdStoreService dvdStoreService;

    private final DvdDtoMapper dvdDtoMapper;

    @GetMapping
    public List<DvdStoreGetDto> findAll(){
        List<DvdStoreServiceModel> dvdStoreServiceModels = dvdStoreService.findAll();
        return dvdStoreServiceModels.stream().map((value) -> dvdDtoMapper.toDto(value)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreGetDto> findById(@PathVariable("id") Long id) throws DvdNotFoundException {
        DvdStoreServiceModel dvdStoreServiceModel = dvdStoreService.finById(id);
        if(dvdStoreServiceModel != null){
            DvdStoreGetDto dvdStoreGetDto = dvdDtoMapper.toDto(dvdStoreServiceModel);

            // Créer et renvoyer une ResponseEntity avec le DvdGetDTO en tant que corps
            return ResponseEntity.ok(dvdStoreGetDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public boolean addDvd(
            @RequestPart("mediaFile") Optional<MultipartFile> mediaFile,
            @RequestParam("name") String name,
            @RequestParam("genre") String genre,
            @RequestParam("realisateur") String realisateur,
            @RequestParam("acteur") String acteur,
            @RequestParam(value = "quantity", defaultValue = "0") int quantity,
            @RequestParam(value = "price",defaultValue = "0") Float price,
            @RequestParam("synopsis") String synopsis
    ) throws IOException {

        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(null,name,genre,realisateur,acteur,quantity,price,null,synopsis);

        // Si un fichier a été envoyé.
        if(mediaFile.isPresent()){
            if(dvdStoreService.fileUpload(mediaFile.get())){
                // PERSISTANCE DES DONNEES EN BDD
                dvdStoreServiceModel.setFilename(mediaFile.get().getOriginalFilename());
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
        DvdStoreServiceModel dvdStoreServiceModel = new DvdStoreServiceModel(null,name,genre,realisateur,acteur,quantity,price,filename,synopsis);
        // Si un fichier a été envoyé.
        if(!mediaFile.isPresent()) {
            if(dvdStoreService.fileUpload(mediaFile.get())){
                dvdStoreServiceModel.setFilename(mediaFile.get().getOriginalFilename());
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

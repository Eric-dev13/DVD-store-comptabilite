package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DvdStoreService {

    private final DvdRepository dvdStoreRepository;

    private final DvdServiceMapper dvdServiceMapper;


    public List<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
       return  dvdStoreRepository.findAll().stream().map((value)-> dvdServiceMapper.toServiceModel(value)).collect(Collectors.toList());
    }


    public DvdStoreServiceModel finById(Long id) {
        Optional<DvdStoreRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);
        if(dvdRepositoryModel.isPresent())
        {
            return dvdServiceMapper.toServiceModel(dvdRepositoryModel.get());
        }
        return null;
    }


    public boolean delete(Long id) {
        if(dvdStoreRepository.existsById(id)){
            dvdStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean put(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = dvdServiceMapper.toRepositoryModel(dvdStoreServiceModel);
            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }


    public boolean fileUpload(MultipartFile mediaFile) throws IOException {
        /* ***************************************************** */
        /*                   TELEVERSE LE FICHIER                */
        /* ***************************************************** */

        // Obtient le nom de fichier original à partir de l'objet MultipartFile
        String originalFilename = mediaFile.getOriginalFilename();

        // Récupérer le répertoire public absolu
        Path publicDirectory = Paths.get(".", "public/upload").toAbsolutePath();

        // Créer le chemin complet du fichier à enregistrer dans le dossier upload du répertoire public
        Path filepath = Paths.get(publicDirectory.toString(), originalFilename);

        // Lire le contenu du fichier en bytes
        byte[] imageContent = mediaFile.getBytes();

        try (OutputStream os = Files.newOutputStream(filepath)) {
            // Écrire le contenu du fichier dans le chemin spécifié
            os.write(imageContent);
            return true;
        } catch (IOException e) {
            // En cas d'erreur lors de l'écriture du fichier, afficher la trace d'erreur
            e.printStackTrace();
            return false;
        }
    }

    public boolean addDvd(DvdStoreServiceModel dvd) {
        DvdStoreRepositoryModel dvdStoreRepositoryModel = dvdServiceMapper.toRepositoryModel(dvd);

       Object objet = dvdStoreRepository.save(dvdStoreRepositoryModel);
       return objet != null;
    }

    public boolean updateDvd(DvdStoreServiceModel dvd) {
        DvdStoreRepositoryModel dvdStoreRepositoryModel = dvdServiceMapper.toRepositoryModel(dvd);

        Object objet = dvdStoreRepository.save(dvdStoreRepositoryModel);
        return objet != null;
    }

}

package com.simplon.dvdstore.services.dvd;

import com.simplon.dvdstore.repositories.dvd.DvdRepository;
import com.simplon.dvdstore.repositories.dvd.DvdStoreRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
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


@Service
public class DvdStoreService {

    @Autowired
    private DvdRepository dvdStoreRepository;


    DvdServiceMapper dvdServiceMapper = DvdServiceMapper.INSTANCE;

    public List<DvdStoreServiceModel> findAll() {
        // Retourne un tableau
        /*
        var dvdStoreServiceModels = dvdStoreRepository.findAll().stream().map((value) -> dvdServiceMapper.DvdStoreRepositoryModelToDvdStoreServiceModel(value)).collect(Collectors.toList());
        */
        return dvdStoreRepository.findAll().stream().map(dvdServiceMapper::DvdStoreRepositoryModelToDvdStoreServiceModel).collect(Collectors.toList());
    }


    public DvdStoreServiceModel finById(Long id) {
        Optional<DvdStoreRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if(dvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return dvdServiceMapper.DvdStoreRepositoryModelToDvdStoreServiceModel(dvdRepositoryModel.get());
        }
    }

//    public boolean addDvdStore(DvdStoreServiceModel dvdStoreServiceModel) {
//        DvdStoreRepositoryModel modelRepository = dvdServiceMapper.dvdStoreServiceModelToDvdStoreRepositoryModel(dvdStoreServiceModel);
//        Object object = dvdStoreRepository.save(modelRepository);
//        return object != null;
//    }

    public boolean delete(Long id) {
        if(dvdStoreRepository.existsById(id)){
            dvdStoreRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean put(DvdStoreServiceModel dvdStoreServiceModel) {
        Long id = dvdStoreServiceModel.getId().get();
        if(dvdStoreRepository.existsById(id)){
            DvdStoreRepositoryModel repositoryModel = dvdServiceMapper.dvdStoreServiceModelToDvdStoreRepositoryModel(dvdStoreServiceModel);
            Object object = dvdStoreRepository.save(repositoryModel);
            return object != null;
        }
        return false;
    }


//    public boolean addDvd(MultipartFile mediaFile, String name, String genre, String realisateur, String acteur, int quantity, Float price, String synopsis) throws IOException {
//        // Si un fichier a été envoyé.
//        if(mediaFile != null) {
//           if(this.fileUpload(mediaFile)){
//               // PERSISTANCE DES DONNEES EN BDD
//               return this.updateDvd(name, genre, realisateur, acteur, quantity, price, synopsis ,Optional.ofNullable(mediaFile.getOriginalFilename()));
//           }
//        } else {
//            // PERSISTANCE DES DONNEES EN BDD
//            return this.updateDvd(name, genre, realisateur, acteur, quantity, price, synopsis, Optional.empty());
//        }
//        return false;
//    }

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
        /* ***************************************************** */
        /*                PERSISTE LES DONNEES EN BDD            */
        /* ***************************************************** */
        DvdStoreRepositoryModel dvdStoreRepositoryModel = DvdServiceMapper.INSTANCE.dvdStoreServiceModelToDvdStoreRepositoryModel(dvd);

        Object objet = dvdStoreRepository.save(dvdStoreRepositoryModel);
        return objet != null;
    }

    public boolean updateDvd(DvdStoreServiceModel dvd) {
        /* ***************************************************** */
        /*                PERSISTE LES DONNEES EN BDD            */
        /* ***************************************************** */
        DvdStoreRepositoryModel dvdStoreRepositoryModel = DvdServiceMapper.INSTANCE.dvdStoreServiceModelToDvdStoreRepositoryModel(dvd);

        Object objet = dvdStoreRepository.save(dvdStoreRepositoryModel);
        return objet != null;
    }

}

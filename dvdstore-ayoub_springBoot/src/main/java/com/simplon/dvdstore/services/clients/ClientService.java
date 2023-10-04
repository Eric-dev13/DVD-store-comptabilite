package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientServiceMapper clientServiceMapper;

    public List<ClientServiceModel> findAll() {
        return clientServiceMapper.listClientRepositoryToListClientService(clientRepository.findAll());
    }

    public boolean create(ClientServiceModel clientServiceModel) {
        Object object = clientRepository.save(clientServiceMapper.clientServiceToClientRepository(clientServiceModel));
        return object != null;
    }

    public ClientServiceModel findById(Long id) {
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(id);
        if(clientRepositoryModel.isPresent()){
            return clientServiceMapper.clientRepositoryToClientService(clientRepositoryModel.get());
        }
        return null;
//        Set<VenteRepositoryModel> venteRepositoryModel =  clientRepositoryModel.getVenteRepositoryModels();
//        venteRepositoryModel.forEach((vente) -> {
//            System.out.println(vente.toString());
//        });

    }

    public boolean deleteById(Long id) {
        if(clientRepository.existsById(id)){
            clientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean update(ClientServiceModel clientServiceModel) {
        Object object = clientRepository.save(clientServiceMapper.clientServiceToClientRepositoryWithId(clientServiceModel));
        return object != null;
    }
}

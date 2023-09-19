package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
        return clientServiceMapper.clientRepositoryToClientService(clientRepository.findById(id).get()) ;
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

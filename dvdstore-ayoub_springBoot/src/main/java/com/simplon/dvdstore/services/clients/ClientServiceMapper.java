package com.simplon.dvdstore.services.clients;

import com.simplon.dvdstore.repositories.clients.ClientRepositoryModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceMapper {

    public ClientRepositoryModel clientServiceToClientRepository(ClientServiceModel clientServiceModel) {
        return new ClientRepositoryModel(clientServiceModel.getFirstname(), clientServiceModel.getLastname(),clientServiceModel.getAddress());
    }

    public ClientRepositoryModel clientServiceToClientRepositoryWithId(ClientServiceModel clientServiceModel) {
        return new ClientRepositoryModel(clientServiceModel.getId().get(), clientServiceModel.getFirstname(), clientServiceModel.getLastname(),clientServiceModel.getAddress());
    }

    public List<ClientRepositoryModel> listClientServiceToListClientRepository(List<ClientServiceModel> clientServiceModels){

        List<ClientRepositoryModel> clientRepositoryModels = new ArrayList<>();

        for(ClientServiceModel clientServiceModel: clientServiceModels){
            clientRepositoryModels.add(new ClientRepositoryModel(clientServiceModel.getFirstname(), clientServiceModel.getLastname(),clientServiceModel.getAddress()));
        }
        return clientRepositoryModels;
    }

    public ClientServiceModel clientRepositoryToClientService(ClientRepositoryModel clientRepositoryModel){
        return new ClientServiceModel(Optional.ofNullable(clientRepositoryModel.getId()),clientRepositoryModel.getFirstname(),clientRepositoryModel.getLastname() ,clientRepositoryModel.getAddress());
    }

    public List<ClientServiceModel> listClientRepositoryToListClientService(List<ClientRepositoryModel> clientRepositoryModels){

        List<ClientServiceModel> clientServiceModels = new ArrayList<>();

        for(ClientRepositoryModel clientRepositoryModel: clientRepositoryModels){
            clientServiceModels.add(new ClientServiceModel(Optional.ofNullable(clientRepositoryModel.getId()),clientRepositoryModel.getFirstname(), clientRepositoryModel.getLastname(), clientRepositoryModel.getAddress()));
        }
        return clientServiceModels;
    }

}

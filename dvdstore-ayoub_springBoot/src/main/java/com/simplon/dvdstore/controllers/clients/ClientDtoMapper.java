package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.services.clients.ClientServiceModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientDtoMapper {

    public ClientServiceModel clientDtoToClientService(ClientDTO clientDTO){
        return new ClientServiceModel(clientDTO.firstname(),clientDTO.lastname(),clientDTO.address());
    }

    public ClientServiceModel clientDtoToClientServiceWithId(Long id, ClientDTO clientDTO){
        return new ClientServiceModel(Optional.ofNullable(id), clientDTO.firstname(), clientDTO.lastname(), clientDTO.address());
    }

    public List<ClientServiceModel> listClientDtoToListClientService(List<ClientDTO> clientDTOS){

        List<ClientServiceModel> clientServiceModels = new ArrayList<>();

        for(ClientDTO clientDTO: clientDTOS){
            clientServiceModels.add(new ClientServiceModel(clientDTO.firstname(), clientDTO.lastname(),clientDTO.address()));
        }
        return clientServiceModels;
    }

    public ClientGetDTO clientServiceToclientDto(ClientServiceModel clientServiceModel){
        return new ClientGetDTO(clientServiceModel.getId().get(),clientServiceModel.getFirstname(), clientServiceModel.getLastname(),clientServiceModel.getAddress());
    }

    public List<ClientGetDTO> listClientServiceToListClientDto(List<ClientServiceModel> clientServiceModels){

        List<ClientGetDTO> clientGetDTOS = new ArrayList<>();

        for(ClientServiceModel clientServiceModel: clientServiceModels){
            clientGetDTOS.add(new ClientGetDTO(clientServiceModel.getId().get(), clientServiceModel.getFirstname(), clientServiceModel.getLastname(),clientServiceModel.getAddress()));
        }
        return clientGetDTOS;
    }

}

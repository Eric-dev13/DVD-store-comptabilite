package com.simplon.dvdstore.controllers.clients;

import com.simplon.dvdstore.repositories.ventes.VenteRepository;
import com.simplon.dvdstore.repositories.ventes.VenteRepositoryModel;
import com.simplon.dvdstore.services.clients.ClientService;
import com.simplon.dvdstore.services.clients.ClientServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin("http://localhost:4200")
@RequestMapping("api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private ClientDtoMapper clientDtoMapper;

    @GetMapping
    public List<ClientGetDTO> findAll(){
        return clientDtoMapper.listClientServiceToListClientDto(clientService.findAll());
    }

    @PostMapping
    public boolean create(@RequestBody ClientDTO clientDTO){
        return clientService.create(clientDtoMapper.clientDtoToClientService(clientDTO));
    }

    @GetMapping("/{id}")
    public ClientGetDTO findById(@PathVariable("id") Long id){
        return clientDtoMapper.clientServiceToclientDto(clientService.findById(id)) ;
    }

     @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody ClientDTO clientDTO) {
        return clientService.update(clientDtoMapper.clientDtoToClientServiceWithId(id,clientDTO));
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return clientService.deleteById(id);
    }


}

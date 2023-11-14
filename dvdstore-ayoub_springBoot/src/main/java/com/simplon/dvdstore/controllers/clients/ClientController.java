package com.simplon.dvdstore.controllers.clients;


import com.simplon.dvdstore.services.clients.ClientService;
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
    private com.simplon.dvdstore.controllers.clients.ClientDtoMapper clientDtoMapper;

    @GetMapping
    public List<com.simplon.dvdstore.controllers.clients.ClientGetDTO> findAll(){
        return clientDtoMapper.listClientServiceToListClientDto(clientService.findAll());
    }

    @PostMapping
    public boolean create(@RequestBody com.simplon.dvdstore.controllers.clients.ClientDTO clientDTO){
        return clientService.create(clientDtoMapper.clientDtoToClientService(clientDTO));
    }

    @GetMapping("/{id}")
    public com.simplon.dvdstore.controllers.clients.ClientGetDTO findById(@PathVariable("id") Long id){
        return clientDtoMapper.clientServiceToclientDto(clientService.findById(id)) ;
    }

     @PutMapping("/{id}")
    public boolean update(@PathVariable("id") Long id, @RequestBody com.simplon.dvdstore.controllers.clients.ClientDTO clientDTO) {
        return clientService.update(clientDtoMapper.clientDtoToClientServiceWithId(id,clientDTO));
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable("id") Long id) {
        return clientService.deleteById(id);
    }


}

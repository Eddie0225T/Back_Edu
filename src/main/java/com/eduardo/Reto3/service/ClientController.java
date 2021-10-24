/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Eduardo
 */
@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins= "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/all")
    public List<Client> getClients() {
        return clientService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Client> getClient(@PathVariable("id") int idClient) {
        return clientService.getClient(idClient);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save(@RequestBody Client client) {
        return clientService.save(client);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client update(@RequestBody Client client){
        return clientService.update(client);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int clientId){
        return clientService.deleteClient(clientId);
    }
}

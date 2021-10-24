/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduardo.Reto3.service;

import com.eduardo.Reto3.dao.ClientRepository;
import com.eduardo.Reto3.entities.Client;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo
 */
@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAll() {return (List<Client>) clientRepository.getAll();};
  
    public Optional<Client> getClient(int id) {return clientRepository.getClient(id);};
  
    public Client save(Client client) { 
        if (client.getIdClient()== null){
           return clientRepository.save(client);
        }else{
            Optional<Client> co =  clientRepository.getClient(client.getIdClient());
            if (co.isEmpty()){
                return clientRepository.save(client);
            }else{
                return client;
            }
        }
    }
  
    public Client update (Client client){
        if(client.getIdClient()!=null){
            Optional<Client> cl= clientRepository.getClient(client.getIdClient());
            if(!cl.isEmpty()){
                if(client.getName()!=null){
                    cl.get().setName(client.getName());
                }
                if(client.getAge()!=null){
                    cl.get().setAge(client.getAge());
                }
                if(client.getPassword()!=null){
                    cl.get().setPassword(client.getPassword());
                }
                clientRepository.save(cl.get()); 
                return cl.get();
            }else{
                return client;
            }
        }else{
            return client;
        }          
    } 
    
    public boolean deleteClient(int clientId){
        Boolean aBoolean = getClient(clientId).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}

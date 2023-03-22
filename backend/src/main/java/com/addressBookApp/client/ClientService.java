package com.addressBookApp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getClient() {
        return clientRepository.findAll();
    }

    public void addClient(Client client) {
        Optional<Client> clientOptional = clientRepository
                .findClientByEmail(client.getEmail());
        if(clientOptional.isPresent()){
            throw new IllegalStateException("email taken");
        }
        clientRepository.save(client);
    }

    public void deleteClient(Integer clientId) {
        boolean exists = clientRepository.existsById(clientId);
        if(!exists) {
            throw new IllegalStateException("client with id " + clientId + " dose not exists");
        }
        clientRepository.deleteById(clientId);
    }
}

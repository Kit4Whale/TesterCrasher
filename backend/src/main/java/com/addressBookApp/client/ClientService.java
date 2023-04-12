package com.addressBookApp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Page<Client> getClient(Integer limit) {
        return clientRepository.findAll(PageRequest.ofSize(limit));
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

    @Transactional
    public void updateClient(Integer clientId,
                             Client client) {
        Client clientRep = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalStateException(
                        "clientRep with id " + clientId + " dose not exists"));

        if(client.getFullname() != null &&
                client.getFullname().length() > 0 &&
                !Objects.equals(clientRep.getFullname(), client.getFullname())) {
            clientRep.setFullname(client.getFullname());
        }

        if(client.getAddress() != null &&
                client.getAddress().length() > 0 &&
                !Objects.equals(clientRep.getAddress(), client.getAddress())) {
            clientRep.setAddress(client.getAddress());
        }

        if(client.getEmail() != null &&
                client.getEmail().length() > 0 &&
                !Objects.equals(clientRep.getEmail(), client.getEmail())) {
            Optional<Client> clientOptional = clientRepository.findClientByEmail(client.getEmail());
            if(clientOptional.isPresent()) {
                throw  new IllegalStateException("email taken");
            }
            clientRep.setEmail(client.getEmail());
        }

        if(client.getPhone_number() != null &&
                client.getPhone_number().length() > 0 &&
                !Objects.equals(clientRep.getPhone_number(), client.getPhone_number())) {
            Optional<Client> clientOptional = clientRepository.findClientByPhone(client.getPhone_number());
            if(clientOptional.isPresent()) {
                throw  new IllegalStateException("phone number taken");
            }
            clientRep.setPhone_number(client.getPhone_number());
        }

        if(client.getGroup() != null &&
                client.getGroup().length() > 0 &&
                !Objects.equals(clientRep.getGroup(), client.getGroup())) {
            clientRep.setGroup(client.getGroup());
        }

    }

}

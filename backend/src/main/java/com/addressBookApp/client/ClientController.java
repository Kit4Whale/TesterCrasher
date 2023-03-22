package com.addressBookApp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "api/v1/clients")
    public List<Client> getClient() {
        return clientService.getClient();
    }

    @PostMapping(path = "api/v1/clients/create")
    public void addNewClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping(path = "api/v1/clients/{clientID}")
    public void deleteClient(@PathVariable("clientID") Integer clientId) {
        clientService.deleteClient(clientId);
    }
}

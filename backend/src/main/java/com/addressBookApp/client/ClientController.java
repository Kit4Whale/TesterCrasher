package com.addressBookApp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "api/v1/clients")
    public Page<Client> getClient(
            @RequestParam("limit") Integer limit) {
        return clientService.getClient(limit);
    }

    @PostMapping(path = "api/v1/clients/create")
    public void addNewClient(@RequestBody Client client) {
        clientService.addClient(client);
    }

    @DeleteMapping(path = "api/v1/clients/{clientID}")
    public void deleteClient(@PathVariable("clientID") Integer clientId) {
        clientService.deleteClient(clientId);
    }

    @PostMapping(path = "api/v1/clients/update/{clientID}")
    public void updateClient(
            @PathVariable("clientID") Integer clientId,
            @RequestBody Client client) {
        clientService.updateClient(clientId, client);
    }
}

package com.addressBookApp.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getClient() {
        return clientService.getClient();
    }

    @PostMapping
    public void addNewClient(@RequestBody Client client) {
        clientService.addClient(client);
    }
}

package com.addressBookApp.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ClientConfig {

    @Bean
    CommandLineRunner commandLineRunner1(ClientRepository repository1) {
        return args -> {
            Client ivan = new Client(
                    "Ivanov Ivan",
                    "Batumi",
                    "ivanov@gmail.com",
                    "88005533535",
                    "test-group 1"
            );
            Client alex = new Client(
                    "Alexandrov Alex",
                    "Tbilisi",
                    "alexandrov@gmail.com",
                    "88005533536",
                    "test-group 2"
            );

            repository1.saveAll(
                    List.of(ivan, alex)
            );
        };
    }
}

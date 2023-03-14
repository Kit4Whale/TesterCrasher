package com.addressBookApp.group;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class GroupConfig {

    @Bean
    CommandLineRunner commandLineRunner3(GroupRepository repository3) {
        return args -> {
            Group batumi = new Group(
                    "test-group 1"
            );
            Group tbilisi = new Group(
                    "test-group 2"
            );

            repository3.saveAll(
                    List.of(batumi, tbilisi)
            );
        };
    }
}

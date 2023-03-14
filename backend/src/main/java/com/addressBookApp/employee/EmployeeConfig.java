package com.addressBookApp.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner2(EmployeeRepository repository2) {
        return args -> {
            Employee petr = new Employee(
                    "Petrov Petr",
                    "petrov-p"
            );
            Employee igor = new Employee(
                    "Igorev Igor",
                    "igorev-i"
            );
            repository2.saveAll(
                    List.of(petr, igor)
            );
        };
    }
}

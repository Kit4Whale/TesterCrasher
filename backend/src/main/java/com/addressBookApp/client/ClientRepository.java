package com.addressBookApp.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("Select c from Client c where c.email = ?1")
    Optional<Client> findClientByEmail(String email);

    @Query("Select c from Client c where c.phone_number = ?1")
    Optional<Client> findClientByPhone(String phone_number);

}

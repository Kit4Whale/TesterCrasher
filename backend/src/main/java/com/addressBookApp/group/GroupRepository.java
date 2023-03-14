package com.addressBookApp.group;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Integer> {

    @Query("select g from Group g where g.name = ?1")
    Optional<Group> findGroupByName(String name);
}

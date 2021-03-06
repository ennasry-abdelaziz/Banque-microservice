package com.rma.banque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rma.banque.entities.Client;

@RepositoryRestResource
public interface ClientRepository extends JpaRepository<Client, Long> {

}

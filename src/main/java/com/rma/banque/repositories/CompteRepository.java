package com.rma.banque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.rma.banque.entities.Compte;
import com.rma.banque.entities.TypeCompte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long> {

	@RestResource(path="byType")
	public List<Compte> findByType(@Param("t") TypeCompte type);
}

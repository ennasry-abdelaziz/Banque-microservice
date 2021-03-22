package com.rma.banque;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.rma.banque.entities.Client;
import com.rma.banque.entities.Compte;
import com.rma.banque.entities.TypeCompte;
import com.rma.banque.repositories.ClientRepository;
import com.rma.banque.repositories.CompteRepository;

@SpringBootApplication
public class BanqueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BanqueMicroserviceApplication.class, args);
	}
	@Bean
	CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration configuration ) {
		return args -> {
			configuration.exposeIdsFor(Compte.class);
			Client c1 = clientRepository.save(new Client(null, "Hassan", null));
			Client c2 = clientRepository.save(new Client(null, "Mohamed", null));

			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c1));
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.COURANT, c2));
			compteRepository.save(new Compte(null, Math.random()*9000, new Date(), TypeCompte.EPARGNE, c1));
			compteRepository.findAll().forEach(c -> {
			System.out.println(c.getSolde());
			});
		};
	}
}

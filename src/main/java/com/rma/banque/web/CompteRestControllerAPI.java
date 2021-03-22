package com.rma.banque.web;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rma.banque.entities.Compte;
import com.rma.banque.repositories.CompteRepository;

@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {

	@Autowired
	private CompteRepository compteRepository;
	
	@GetMapping(path="/comptes", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public List<Compte> compteList(){
		return compteRepository.findAll();
	}
	
	@GetMapping(path="/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Compte getOne(@PathVariable Long id){
		return compteRepository.findById(id).get();
	}
	
	@PostMapping(path="/comptes", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Compte save(@RequestBody Compte compte){
		return compteRepository.save(compte);
	}
	
	@PutMapping(path="/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Compte update(@RequestBody Compte compte, @PathVariable Long id){
		compte.setId(id);
		return compteRepository.save(compte);
	}
	
	@DeleteMapping(path="/comptes/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public void delete(@PathVariable Long id){
		 compteRepository.deleteById(id);;
	}
	
	public CompteRestControllerAPI() {
		// TODO Auto-generated constructor stub
	}

}

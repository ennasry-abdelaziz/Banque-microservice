package com.rma.banque.web;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rma.banque.entities.Compte;
import com.rma.banque.repositories.CompteRepository;

//@Component
//@Path("/banque")
public class CompteRestJaxRSAPI {

	@Autowired
	private CompteRepository compteRepository;
	
	@Path("/comptes")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Compte> compteList(){
		return compteRepository.findAll();
	}
	
	@Path("/comptes/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Compte getOne(@PathParam (value="id") Long id){
		return compteRepository.findById(id).get();
	}
	
	@Path("/comptes")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Compte save(Compte compte){
		return compteRepository.save(compte);
	}
	
	@Path("/comptes/{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Compte update(Compte compte, @PathParam (value="id") Long id){
		compte.setId(id);
		return compteRepository.save(compte);
	}
	
	@Path("/comptes/{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public void delete(@PathParam (value="id") Long id){
		 compteRepository.deleteById(id);;
	}
	
	public CompteRestJaxRSAPI() {
		// TODO Auto-generated constructor stub
	}

}

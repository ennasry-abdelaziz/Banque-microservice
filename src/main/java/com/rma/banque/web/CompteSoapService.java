package com.rma.banque.web;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
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

@Component
@WebService(serviceName = "banqueWS")
public class CompteSoapService {

	@Autowired
	private CompteRepository compteRepository;
	
	
	@WebMethod
	public List<Compte> compteList(){
		return compteRepository.findAll();
	}
	
	@WebMethod
	public Compte getOne(@WebParam(name="id") Long id){
		return compteRepository.findById(id).get();
	}
	
	
	public CompteSoapService() {
		// TODO Auto-generated constructor stub
	}

}

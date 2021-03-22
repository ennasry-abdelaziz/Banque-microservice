package com.rma.banque.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.xml.bind.XmlAccessorFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
public class Compte {
	@Id @GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	private double solde;
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Enumerated(EnumType.STRING) 
	private TypeCompte type;
	@ManyToOne
	private Client client;
	public Compte(Long id, double solde, Date dateCreation, TypeCompte type, Client client) {
		super();
		this.id = id;
		this.solde = solde;
		this.dateCreation = dateCreation;
		this.type = type;
		this.client = client;
	}
	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "Compte [id=" + id + ", solde=" + solde + ", dateCreation=" + dateCreation + ", type=" + type
				+ ", client=" + client + ", getId()=" + getId() + ", getSolde()=" + getSolde() + ", getDateCreation()="
				+ getDateCreation() + ", getType()=" + getType() + ", getClient()=" + getClient() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public TypeCompte getType() {
		return type;
	}
	public void setType(TypeCompte type) {
		this.type = type;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	


}

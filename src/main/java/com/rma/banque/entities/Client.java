package com.rma.banque.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
//@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Client {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@OneToMany(mappedBy = "client")
	@XmlTransient @JsonIgnore
	private Collection<Compte> comptes;
	
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", comptes=" + comptes + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getComptes()=" + getComptes() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(Long id, String name, Collection<Compte> comptes) {
		super();
		this.id = id;
		this.name = name;
		this.comptes = comptes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Compte> getComptes() {
		return comptes;
	}
	public void setComptes(Collection<Compte> comptes) {
		this.comptes = comptes;
	}
	
//	public Client() {
//		// TODO Auto-generated constructor stub
//	}

}

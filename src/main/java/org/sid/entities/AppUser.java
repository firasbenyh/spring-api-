package org.sid.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.List;

@Entity

public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String prenom;
	private String email;
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	private String numTel;
	private boolean petsitter;
	private boolean client;
	private boolean actived;
	@OneToMany(mappedBy = "petsitter", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Rdv> rdvs;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private List<Rdv> rdvclient;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	

	public boolean isPetsitter() {
		return petsitter;
	}

	public void setPetsitter(boolean petsitter) {
		this.petsitter = petsitter;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public List<Rdv> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<Rdv> rdvs) {
		this.rdvs = rdvs;
	}

	public boolean isClient() {
		return client;
	}

	public void setClient(boolean client) {
		this.client = client;
	}

	public List<Rdv> getRdvclient() {
		return rdvclient;
	}

	public void setRdvclient(List<Rdv> rdvclient) {
		this.rdvclient = rdvclient;
	}

	
	
	
	
	

	
	
	
	
	
	

}

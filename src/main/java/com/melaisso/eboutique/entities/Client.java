package com.melaisso.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Client implements Serializable{


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idClient ;
	private String nomClient;
	private String addresse ;
	private String email;
	private String tel ;
	// ? carteBancaire String numCarte ;
	
	// client <-->1..* Commande 
	@OneToMany(mappedBy="client")
	private Collection<Commande> commandes ;

	
	
	public Client(String nomClient, String addresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.addresse = addresse;
		this.email = email;
		this.tel = tel;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	public String getAddresse() {
		return addresse;
	}

	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Collection<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
	
	
}

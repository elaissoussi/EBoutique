package com.melaisso.eboutique.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande extends BaseEntity {

	
	private Date  dateCommande;
    // commande <--> 0..* ligneCommande	
	@OneToMany(mappedBy="commande")
	private Collection<LigneCommande> items ;
	// commande <--> client 
	@ManyToOne
	@JoinColumn(name="idClient")
	private Client client ;
	
	
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public Collection<LigneCommande> getItems() {
		return items;
	}
	public void setItems(Collection<LigneCommande> items) {
		this.items = items;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	} 
	
	
	
	
	
}

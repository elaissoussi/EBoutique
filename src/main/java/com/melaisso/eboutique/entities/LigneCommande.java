package com.melaisso.eboutique.entities;



import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class LigneCommande  extends BaseEntity{

	
	
	private int quantite ; 
	private double prix ;
	// produit <--> ligneCommande 
	@ManyToOne
	@JoinColumn(name="idProduit")
	private Produit produit ;
	
	@ManyToOne
	@JoinColumn(name="idCommande")
	private Commande commande ;
	
	
	public LigneCommande() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	
	
	
	
	
}

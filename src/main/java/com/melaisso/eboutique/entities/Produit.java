package com.melaisso.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

// table produits 

@Entity
public class Produit  implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idProduit;
	
	@NotEmpty
	@Size(min = 4, max = 15)
	private String designation ;
	
	private String description ;
	private double prix ;
	private int quantite ;
	private String photo ; 
	private boolean selectionne;
	
	// produit <--> 1 categorie
	@ManyToOne
	@JoinColumn(name="idCategorie")
	private Categorie categorie ;
	
	public Produit(String designation, String description, double prix,
			int quantite, String photo, boolean selectionne, Categorie categorie) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.photo = photo;
		this.selectionne = selectionne;
		this.categorie = categorie;
	}

	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public boolean isSelectionne() {
		return selectionne;
	}

	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
	
} 

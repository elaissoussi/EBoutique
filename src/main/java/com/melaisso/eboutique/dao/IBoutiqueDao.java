package com.melaisso.eboutique.dao;

import java.util.List;

import com.melaisso.eboutique.entities.Categorie;
import com.melaisso.eboutique.entities.Client;
import com.melaisso.eboutique.entities.Commande;
import com.melaisso.eboutique.entities.Panier;
import com.melaisso.eboutique.entities.Produit;
import com.melaisso.eboutique.entities.Role;
import com.melaisso.eboutique.entities.User;

public interface IBoutiqueDao {

	// catégorie
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	
	// produit 
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
	// user  
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	
	// commande 
	public Commande enregistrerCommande(Panier p,Client c);
	
}

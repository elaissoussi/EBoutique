package com.melaisso.eboutique.metier;

import java.util.List;

import com.melaisso.eboutique.entities.Categorie;
import com.melaisso.eboutique.entities.Client;
import com.melaisso.eboutique.entities.Commande;
import com.melaisso.eboutique.entities.Panier;
import com.melaisso.eboutique.entities.Produit;

public interface InternauteBoutiqueMetier {

	public List<Categorie> listCategories();

	public Categorie getCategorie(Long idCat);

	public List<Produit> listproduits();

	public List<Produit> produitsParMotCle(String mc);

	public List<Produit> produitsParCategorie(Long idCat);

	public List<Produit> produitsSelectionnes();

	public Produit getProduit(Long idP);

	public Commande enregistrerCommande(Panier p, Client c);

}

package com.melaisso.eboutique.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


import com.melaisso.eboutique.entities.Categorie;
import com.melaisso.eboutique.entities.Client;
import com.melaisso.eboutique.entities.Commande;
import com.melaisso.eboutique.entities.Panier;
import com.melaisso.eboutique.entities.Produit;
import com.melaisso.eboutique.entities.Role;
import com.melaisso.eboutique.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDao {

	@PersistenceContext
	EntityManager em;

	@Override
	public Long ajouterCategorie(Categorie c) {
		em.persist(c);
		return c.getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Categorie> listCategories() {
		Query query = em.createQuery("SELECT c FROM Categorie c");
		return query.getResultList();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		return em.find(Categorie.class, idCat);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		Categorie c = getCategorie(idcat);
		em.remove(c);
	}

	@Override
	public void modifierCategorie(Categorie c) {
		em.merge(c);
	}

	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		Categorie  categorie = getCategorie(idCat);
		p.setCategorie(categorie);
		em.persist(p);
		return p.getId();
	}

	@Override
	public List<Produit> listproduits() {
		Query query = em.createQuery("SELECT p FROM Produit p");
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		Query query = em.createQuery("SELECT p FROM Produit p "
				+ "  where p.designation like :x or p.description like :x");
		query.setParameter("x", mc);
		return query.getResultList();
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {

		Query query = em
				.createQuery("SELECT p FROM Produit p WHERE p.categorie.id=:x ");
		query.setParameter("x", idCat);
		return query.getResultList();

	}

	@Override
	public List<Produit> produitsSelectionnes() {
		Query req = em
				.createQuery("select p from Produit p where p.selectionne=true");
		return req.getResultList();
	}

	@Override
	public Produit getProduit(Long idP) {
		return em.find(Produit.class, idP);
	}

	@Override
	public void supprimerProduit(Long idP) {

		Produit p = getProduit(idP);
		em.remove(p);
	}

	@Override
	public void modifierProduit(Produit p) {
		em.merge(p);
	}

	@Override
	public void ajouterUser(User u) {
		em.persist(u);
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		User u = em.find(User.class, userID);
		r.setUser(u);
		em.persist(r);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		em.persist(c);
		Commande cmd = new Commande();
		cmd.setClient(c);
		cmd.setItems(p.getItems());
		em.persist(cmd);
		return cmd;
	}

}

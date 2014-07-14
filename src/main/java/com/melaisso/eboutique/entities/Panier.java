package com.melaisso.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/**
 * Class non persistent  
 * @author MELAISSO
 *
 */
public class Panier implements Serializable {

	private Map<Long, LigneCommande> items = new HashMap<Long, LigneCommande>();

	// functions utilitaires

	public void addItem(Produit p, int quantite) {
		LigneCommande lignecommande;
		if (items.get(p.getIdProduit()) == null) {
			lignecommande = new LigneCommande();
			lignecommande.setProduit(p);
			lignecommande.setQuantite(quantite);
			lignecommande.setPrix(p.getPrix());

			items.put(p.getIdProduit(), lignecommande);

		} else {

			lignecommande = items.get(p.getIdProduit());
			lignecommande.setQuantite(lignecommande.getQuantite() + quantite);
		}

	}

	public void deleteArticle(Long ref) {
		items.remove(ref);
	}

	public Collection<LigneCommande> getItems() {
		return items.values();
	}

	public double getTotol() {
		double total = 0;

		for (LigneCommande lc : items.values()) {
			total += lc.getPrix() * lc.getQuantite();
		}

		return total;
	}

	public int getSize() {
		return items.size();
	}

}

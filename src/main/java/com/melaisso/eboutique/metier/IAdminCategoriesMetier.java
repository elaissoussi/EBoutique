package com.melaisso.eboutique.metier;

import com.melaisso.eboutique.entities.Categorie;
import com.melaisso.eboutique.entities.Role;
import com.melaisso.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitMetier {

	public Long ajouterCategorie(Categorie c);

	public void supprimerCategrorie(Long idcat);

	public void modifierCategorie(Categorie c);

	public void ajouterUser(User u);

	public void attribuerRole(Role r, Long userID);

}

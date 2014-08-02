package com.melaisso.eboutique.controllers;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.melaisso.eboutique.entities.Produit;
import com.melaisso.eboutique.metier.IAdminProduitMetier;

@Controller
@RequestMapping(value = "/adminProd")
@SessionAttributes("categories")
public class AdminProduitsController {

	// metier
	@Autowired
	IAdminProduitMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {

		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());
		model.addAttribute("categories", metier.listCategories());
		return "produits";

	}

	@RequestMapping(value = "/saveProd")
	public String saveProd(@Valid Produit p, BindingResult bindingResult,
			MultipartFile file, Model model) throws Exception {

		Long idProduit;

		// error handling
		if (bindingResult.hasErrors()) {
			model.addAttribute("produit", new Produit());
			model.addAttribute("produits", metier.listproduits());
			model.addAttribute("categories", metier.listCategories());

			return "produits";
		}

		// ajouter
		if (p.getId() == null) {

			p.setPhoto(file.getOriginalFilename());
			idProduit = metier.ajouterProduit(p, p.getCategorie().getId());
			// add new image file
			if (!file.isEmpty()) {
				String path = System.getProperty("java.io.tmpdir") + "/"
						+ idProduit + "_" + p.getPhoto();
				file.transferTo(new File(path));
			}
		}
		// modifier
		else {
			
			if (!file.isEmpty()) {
				p.setPhoto(file.getOriginalFilename());
				String path = System.getProperty("java.io.tmpdir") + "/"
						+ p.getId() + "_" + p.getPhoto();
				file.transferTo(new File(path));
			}
			
			metier.modifierProduit(p);

		}

		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());

		return "produits";
	}

	// supprimer
	@RequestMapping(value = "/suppProd")
	public String suppProd(Long idProd, Model model) {
		metier.supprimerProduit(idProd);
		model.addAttribute("produit", new Produit());
		model.addAttribute("produits", metier.listproduits());

		return "produits";
	}

	// modifier
	@RequestMapping(value = "/editProd")
	public String editProd(Long idProd, Model model) {
		Produit p = metier.getProduit(idProd);
		model.addAttribute("produit", p);
		model.addAttribute("produits", metier.listproduits());

		return "produits";
	}

	// get image of the products
	@RequestMapping(value = "/photoProd", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idProd) throws Exception {
		Produit prod = metier.getProduit(idProd);
		String path = System.getProperty("java.io.tmpdir") + "/" + idProd+"_"+prod.getPhoto();
		File prodImage = new File(path);

		return IOUtils.toByteArray(new FileInputStream(prodImage));
	}
}

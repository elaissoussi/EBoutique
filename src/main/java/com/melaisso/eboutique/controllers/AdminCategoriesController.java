package com.melaisso.eboutique.controllers;

import java.io.ByteArrayInputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.melaisso.eboutique.entities.Categorie;
import com.melaisso.eboutique.metier.IAdminCategoriesMetier;

@Controller
@RequestMapping(value = "/adminCat")
public class AdminCategoriesController implements HandlerExceptionResolver {

	@Autowired
	private IAdminCategoriesMetier metier;

	@RequestMapping(value = "/index")
	public String index(Model model) {
		// form
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());

		return "categories";
	}

	@RequestMapping(value = "/saveCat")
	public String saveCat(@Valid Categorie c, BindingResult bindingResult,
			MultipartFile file, Model model) throws Exception {

		// error handling
		if (bindingResult.hasErrors()) {
			model.addAttribute("categories", metier.listCategories());
			return "categories";
		}

		// photo of product
		if (!file.isEmpty()) {
			c.setPhoto(file.getBytes());
			c.setNomPhoto(file.getOriginalFilename());
		} else {
			if (c.getId() != null) {
				Categorie cat = metier.getCategorie(c.getId());
				if (cat.getPhoto() != null) {
					c.setPhoto(cat.getPhoto());
				}
			}

		}

		// ajouter
		if (c.getId() == null)
			metier.ajouterCategorie(c);
		// modifier
		else
			metier.modifierCategorie(c);

		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());

		return "categories";
	}

	// supprimer
	@RequestMapping(value = "/suppCat")
	public String suppCat(Long idCat, Model model) {
		metier.supprimerCategrorie(idCat);
		model.addAttribute("categorie", new Categorie());
		model.addAttribute("categories", metier.listCategories());

		return "categories";
	}

	// modifier

	@RequestMapping(value = "/editCat")
	public String editCat(Long idCat, Model model) {
		Categorie c = metier.getCategorie(idCat);
		model.addAttribute("categorie", c);
		model.addAttribute("categories", metier.listCategories());
		return "categories";
	}

	// get image of the products
	@RequestMapping(value = "/photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] photoCat(Long idCat) throws Exception {

		Categorie categorie = metier.getCategorie(idCat);
		byte[] photo = categorie.getPhoto();

		if (photo != null)
			return IOUtils.toByteArray(new ByteArrayInputStream(photo));
		else
			return null;
	}

	// on general springe retourne tjrs un model et un view
	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception ex) {

		ModelAndView mv = new ModelAndView();
		mv.addObject("categorie", new Categorie());
		mv.addObject("exception", ex.getMessage());
		mv.setViewName("categories");
		return mv;
	}

}

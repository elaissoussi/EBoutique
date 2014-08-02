//package com.melaisso.melaisso;
//
//import static org.junit.Assert.assertTrue;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import com.melaisso.eboutique.entities.Categorie;
//import com.melaisso.eboutique.entities.Produit;
//import com.melaisso.eboutique.metier.IAdminCategoriesMetier;
//
//public class DAOTest {
//
//	ClassPathXmlApplicationContext appContext;
//	IAdminCategoriesMetier metier;
//
//	@Before
//	public void setUp() {
//
//		appContext = new ClassPathXmlApplicationContext(
//				new String[] { "applicationContext.xml" });
//		metier = (IAdminCategoriesMetier) appContext.getBean("metier");
//
//	}
//
//	@Test
//	public void testCategorie() {
//
//		try {
//
//			List<Categorie> cats1 = metier.listCategories();
//
//			metier.ajouterCategorie(new Categorie("catégorie2",
//					"catégorie2 est la deuxième catégorie", null, "p"));
//
//			List<Categorie> cats2 = metier.listCategories();
//
//			assertTrue(cats2.size() == cats1.size() + 1);
//
//		} catch (Exception e) {
//			assertTrue(e.getMessage(), false);
//		}
//	}
//
//	@Test
//	public void testProduit() {
//
//		try {
//
//			List<Produit> produits1 = metier.listproduits();
//			metier.ajouterProduit(new Produit("HP", "PC Portable", 12.0, 10,
//					null, true), 1L);
//
//			List<Produit> produits2 = metier.listproduits();
//			assertTrue(produits2.size() == produits1.size() + 1);
//
//		} catch (Exception e) {
//			assertTrue(e.getMessage(), false);
//		}
//
//	}
//}

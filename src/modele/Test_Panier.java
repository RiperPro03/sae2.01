package modele;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test_Panier {
	private Panier panier;
	private Articles articles;
	
	@Before
	public void setUp() {
		panier = new Panier();
		articles = GenerationFromages.générationBaseFromages();
	}

	@Test
	public void testAjoutUnArticle() {
		articles.getFromage("Brebis au Bleu").getArticles().get(0).setQuantitéEnStock(25);
		Article a = articles.getFromage("Brebis au Bleu").getArticles().get(0); 
		assertEquals(a.getQuantitéEnStock(),25);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		assertEquals(panier.getPanier().size(),1);
	}
	@Test
	public void testAjoutPlusieursFoisMêmeObjet() {
		articles.getFromage("Brebis au Bleu").getArticles().get(0).setQuantitéEnStock(25);
		Article a = articles.getFromage("Brebis au Bleu").getArticles().get(0); 
		assertEquals(a.getQuantitéEnStock(),25);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		assertEquals(panier.getPanier().size(),1);
		assertEquals(panier.getPanier().get(0).getQuantitéEnStock(),2);
	}
	@Test
	public void testModificationStockApresAjout() {
		articles.getFromage("Brebis au Bleu").getArticles().get(0).setQuantitéEnStock(25);
		Article a = articles.getFromage("Brebis au Bleu").getArticles().get(0); 
		assertEquals(a.getQuantitéEnStock(),25);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		assertEquals(articles.getFromage("Brebis au Bleu").getArticles().get(0).getQuantitéEnStock(),24);
	}
	
	
	@Test
	public void testCommande() {
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		panier.commander();
		assertEquals(panier.getPanier().size(),0);
		
	}
	
	@Test
	public void viderPanier() {
		articles.getFromage("Brebis au Bleu").getArticles().get(0).setQuantitéEnStock(25);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 1);
		panier.viderPanier(articles);
		assertEquals(articles.getFromage("Brebis au Bleu").getArticles().get(0).getQuantitéEnStock(),25);
		
	}
	@Test(expected = AssertionError.class)
	public void testExceptionViderPanier() {
		panier.viderPanier(articles);		
	}
	@Test(expected = AssertionError.class)
	public void testDemanderQuantitéSupérieurAuStock() {
		articles.getFromage("Brebis au Bleu").getArticles().get(0).setQuantitéEnStock(25);
		panier.addArticle(articles.getFromage("Brebis au Bleu").getArticles().get(0), 26);
	}
	
	@Test
	public void testTotal() {
		Fromage f = new Fromage("Brebis");
		f.addArticle("Poids", 10F);
		f.addArticle("Entier", 4F);
		f.getArticles().forEach(t -> t.setQuantitéEnStock(25) );
		panier.addArticle(f.getArticles().get(0), 3);
		panier.addArticle(f.getArticles().get(1), 1);
		assertEquals(panier.getTotal(), 43.9F,0);
		
	}
	@Test 
	public void testTotalPanierVide() {
		assertEquals(panier.getTotal(),9.9F,0);
	}
	
	@Test
	public void testUpdateTotalModeLivraison() {
		Fromage f = new Fromage("Brebis");
		f.addArticle("Poids", 10F);
		f.addArticle("Entier", 4F);
		f.getArticles().forEach(t -> t.setQuantitéEnStock(25) );
		panier.addArticle(f.getArticles().get(0), 3);
		panier.addArticle(f.getArticles().get(1), 1);
		panier.setModeLivraison(ModeLivraison.MONDIAL_RELAI);
		assertEquals(panier.getTotal(),40F,0);
	}

}

package modele;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class Test_ArticlesParFromages {
	public Fromage f;
	@Before
	public void setUp() {
		f = new Fromage("Miam");
		f.addArticle("Vache1", 4.2F);
		f.addArticle("Vache2", 4.2F);
		f.addArticle("Vache3", 4.2F);
		f.addArticle("Vache4", 4.2F);
	}

	@Test
	public void tailleListArticle() {
		List<Article> articles= this.f.getArticles();	
		assertEquals(4, articles.size());
	}
	@Test
	public void rechercheArticles() {
		List<Article> articles= this.f.getArticles();
		assertEquals(articles.get(0).getClé(), "Vache1");
		assertEquals(articles.get(1).getClé(), "Vache2");
		assertEquals(articles.get(2).getClé(), "Vache3");
		assertEquals(articles.get(3).getClé(), "Vache4");
	}

}

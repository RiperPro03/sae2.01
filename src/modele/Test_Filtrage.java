package modele;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_Filtrage {
	public Articles articles;
	@Before
	public void setUp() {
		articles = new Articles();
		List<Fromage> fromages = new LinkedList<Fromage>();
		Fromage fromageBrebis = new Fromage("Brebis");
		fromageBrebis.updateTypeFromage(TypeLait.BREBIS);
		Fromage fromageBrebis1 = new Fromage("Brebis 2");
		fromageBrebis1.updateTypeFromage(TypeLait.BREBIS);
		Fromage fromageBrebis2 = new Fromage("Brebis 1");
		fromageBrebis2.updateTypeFromage(TypeLait.BREBIS);
		fromages.add(fromageBrebis2);
		fromages.add(fromageBrebis1);
		fromages.add(fromageBrebis);
		Fromage fromageChèvre= new Fromage("Chèvre 2");
		fromageChèvre.updateTypeFromage(TypeLait.CHEVRE);
		Fromage fromageChèvre1 = new Fromage("Chèvre 1");
		fromageChèvre1.updateTypeFromage(TypeLait.CHEVRE);
		Fromage fromageChèvre2 = new Fromage("Chèvre");
		fromageChèvre2.updateTypeFromage(TypeLait.CHEVRE);
		fromages.add(fromageChèvre1);
		fromages.add(fromageChèvre2);
		fromages.add(fromageChèvre);
		Fromage fromageVache= new Fromage("Vache");
		fromageVache.updateTypeFromage(TypeLait.VACHE);
		Fromage fromageVache1= new Fromage("Vache 1");
		fromageVache1.updateTypeFromage(TypeLait.VACHE);
		Fromage fromageVache2= new Fromage("Vache 2");
		fromageVache2.updateTypeFromage(TypeLait.VACHE);
		fromages.add(fromageVache1);
		fromages.add(fromageVache2);
		fromages.add(fromageVache);
		articles.addFromages(fromages);
		
	}
	@After
	public void tearUp() {
		articles = null;
		
	}

	@Test
	public void filtrageBrebis() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.BREBIS);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.BREBIS);
		}
		assertEquals(fromageFiltré.size(), 3);
	}
	
	@Test
	public void filtrageChevre() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.CHEVRE);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.CHEVRE);
		}
		assertEquals(3,fromageFiltré.size());
	}
	@Test
	public void filtrageVache() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.VACHE);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.VACHE);
		}
		assertEquals(fromageFiltré.size(), 3);
	}

}

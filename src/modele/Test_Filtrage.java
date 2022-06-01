package modele;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

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
		Fromage fromageChèvre= new Fromage("Chevre 2");
		fromageChèvre.updateTypeFromage(TypeLait.CHEVRE);
		Fromage fromageChèvre1 = new Fromage("chvre 1");
		fromageChèvre1.updateTypeFromage(TypeLait.CHEVRE);
		Fromage fromageChèvre2 = new Fromage("Chevre");
		fromageChèvre2.updateTypeFromage(TypeLait.CHEVRE);
		fromages.add(fromageChèvre1);
		fromages.add(fromageChèvre2);
		fromages.add(fromageChèvre);
		Fromage fromageVache= new Fromage("Vache");
		fromageChèvre.updateTypeFromage(TypeLait.VACHE);
		Fromage fromageVache1= new Fromage("Vache 1");
		fromageChèvre1.updateTypeFromage(TypeLait.VACHE);
		Fromage fromageVache2= new Fromage("Vache 2");
		fromageChèvre2.updateTypeFromage(TypeLait.VACHE);
		fromages.add(fromageVache1);
		fromages.add(fromageVache2);
		fromages.add(fromageVache);
		articles.addFromages(fromages);
		
	}

	@Test
	public void filtrageBrebis() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.BREBIS);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.BREBIS);
		}
		assertEquals(fromageFiltré.size(), 3);
	}
	public void filtrageChevre() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.CHEVRE);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.CHEVRE);
		}
		assertEquals(fromageFiltré.size(), 3);
	}
	public void filtrageVache() {
		List<Fromage> fromageFiltré = this.articles.fromagesAuLaitDe(TypeLait.VACHE);
		for (Fromage f : fromageFiltré){
			assertEquals(f.getTypeFromage(),TypeLait.VACHE);
		}
		assertEquals(fromageFiltré.size(), 3);
	}

}

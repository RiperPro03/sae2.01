package modele;

import java.util.LinkedList;
import java.util.List;

public class Articles {

	private List<Fromage> lesFromages;
	
	public Articles() {
		this.lesFromages = new LinkedList<Fromage>();
	}
	
	public void addFromages(List<Fromage> fromages) {
		this.lesFromages.addAll(fromages);
	}
	
	public String toStringFromagesEtArticles() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			enForme.append(f.toString() + '\n');
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toString() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public String toStringArticlesEtStock() {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					enForme.append(article.toStringAvecStock() + '\n');
				}
			}
		}
		return enForme.toString();
	}
	
	public void regénérationDuStock() {
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() > 0) {
				for (Article article : f.getArticles()) {
					article.setQuantitéEnStock((int) Math.round(Math.random()*100));
				}
			}
		}
	}
	
	public String vérificationSaisie( ) {
		StringBuffer enForme = new StringBuffer();
		for (Fromage f : this.lesFromages) {
			if (f.nombreArticles() == 0) {
				enForme.append("Pas d'articles pour " + f.toString() + '\n');
			}
		}
		return enForme.toString();
	}
	
	public List<Fromage> fromagesAuLaitDe(TypeLait lait) {
		List<Fromage> fromageListType = new LinkedList<Fromage>();
		for (Fromage f : this.lesFromages) {
			if (f.getTypeFromage() == lait) {
				fromageListType.add(f);
			}
		}
		return fromageListType;
	}
	
	public List<Fromage> getLesFromages() {
		return this.lesFromages;
	}
	
	public Article getArticle(String désignation, String clé) {
		Article articleR = null;
		for (Fromage f: this.lesFromages) {
			if (f.getDésignation() == désignation) {
				for (Article a : f.getArticles()) {
					if (a.getClé() == clé) {
						articleR = a;
					}
				}
			}
		}
		assert(articleR == null) : "erreur";
		return null;
	}
	
	public float totalTTCFacture() {
		int total = 0;
		for(Fromage f : lesFromages) {
			for(Article a : f.getArticles()) {
				total += a.getPrixTTC() * a.getQuantitéEnStock();
			}
		}
		return total;
	}
	
	public float totalHTFacture() {
		return this.totalTTCFacture() / 1.2F ; 
	}
	
}

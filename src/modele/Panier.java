package modele;

import java.util.LinkedList;
import java.util.List;

import ihm.FEN_Panier;

public class Panier {

	private List<Article> panier;
	private float total;
	private ModeLivraison livreur;
	
	public Panier () {
		panier = new LinkedList<Article>(); 
		livreur = ModeLivraison.COLISSIMO;
		total = livreur.getPrix();
	}
	
	
	public List<Article> getList() {
		return this.panier;
	}
	
	public float getTotal() {
		return total;
	}
	public float getTotalSansLivraison() {
		return total - livreur.getPrix();
	}
	public List<Article> getPanier(){
		return panier;
	}

	public void addArticle(Article a,int quantité) {
		assert (quantité <= a.getQuantitéEnStock()):"Quantité demandée trop grande";
		if(quantité <= 0) {
			return;
		}
		if (panier.contains(a)) {
			panier.get(panier.indexOf(a)).rendreQuantité(quantité);
		} else {
			addAList(a, quantité);
		}
		a.préempterQuantité(quantité);
		this.updateTotal();
	}


	private void addAList(Article a, int quantité) {
		Article articleAdd = new Article(a.getFromage(),a.getClé(),a.getPrixTTC());
		articleAdd.rendreQuantité(quantité);
		panier.add(articleAdd);
	}
	
	private void updateTotal() {
		this.total = livreur.getPrix();

		if(panier.size()==0)
			return;
		updateTotalSansLivraison();
	}
	
	private void updateTotalSansLivraison() {
		for (Article a : panier) {
			this.total += a.getPrixTTC() * a.getQuantitéEnStock();
		}
	}

	
	public void setModeLivraison(ModeLivraison e) {
		this.livreur = e;
		this.updateTotal();
	}
	public String[] listIHM(){
		String[] result = new String[panier.size()+3]; 
		result[0] = "Produit \t\t\t Prix unitaire \t\t Qté \t\t Total";
		for(int i = 1; i<=panier.size();i++) {
			result[i] = panier.get(i).toStringIHM();
		}
		result[result.length-2] = "\t\t\t\t"+ livreur.toString();
		result[result.length-1] = "\t\t\t\t" + this.getTotal();
		return result;
		
		
	}
	public void viderPanier(Articles stock) {
		assert panier.size()>0 : "Votre panier est déjà vide";
		for(Article a : panier) {
			stock.getArticle(a.getFromage().getDésignation(),a.getClé()).rendreQuantité(a.getQuantitéEnStock());
		}
		panier.clear();
		
	}
	public void commander() {
		panier.clear();
	}
		
	}

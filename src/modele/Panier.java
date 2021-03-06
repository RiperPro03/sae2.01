package modele;

import java.util.LinkedList;
import java.util.List;

import ihm.Main;

public class Panier {

	private List<Article> panier;
	private float total;
	private ModeLivraison livreur;
	
	public Panier () {
		panier = new LinkedList<Article>(); 
		livreur = ModeLivraison.DHL;
		total = 0;
	}
	
	
	public List<Article> getList() {
		return this.panier;
	}
	
	public float getTotal() {
		if(total >= 100)
			return total;
		return total  + livreur.getPrix();
	}
	public float getTotalSansLivraison() {
		return total;
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
		total = 0;
		if(panier.isEmpty())
			return;
		updateTotalSansLivraison();
	}
	
	private void updateTotalSansLivraison() {
		for (Article a : panier) {
			this.total += a.getPrixTTC() * a.getQuantitéEnStock();
		}
	}
	
	public ModeLivraison getLivreur() {
		return livreur;
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
		this.total = 0 + livreur.getPrix();
		
	}
	public void commander() {
		assert panier.size()>0 : "Votre panier est vide";
		panier.clear();
		this.total = 0 + livreur.getPrix();
	}
	
	public void supprimerUnArticle(int index,Articles stock) {
		stock.getArticle(panier.get(index).getFromage().getDésignation(),panier.get(index).getClé()).rendreQuantité(panier.get(index).getQuantitéEnStock());
		panier.remove(index);
		this.updateTotal();
	}


	public boolean isEmpty() {
		
		return panier.size() == 0;
	}


	public float getPrixLivraison() {
		if(total >=100)
			return 0;
		return livreur.getPrix();
	}
		
	}

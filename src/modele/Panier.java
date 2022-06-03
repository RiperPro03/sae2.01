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
	}
	
	
	public List<Article> getList() {
		return this.panier;
	}
	
	public float getTotal() {
		return total;
	}

	public void addArticle(Article a,int quantité) {
		assert (quantité >= a.getQuantitéEnStock()):"Quantité demandé trop grande";
		if(quantité <= 0) {
			return;
		}
		if (panier.contains(a)) {
			panier.get(panier.indexOf(a)).rendreQuantité(quantité);
		} else {
			addAList(a, quantité);
		}
		this.updateTotal();
	}


	private void addAList(Article a, int quantité) {
		Article articleAdd = new Article(a.getFromage(),a.getClé(),a.getPrixTTC());
		articleAdd.rendreQuantité(quantité);
		panier.add(articleAdd);
	}
	
	private void updateTotal() {
		this.total = livreur.getPrix();
		for (Article a : panier) {
			this.total += a.getPrixTTC() * a.getQuantitéEnStock();
		}
	}

	
	public void setModeLivraison(ModeLivraison e) {
		this.livreur = e;
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
		
	}

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
	public int getTotal() {
		return total;
	}

	public void addArticle(Article a,int quantité) {
		assert (quantité >= a.getQuantitéEnStock()):"Quantité demandé trop grande";
		if(quantité<=0) {
			return;
		}
				int index = getIndex(a, quantité);
				if(index > 0) {
					panier.get(index).rendreQuantité(quantité);
				}else {
					Article articleAdd = new Article(a.getFromage(),a.getClé(),a.getPrixTTC());
					articleAdd.rendreQuantité(quantité);
					FEN_Panier.panier.add(articleAdd);
			}
				this.updateTotal();
	}
	private void updateTotal() {
		this.total = livreur.getPrix();
		for (Article a : panier) {
			this.total += a.getPrixTTC() * a.getQuantitéEnStock();
		}
	}

	private int getIndex(Article a, int quantité) {
		for (int i = 0; i < FEN_Panier.panier.size(); i++) {
			if (panier.get(i).equals(a)) {
				return i;
			}
		}
		return -1;
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

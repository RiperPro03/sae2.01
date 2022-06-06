package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GenFacture {
	
	private Panier panier;
	private List<String> infoClient = new LinkedList<String>();
	private int numFac;
	
	public GenFacture(Panier p, List<String> iC) {
		this.panier = p;
		this.infoClient = iC;
	}
	
	public void genFac(String nomF) {
		genNumFac();
		String chemin = "./";
		chemin += nomF + getNumFac() + ".txt";
		File f = new File(chemin);
		if (!f.exists()) {
			if (!panier.getList().isEmpty()) {
				try {
					f.createNewFile();
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(factureToDisplay());
					bw.newLine();
					bw.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("Panier vide");
			}
			
		} else {
			System.out.println("facture deja existant");
			
		}
	}
	public String factureToDisplay() {
		String result = new String();
		result+= "\t\tFacture n° " + getNumFac() + " Fromage qui rit\n";
		for(String s : this.infoClient) {
			result = result+ s + "\n";
		}
		for(Article a : this.panier.getPanier()) {
			float total = a.getPrixTTC() * a.getQuantitéEnStock();
			result+= a.toStringIHM() + " Total : " + total +"\n" ;
		}
		result += "\n\t\t\t\t\t Sous total \t\t"+ panier.getTotalSansLivraison() + "€\n";
		result += "\t\t\t\t\t Livraison" + panier.getLivreur().toString()+"€\n";
		result += "\t\t\t\t\t Total \t\t"+ panier.getTotal() + "€\n";		
		
		return result;
	}
	
	private void genNumFac() {
		this.numFac = (int) Math.round(Math.random() * 10000);
	}
	
	private int getNumFac() {
		return this.numFac;
	}

}

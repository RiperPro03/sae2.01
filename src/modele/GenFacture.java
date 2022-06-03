package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenFacture {
	
	private Panier panier;
	
	public GenFacture(Panier p) {
		this.panier = p;
	}
	
	public void genFac(String nomF) {
		String chemin = "./";
		chemin += nomF + ".txt";
		File f = new File(chemin);
		if (!f.exists()) {
			if (!panier.getList().isEmpty()) {
				try {
					f.createNewFile();
					FileWriter fw = new FileWriter(f);
					BufferedWriter bw = new BufferedWriter(fw);
					String strF;
					for (Article a : panier.getList()) {
						strF = a.getFromage().getDésignation() + " (" + a.getClé() + ") : " + a.getQuantitéEnStock() + " [" + a.getPrixTTC() + "€]";
						bw.write(strF);
						bw.newLine();
					}
					strF = "Livraison : " + panier.getLivreur();
					bw.write(strF);
					bw.newLine();
					strF = "Total = " + panier.getTotal() + "€";
					bw.write(strF);
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

}

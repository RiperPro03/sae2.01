package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ihm.FEN_Accueil;
import ihm.Main;

public class GenFacture {
	
	Panier panier;
	
	public GenFacture(Panier p) {
		this.panier = p;
	}
	
	public void genFac(String nomF) {
		String chemin = "./";
		chemin += nomF + ".txt";
		File f = new File(chemin);
		if (!f.exists()) {
			try {
				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				for (Article a : Main.panier.getList()) {
					String strF = a.getFromage().getDésignation() + " (" + a.getClé() + ") : " + a.getQuantitéEnStock() + " [" + a.getPrixTTC() + "€]";
					bw.write(strF);
					bw.newLine();
				}
				String strT = "Total = " + Main.panier.getTotal() + "€";
				bw.write(strT);
				bw.close();
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} else {
			System.out.println("facture deja existant");
			
		}
	}

}

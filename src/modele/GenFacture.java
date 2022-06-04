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
	
	public GenFacture(String nomFic, Panier p, List<String> iC) {
		this.panier = p;
		this.infoClient = iC;
		genFac(nomFic);
	}
	
	private void genFac(String nomF) {
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
					bw.newLine();
					for (String str : infoClient) {
						bw.write(str);
						bw.newLine();
					}
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

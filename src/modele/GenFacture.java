package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ihm.FEN_Accueil;

public class GenFacture {
	
	Panier panier;
	File f = new File("./facture/fac.txt");
	
	public GenFacture(Panier p) {
		this.panier = p;
	}
	
	public void genFac() {
		if (!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write("test");
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace(); 
			}
			
		}
	}

}

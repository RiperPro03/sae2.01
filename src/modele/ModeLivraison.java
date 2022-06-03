package modele;

import java.util.LinkedList;
import java.util.List;

public enum ModeLivraison {
	DHL(4.5f,"DHL"),COLISSIMO(9.9F,"Colissimo"),MONDIAL_RELAI(6f,"Mondial Relai");
	
	private float prix;
	private String nom;
	
	private ModeLivraison(float prix,String nom) {
		this.prix = prix;
		this.nom = nom;
	}
	public String toString() {
		return String.format("%10s",nom ) + String.format("%10.2f", prix);
	}
	public float getPrix() {
		return prix;
	}
	public static List<String> getAllValues() {
		List<String> result = new LinkedList<String>();
		for (ModeLivraison m : ModeLivraison.values()) {
			result.add(m.toString());						
		}
		return result;
	}
	public ModeLivraison getPrix(String value) {
		for(ModeLivraison m : ModeLivraison.values()) {
			if(m.toString() == value) {
				return m;
			}
		}
		return null;
	}
}


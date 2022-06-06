package ihm;
import modele.Panier;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import modele.Articles;

public class Main {
	
	public static Panier panier;
	public static modele.Articles stock;

	public static void main(String[] args) {
		panier = new Panier();
		stock = modele.GenerationFromages.générationBaseFromages();
		FEN_Accueil.launch();

	}

}

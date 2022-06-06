package ihm;
import modele.Articles;
import modele.GenerationFromages;
import modele.Panier;

public class Main {
	
	public static Panier panier;
	public static Articles stock;

	public static void main(String[] args) {
		panier = new Panier();
		stock = GenerationFromages.générationBaseFromages();
		FEN_Accueil.launch();

	}

}

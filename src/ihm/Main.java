package ihm;
import modele.Panier;
import modele.Articles;

public class Main {
	
	public static Panier panier;
	public static modele.Articles stock;

	public static void main(String[] args) {
		FEN_Accueil.launch();
		panier = new Panier();
		stock = modele.GenerationFromages.générationBaseFromages();

	}

}

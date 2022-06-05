package ihm;
import modele.Panier;
import modele.Articles;


public class Main {
	
	public static Panier panier;
	public static Articles stock;

	public static void main(String[] args) {
		panier = new Panier();
		stock = modele.GenerationFromages.générationBaseFromages();
		FEN_Accueil.launch();

	}

}

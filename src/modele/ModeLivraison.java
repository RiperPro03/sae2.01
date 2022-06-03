package modele;
public enum ModeLivraison {
	DHL(4.5f,"DHL \t 4,50€"),COLISSIMO(9.9F,"Colissimo \t 9,90€"),MONDIAL_RELAI(6f,"Mondial Relai \t 6€");
	
	private float prix;
	private String nom;
	
	private ModeLivraison(float prix,String nom) {
		this.prix = prix;
		this.nom = nom;
	}
	public String toString() {
		return nom;
	}
	public float getPrix() {
		return prix;
	}
}


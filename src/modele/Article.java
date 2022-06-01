package modele;

public class Article {

	private Fromage fromage;
	private String clé;
	private float prixTTC;
	private int quantitéEnStock;
	
	public Article(Fromage fromage, String clé, float prixTTC) {
		this.fromage = fromage;
		this.clé = clé;
		this.prixTTC = prixTTC;
		this.quantitéEnStock = 0;
	}
	
	public Fromage getFromage() {
		return this.fromage;
	}

	public float getPrixTTC() {
		return this.prixTTC;
	}
	
	public int getQuantitéEnStock() {
		return quantitéEnStock;
	}
	
	public String getClé() {
		return this.clé;
	}

	public void setQuantitéEnStock(int quantitéEnStock) {
		this.quantitéEnStock = quantitéEnStock;
	}

	public String toString() {
		if (clé.equals(""))
			return this.fromage.getDésignation() + ", Prix TTC : " + this.getPrixTTC() + " €";
		else
			return this.fromage.getDésignation() + ", " + this.clé + ", Prix TTC : " + this.getPrixTTC() + " €";
	}
	
	public String toStringAvecStock() {
		return this.toString() + ", Quantité en stock : " + this.quantitéEnStock;
	}
	
	public boolean equals(Object obj) {
		Article other = (Article) obj;
		return (this.fromage.equals(other.fromage) && this.clé.equals(other.clé));
	}
	
	public void préempterQuantité(int quantité) {
		
	}
	
	public void rendreQuantité(int quantité) {
		
	}
	
	public String toStringIHM() {
		return "void";
	}
	
}

package modele;
public class FromageEntierOuMoitié extends Fromage {
	
	public static final String MOITIE = "moitié";
	public static final String ENTIER = "entier";

	public FromageEntierOuMoitié(String désignation) {
		super(désignation);
	}
	
	public String toString() {
		return super.toString() + ", vendu entier ou par moitié";
	}

}

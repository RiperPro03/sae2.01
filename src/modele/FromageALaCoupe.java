package modele;
public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String désignation) {
		super(désignation);
	}
	
	public String toString() {
		return super.toString() + ", vendu à la coupe ou au poids";
	}

}

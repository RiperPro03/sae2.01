package modele;
public class FromageALUnitéPlusieursChoix extends Fromage {
	
	public FromageALUnitéPlusieursChoix(String désignation) {
		super(désignation);
	}
	
	public String toString() {
		return super.toString() + ", vendu à l'unité avec plusieus choix";
	}

}

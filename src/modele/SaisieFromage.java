package modele;
public class SaisieFromage {
	
	private String désignation;
	private String description;
	private TypeVente vente;
	private String[] cléArticle;
	private float[] prixArticle;
	
	public SaisieFromage(String désignation, String description, TypeVente vente) {
		this.désignation = désignation;
		this.description = description;
		this.vente = vente;
	}
	
	public SaisieFromage(String désignation, String description, TypeVente vente, String[] cléArticle, float[] prixArticle) {
		this(désignation, description, vente);
		this.cléArticle = cléArticle;
		this.prixArticle = prixArticle;
	}
	
	public Fromage builderFromage() {
		Fromage f = null;
		switch (vente) {
		case A_LA_COUPE_AU_POIDS : 
			f = new FromageALaCoupe(désignation);
			if (this.prixArticle != null && this.prixArticle.length > 1 
					&& this.cléArticle != null && this.cléArticle.length > 1
					&& this.cléArticle.length == this.prixArticle.length)
				for (int i = 0; i < this.cléArticle.length; i++)
					f.addArticle(this.cléArticle[i], this.prixArticle[i]);
			break;
		case A_L_UNITE : 
		    f = new FromageALUnité(désignation);
		    if (this.prixArticle != null)
		    	f.addArticle("A l'unité", this.prixArticle[0]);
		    break;
		case ENTIER_OU_MOITIE : 
			f = new FromageEntierOuMoitié(désignation);
			if (this.prixArticle != null && this.prixArticle.length == 2) {
				f.addArticle(FromageEntierOuMoitié.MOITIE, this.prixArticle[0]);
				f.addArticle(FromageEntierOuMoitié.ENTIER, this.prixArticle[1]);
			}
			break;
		case A_L_UNITE_PlUSIEURS_CHOIX :
			f = new FromageALUnitéPlusieursChoix(désignation);
			if (this.prixArticle != null && this.prixArticle.length == 1 
				&& this.cléArticle != null && this.cléArticle.length > 1)
				for (String clé: this.cléArticle)
					f.addArticle(clé, this.prixArticle[0]);
			break;
		case POUR_X_PERSONNES :
			f = new FromagePourXPersonnes(désignation);
			if (this.prixArticle != null && this.prixArticle.length > 1 
					&& this.cléArticle != null && this.cléArticle.length > 1
					&& this.cléArticle.length == this.prixArticle.length)
				for (int i = 0; i < this.cléArticle.length; i++)
					f.addArticle("pour " + this.cléArticle[i] + " personnes", this.prixArticle[i]);
			break;
		}
		f.addDescription(description);
		return f;
	}

}

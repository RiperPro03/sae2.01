package modele;
import java.util.LinkedList;
import java.util.List;

public class GenerationFromages {

	public static void main(String[] args) {
		Articles mesArticles = générationBaseFromages();
		System.out.println("Liste des fromages et articles :");
		System.out.println();
		System.out.println(mesArticles.toStringFromagesEtArticles());
		System.out.println();
		System.out.println("Liste des articles et de leurs stocks :");
		System.out.println();
		mesArticles.regénérationDuStock();
		System.out.println(mesArticles.toStringArticlesEtStock());
		System.out.println("Erreurs de saisie : ");
		System.out.println(mesArticles.vérificationSaisie());
	}

	public static Articles générationBaseFromages() {
		Articles mesArticles = new Articles();
		mesArticles.addFromages(GenerationFromageBrebis());
		mesArticles.addFromages(GenerationFromageChèvre());
		mesArticles.addFromages(GenerationFromageVache());
		mesArticles.regénérationDuStock();
		return mesArticles;
	}

	private static List<Fromage> GenerationFromageBrebis() {
		List<Fromage>  fromagesAuLaitDeBrebis = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  {    
				new SaisieFromage("Brebis au Bleu", 
				"Le brebis au bleu a une pâte très fondante, onctueuse fine et non friable. "
				+"Son persillage est bleu vert, foncé, pouvant présenter des traces d’aiguilles. "
				+"Une saveur franche, très typée, savoureuse, sans amertume. Un piquant doux et agréable. "
				+"Pas de goût acide, de rance ou de saponification. Pas d’excès de sel. "
				+"Un goût très puissant, aux arômes typiques de brebis, en font définitivement un fromage à découvrir ! "
				+"Son croûtage est clair, légèrement morgé. Il est fabriqué au lait pasteurisé.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}),
				new SaisieFromage("Brebis au Fenugrec",
				"Cette tomme de brebis a une pâte douce et souple, et sa croûte est épaisse et friable de couleur brune. "
				+"Lors de sa fabrication le fenugrec est incorporé au lait, son goût est subtil mais très présent.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}), 
				new SaisieFromage("Brebis Nature", 
				"Cette tomme de brebis au lait pasteurisé vous offrira un doux goût de brebis, fruité et tendre "
				+"sa pâte douce et souple accompagnera votre plateau de fromages "
				+"mais pourra également être un ingrédient dans plusieurs de vos recettes.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{7.7F, 15.4F, 30.8F}), 
				new SaisieFromage("Brebis au Piment", 
				"Le Brebis au Piment est un fromage à découvrir pour ceux qui aiment les fromages doux et raffinés à la fois. "
				+"Le piment d’Espelette est incorporé au lait, son goût est subtil mais très présent "
				+ "ce qui donne à la tomme des arômes corsés.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.2F, 16.4F, 32.8F}),
				new SaisieFromage( "Brebis à la Truffe",
				"Cette tomme de brebis recouverte d'une croûte épaisse et friable de couleur brune, "
				+"renferme une pâte ferme à tendance blanche parsemée de morceaux de truffe. "
				+"Lors de sa fabrication la truffe est incorporée au lait, son goût est subtil mais très présent. " 
				+"Alliez plaisir et originalité, en faisant découvrir la truffe associée aux saveurs du lait de brebis à vos convives.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{10.2F, 20.4F, 40.8F}),
				new SaisieFromage("Brin d'Amour Corse", 
				"Ce fromage au lait cru de brebis à pâte molle à croûte fleurie, propose un caractère corse qui s'exprime par sa croûte recouverte d'herbes, "
				+"de sarriettes et de romarin. Le Brin d'Amour offre un goût inimitable et une saveur parfumée et intense, il reste une merveille pour le palais. "
				+"C'est tout le caractère du fromage corse vous faisant voyager qui s'exprime dans ce mariage très heureux de lait de brebis et d’aromates. "
				+ "La «Fleur du maquis» dont la pâte est fine et la couleur varie entre le rouge et le vert.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{8.5F, 16.8F}),
				new SaisieFromage("Brique de Brebis Fermière", 
				"Cette brique est fabriquée à base de lait cru de brebis, elle dispose d’une croûte tendre de couleur ivoire plissée "
				+"et d’une pâte onctueuse et fondante de couleur blanche. "
				+"Lors de sa dégustation vous découvrirez des saveurs fruitées, légèrement salées avec des arômes de brebis, de noisette et de lait chaud. "  
				+"Une authenticité qui révèle la diversité des pâturages du Tarn grâce à son herbage riche et floral. "
				+ "Un vrai produit qui doit sa beauté simplement au fermier artisan. "
				+ "Elle est fondante, douce et persistante, prend du caractère sans agressivité en s’affinant avec un petit goût de noisette.", 
				TypeVente.A_L_UNITE,new String[]{""} ,new float[]{7.89F}),
				new SaisieFromage("L'Encalat", 
				"D'origine du Larzac, ce fromage crémeux au délicieux goût de brebis est incontournable. "
				+"Sa texture en bouche est jugée fondante voire très fondante. C'est un produit doux à la saveur salée plutôt faiblement prononcée. "
				+"L'Encalat est un fromage à pâte molle fleurie. Un affinage en cave de 2 semaines, offre une texture coulante et à cœur plus pâteuse. "
				+"Des saveurs à découvrir de toute urgence !!", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{8.4F}),
				new SaisieFromage("Ossau Iraty", 
				"Ce fromage au lait pasteurisé de brebis dispose d’une croûte dure de couleur beige orangé à gris clair à l’extérieur, et d’une pâte lisse "
				+"de couleur ivoire à l’intérieur présentant de petites ouvertures. En bouche, l’Ossau Iraty développera des saveurs fruitées avec des notes "
				+"de noisette et de lait de brebis. De consistance onctueuse, ferme et dure, l'Ossau Iraty, d'origine Basque, se déguste en amuse bouche, "
				+ "en casse croute, ou même en condiment. Ses arômes sont fruités et long en bouche.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg", "1/2 Tomme (2.1 kg environ)"}, new float[]{8.5F, 16.99F, 33.99F, 57.11F}),
				new SaisieFromage("Ossau Iraty - Saint Michel", 
				"Au lait cru de brebis, l'Ossau Iraty Saint-Michel dispose d’une croûte dure de couleur brune à l’extérieur, "
				+"et d’une pâte lisse légèrement cassante de couleur jaune à l’intérieur. En bouche, elle développera des saveurs fruitées relevées "
				+"de notes de lait de brebis et de légères notes de noisette. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.25F, 18.5F, 36.99F}),
				new SaisieFromage("Roquefort l'Arbas",
				"Une saveur persillée, plutôt acide et un peu fruité, c’est ce que vous proposera ce fromage au lait cru de brebis. "
				+"Le Roquefort de l'Arbas est un fromage typé de couleur blanc crème ou ivoire à l’extérieur à pâte fondante et onctueuse, "
				+"et parfumée à l’intérieur avec des veines bleu-vert bien réparties et marbré.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{7.25F, 14.5F, 28.99F}),
				new SaisieFromage("Roquefort Baragnaudes", 
				"Fromage au lait cru de brebis, le Roquefort Baragnaudes présente une pâte fondante et onctueuse de couleur blanche ivoire pâle, "
				+"avec des veines bleues intenses bordant de nombreuses et larges cavités. "
				+"D’une odeur délicate de lait de brebis elle s’accompagne d’un goût puissant aux arômes miellés  qui ravira tous vos convives. " 
				+"Fin et onctueux, le Roquefort des Caves Baragnaudes invite à un véritable voyage des sens. "
				+"Avec des senteurs de sous-bois et de champignons, il développe un bouquet aromatique raffiné qui, porté par une texture onctueuse, "
				+"se diffuse lentement pour terminer par des notes noisettes et beurrées.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.75F, 19.5F, 39F}),
				new SaisieFromage("Roquefort Carles",
				"Une saveur typiquement persillée, plutôt acide et un peu fruité, c’est ce que vous proposera ce fromage au lait cru de brebis. "
				+"Le Roquefort Carles est un fromage typé de couleur blanc crème ou ivoire à l’extérieur à pâte fondante onctueuse, crémeuse et parfumée "
				+"à l’intérieur. La maison Carles est une entreprise familiale créée en 1927, qui depuis trois générations, produit un roquefort d’exception, "
				+ "artisanal et de grande qualité. C'est un mélange réussi d'exigence, de tradition et de modernité qui fait du Roquefort Carles, "
				+ "un grand moment gustatif.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{10.95F, 21.9F, 43.8F}),
				new SaisieFromage("Roquefort Papillon", 
				"Fromage au lait cru de brebis, le Roquefort Papillon présente une pâte fondante et onctueuse de couleur blanche à ivoire pâle, "
				+"avec des veines bleues intenses bordant de nombreuses et larges cavités. "
				+"D’une odeur délicate de lait de brebis elle s’accompagne d’un goût puissant et salé qui ravira tous vos convives. "
				+"Depuis 1906, les fromageries PAPILLON façonnent un Roquefort authentique né de la rencontre des hommes et de la nature. "
				+"Un lien plus que centenaire, dont la notoriété du produit résulte de la confiance envers un savoir-faire naturel, une tradition, un goût, "
				+"qui le rendent inimitable. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{9.25F, 18.5F, 36.99F}),
				new SaisieFromage("Tomme d'Estaing", 
				"L’ESTAING est un fromage au lait cru de brebis, à pâte pressée avec une croûte fleurie. Sa pâte très souple, favorise en bouche "
				+"l’expression de tous les parfums du lait de Brebis. Cette tomme de brebis, au lait cru est produite sur le Larzac, et dispose d'un affinage "
				+"en cave entre 2 à 6 mois. Sa texture donne un produit qui ne pourra que ravir votre palais. Des saveurs inoubliables...", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.99F, 17.99F, 35.99F}),
				new SaisieFromage("Tomme Le Lou Bren", 
				"D'une couleur de croûte orangée, le Lou Bren peut avoir des tâches grises. La pâte est souple et de couleur ivoire avec quelques fines ouvertures. "
				+"Son odeur est fine et légère rappelant la brebis. Sa saveur est florale et acidulée. " 
				+"D'origine du Larzac, le Lou Bren est affiné en cave humide ce qui donnera une souplesse et un parfum de la flore des Causses, "
				+"en restant toujours doux en bouche.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""} ,new float[]{10.3F, 18.45F})
				};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeBrebis.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeBrebis)
			f.updateTypeFromage(TypeLait.BREBIS);
		return fromagesAuLaitDeBrebis;
	}

	private static List<Fromage> GenerationFromageChèvre() {
		List<Fromage>  fromagesAuLaitDeChèvre = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  { 
				new SaisieFromage("Bouton de Culotte fermier", 
				"Au lait cru de chèvre, ce petit fromage présentera une croûte de couleur jaune pâle qui deviendra brunâtre en s’affinant, "
				+"renfermant une pâte tendre de couleur blanche qui deviendra cassante à maturité. "
				+"Mais il ne faudra pas se fier à son apparence, malgré sa petite taille celui-ci vous offrira un goût prononcé caprin "
				+"accompagné d’une forte odeur de chèvre.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.8F}),
				new SaisieFromage("Pouligny Saint Pierre", 
				"Pyramide au lait cru de chèvre, ce fromage vous offrira une croûte fine recouverte de légères moisissures blanches et bleutées renfermant "
				+"une pâte ferme et souple de couleur ivoire. Ce fromage fermier vous présentera un goût de noisette accompagné d’une légère odeur caprine "
				+"qui sera apprécié par tous vos convives. Le Pouligny Saint Pierre présente une étendue de saveurs lui permettant d'être dégusté par un large "
				+"public. Il est un produit authentiquement fermier et est fabriqué dans le Berry.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{8.9F}),
				new SaisieFromage("Rocamadour", 
				"Petit fromage au lait cru de chèvre, il se présentera en forme d’un palet proposant une croûte fine et fondante de couleur ivoire renfermant "
				+"une pâte onctueuse et souple de couleur blanche. Le Rocamadour sera un délice pour vos papilles vous offrant des saveurs de chèvre, "
				+"de crème et de noisette relevé d’un peu de sel, le tout accompagné d’une légère odeur caprine. En bouche, le Rocamadour tout en douceur "
				+"fond contre le palais, suivant les goûts, on peut l'apprécier crémeux ou sec avec des arômes plus puissants.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{2.9F}),
				new SaisieFromage("Persillé de Chèvre", 
				"La particularité de ce fromage est qu'il ressemble à un bleu, alors qu'il est fabriqué à partir de lait pasteurisé de chèvre. "
				+"Fromage original à la texture fondante et grasse du roquefort, il a un goût franc et puissant avec une saveur fine et prononcée. "
				+"Le fromage doit fondre sous le palais en laissant une étonnante sensation de salinité. "
				+"Laissez-le s'affiner et il pourra être très très fort !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g"}, new float[]{10.95F, 21.9F}),
				new SaisieFromage("Tomme de Chèvre", 
				"D’un goût subtil et d’une personnalité tout en douceur et de finesse, ce fromage au lait pasteurisé de chèvre à pâte pressée non cuite "
				+"ravivera vos papilles gustatives. La Tomme de Chèvre offre une pâte ferme, fondante en bouche qui relèvera une saveur typique et prononcée "
				+"du lait de chèvre avec des arômes de fruits secs. Fromage traditionnel, la dégustation de la Tomme de Chèvre en tranches fines allie "
				+"le charme de la rusticité à la découverte d'arômes délicats, elle pourra être utilisée également en raclette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg", "1/2 Tomme (2 kg environ)"}, new float[]{8.2F, 16.4F, 32.8F, 55.76F}),
				new SaisieFromage("Tomme de Chèvre Thym Miel", 
				"Fromage originaire de la Hollande, la dégustation de cette tomme de chèvre vous offrira des saveurs à la fois délicates de miel et de caramel, "
				+"et prononcées de thym et d'arômes de chèvre. En plus de son goût subtil, cette tomme est recouverte d'une croûte fleurie de thym "
				+"lavée au caramel, celle-ci présente un mélange de couleur différente, et renferme une pâte tendre à ferme de couleur ivoire "
				+"mouchetée de thym.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 kg"}, new float[]{8.95F, 17.9F, 35.8F}),
				new SaisieFromage("Bûchette Fermière", 
				"Délivrant une onctuosité rare, au lait cru de chèvre, nos fromages présentent une croûte fine cendrée renfermant une pâte souple, "
				+"tendre et homogène de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. " 
				+"Cette Buchette Fermière est produite par nos soins sous le nom de l'EARL du Chemin Fleury, une ferme familiale située à Louzy "
				+"dans les Deux- Sèvres. ", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.99F}), 
				new SaisieFromage("Cabris Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, nous respectons le savoir faire de cette grande région, tout en se distinguant "
				+"par une texture et un goût qui lui sont bien spécifiques. Au lait cru de chèvre, nos fromages présentent une croûte fine salée au sel blanc "
				+"ou cendré renfermant une pâte souple, tendre et homogène de couleur blanche. "
				+"Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendré - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.39F}),
				new SaisieFromage("Chabis Fermier", 
				"Au lait cru de chèvre, nos fromages présentent une croûte fine salée au sel blanc ou cendrée renfermant une pâte souple, "
				+"tendre et homogène de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Le Chabis est "
				+"un habile mélange de saveurs : légèrement sucré avec une pointe de sel, délicatement acide dans un arôme de lait. "
				+"Fabriqué en Poitou à l'EARL du chemin fleury, c’est un excellent fromage de tradition !", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Moelleux cendré - Jeune et doux", "Moelleux blanc - Jeune et doux"} ,new float[]{3.99F}),
				new SaisieFromage("Chabis frais aromatisé Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos Chabis frais aromatisés présentent une pâte tendre "
				+"moelleuse et fondante en bouche de couleur blanche recouverte de différentes épices : échalotes, ails et fines herbes ou encore poivres "
				+"qui lui confère un goût exquis. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Echalotes", "Ail et fines herbes", "Poivres"} ,new float[]{3.99F}),
				new SaisieFromage("Coeur de chèvre", 
				"Au lait cru de chèvre, nos fromages présentent une croûte fine salée au sel blanc ou cendré renfermant une pâte souple, tendre et homogène "
				+"de couleur blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Le coeur de chèvre est un fromage "
				+"de chèvre crémeux, son goût peut se révéler aussi bien doux que corsé, tant sa force varie en rapport immédiat avec son degré d’affinage. "
				+"Il est conçu par l'EARL du Chemin Fleury.", 
				TypeVente.A_L_UNITE, new String[]{""} ,new float[]{3.99F}),
				new SaisieFromage("Crottin Fermier", 
				"Au lait cru de chèvre, nos fromages présentent une croûte fine salée au sel blanc renfermant une pâte souple, tendre et homogène de couleur "
				+"blanche. Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives. Issu du EARL du Chemin Fleury, ce fromage a "
				+"une texture très tendre et moelleuse quand il est jeune. Il se durcit avec le temps pour devenir très sec. "
				+"Il développe pleins d’arômes avec un goût de chèvre marqués au départ.\r\n", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"moelleux (jeune et doux)", "affiné (très prononcé)"} ,new float[]{3.90F}),
				new SaisieFromage("Crottin frais aromatisé Fermier", 
				"Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos crottins frais aromatisés présentent une pâte très tendre "
				+"et moelleuse de couleur blanche recouverte de différentes épices : échalotes, ails et fines et herbes ou encore poivre. "
				+ "Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Poivre", "Echalotes", "Ail et fines herbes"} ,new float[]{2.99F}),
				new SaisieFromage("Faisselle de chèvre 500g", 
				"La véritable faisselle est le caillé de lait de chèvre frais mis à égoutter dans une faisselle puis dans un pot pour garder un peu de son "
				+"petit lait. Son goût varie selon les saisons. D'une saveur douce, elle prend au printemps un parfum différent avec l'herbe verte et fraîche "
				+"des champs. Notre faisselle maison est appréciée pour sa saveur fraîche et sa légèreté. "
				+ "Au petit déjeuner, en en-cas ou au dessert, la faisselle se consomme à toutes heures et vous apportera un peu de fraîcheur."
				, TypeVente.A_L_UNITE,new String[]{""} ,new float[]{3.99F}),
				new SaisieFromage("Galet de chèvre", 
				"Produit dans les Deux-Sèvres par l'EARL Chemin Fleury, au lait cru de chèvre, le Galet de chèvre présente une croûte fine salée au sel blanc "
				+"renfermant une pâte souple, tendre et homogène de couleur blanche. Ce fromage vous offrira un doux goût de chèvre dont les notes caprines "
				+"seront plus prononcées en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Long Fermier", 
				"Produit par nos soins sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, le long fermier met en valeur toutes les qualités du lait, "
				+"sa légère acidité, son discret goût de sel, et sa douceur se développent sous le palais. Les couleurs et la texture sont agréables et "
				+"laissent un long arrière-goût en bouche.", 
				TypeVente.A_L_UNITE_PlUSIEURS_CHOIX, new String[]{"Blanc Moelleux - jeune et doux", "Cendré Moelleux - jeune et doux"} ,new float[]{5.59F}),
				new SaisieFromage("Le Trio Apéro", 
				"Produit par nos soins, sous le nom de l'EARL Chemin Fleury, au lait cru de chèvre, nos crottins frais aromatisés présentent une pâte très tendre "
				+"et moelleuse de couleur blanche recouverte de différentes épices : échalotes, ails et fines et herbes ou encore poivre. "
				+"Leurs doux goûts de chèvre uniques raviront vos papilles et celles de vos convives.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.99F}),
				new SaisieFromage("Ovale Fermier", 
				"Au lait cru de chèvre, ce fromage a une croûte légèrement cendrée. Sa pâte est d'un blanc pur. Elle reste ferme tout en étant souple "
				+"et moelleuse à la fois sous le doigt. Ce fromage dégage une odeur subtile et agréable. Leurs doux goûts de chèvre uniques raviront "
				+"vos papilles et celles de vos convives. Une saveur exprimée par la douceur d'un lait riche et crémeux.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Pavé Fermier", 
				"Au lait cru de chèvre, ce fromage présente une croûte fine salée au sel cendré renfermant une pâte souple, tendre et homogène de couleur blanche. "
				+"Son doux goût de chèvre unique ravira vos papilles et celles de vos convives. En forme de pavé, il est fabriqué à la Ferme du Chemin Fleury "
				+"dans les Deux-Sèvres. Son expression buccale est très présente avec une montée rapide et pleine de délicatesse.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}),
				new SaisieFromage("Pyramide Fermière", 
				"La pyramide fermière est un fromage de chèvre crémeux, son goût peut se révéler aussi bien doux que corsé, tant sa force varie en rapport "
				+"immédiat avec son degré d'affinage. Fabriquée par nos soins sous le nom de l'EARL chemin Fleury, la pyramide est un fromage au lait cru de "
				+"chèvre, elle présente une croûte fine salée au sel cendré renfermant une pâte souple, tendre et homogène de couleur blanche.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.49F}), 
				new SaisieFromage("Sein Fleury", 
				"Au lait cru de chèvre, le Sein Fleury présente une croûte fine salée au sel cendré renfermant une pâte souple, tendre et homogène de "
				+"couleur blanche. Son doux goût de chèvre unique ravira vos papilles et celles de vos convives. Produit par des producteurs locaux de "
				+"EARL du chemin fleury, il respecte le savoir faire de cette grande région, tout en se distinguant par une texture et un goût qui lui "
				+"sont bien spécifique.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.2F}),
				new SaisieFromage("Selle Fleury", 
				"Produit dans les Deux-Sèvres par l'EARL Chemin Fleury, au lait cru de chèvre, le Selle Fleury présente une croûte fine salée au sel cendré "
				+"renfermant une pâte souple, tendre et homogène de couleur blanche. Ce fromage vous offrira un doux goût de chèvre dont les notes caprines "
				+"seront plus prononcées en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F})
		};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeChèvre.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeChèvre)
			f.updateTypeFromage(TypeLait.CHEVRE);
		return fromagesAuLaitDeChèvre;	
	}

	private static List<Fromage> GenerationFromageVache() {
		List<Fromage>  fromagesAuLaitDeVache = new LinkedList<Fromage>();
		SaisieFromage[] fromages =  { 
				new SaisieFromage("Abondance", 
				"De fabrication fermière, et d'un affinage de 10 semaines en caves avec des soins de frottage, cette tomme dégage une odeur de cave et offre "
				+"un fondant en bouche développant un goût de noisette. Ce fromage au lait cru de vache se présente sous la forme d’une meule recouverte "
				+"d’une croûte lisse de couleur brune à légèrement grise, renfermant une pâte souple et fondante de couleur ivoire à jaune "
				+"l'Abondance présente quelques trous. Elle vous offrira des saveurs fruitées relevées d’une légère pointe de sel avec un parfum de noisette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.52F, 11.04F, 22.09F}),
				new SaisieFromage("Appenzeller", 
				"Le fromage Appenzeller est l’une des plus grandes spécialités fromagères suisses. Savoureux et raffiné, il est une valeur sûre et "
				+"est apprécié depuis plus de 700 ans. C'est un fromage au lait cru de vache à pâte pressée demi-cuite, typique au goût corsé, "
				+"il doit son goût unique au traitement à la saumure aux herbes. il vous offrira un goût raffiné et aromatisé avec une pâte tendre "
				+"recouverte d’une croûte aux tons brun et rouge. L’Appenzeller d’un caractère affirmé restera un mystère mais un délice pour nos papilles." 
				, TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.9F, 17.8F, 35.6F}), 
				new SaisieFromage("Beaufort d'Alpage", 
				"Considéré comme le «Prince des Gruyères», ce fromage au lait cru de vache à pâte pressée cuite, vous offrira un parfum fruité et une "
				+"onctuosité accompagné d’un goût de noisette très prononcé. Fromage savoyard AOC, le Beaufort se présente d’une pâte ferme de couleur ivoire "
				+"à jaune pâle, recouvert d’une croûte lisse d’une couleur jaune orangée. Il reste un fromage au goût typé sans pour autant être fort.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{12F, 24F, 48F}), 
				new SaisieFromage("Bleu d'Auvergne", 
				"Fromage au lait cru de vache à pâte persillée, ce Bleu d’Auvergne dispose d’un goût affirmé et d’une texture fondante. "
				+"Celui-ci vous offrira une pâte de couleur blanche à ivoire parsemée de moisissures bleu-vert, et une croûte fine naturelle fleurie "
				+"qui peut présenter des reflets de la même teinte. Ce bleu typé mais pas fort sera délicieux en fin de repas.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.7F, 13.4F, 26.8F}), 
				new SaisieFromage("Bleu de Gex", 
				"Fromage au lait cru de vache, il dispose d’une croûte fine, sèche et légèrement farineuse de couleur blanche à jaune et renferme "
				+"une pâte souple, onctueuse et légèrement friable de couleur blanche à ivoire présentant des veines bleues-vertes. "
				+"Le Bleu Gex vous offrira un goût léger et doux accompagnée d’une saveur de noisette et de champignon, le tout relevé d’une légère amertume "
				+"et d’une pointe de sel. ", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.6F, 11.2F, 22.4F}), 
				new SaisieFromage("Bleu des Causses", 
				"Principalement fabriqué en Aveyron à Rodez et affiné dans les caves de Peyrelade dans les Gorges du Tarn, ce fromage est en quelque sorte "
				+"la version au lait de vache du Roquefort. En effet voisin de celui-ci avec son histoire, il est un fromage au lait pasteurisé de vache "
				+"à pâte persillée. Il a une qualité dans sa texture à la fois tendre et fondante et il propose une saveur alliant douceur et puissance. "
				+"Le Bleu des Causses est un bouquet raffiné qui offre une richesse aromatique à consommer toute l’année de l’apéritif au dessert. " 
				+"Son goût crémeux vous surprendra !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.99F, 11.98F, 23.96F}),
				new SaisieFromage("Boulette d'Avesnes", 
				"Facilement reconnaissable à sa forme conique et irrégulière, la Boulette d'Avesnes fermière est un fromage au lait cru de vache de "
				+"couleur rouge brun. Elle est fabriquée à partir de brisures de maroilles frais enrichi de persil, d’estragon et de clou de girofle, "
				+"puis recouverte de paprika. Son odeur et son goût relevé et savoureux sont incomparables.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.5F}), 
				new SaisieFromage("Brie aux truffes", 
				"Couvert d’un blanc duveteux, d’une croûte fine pigmentée parfois de tâches rouges et proposant une pâte coulante. "
				+"L’arôme à la fois fin et puissant de la truffe se délayant dans la pâte dense et les touches noisetées du Brie, le tout lié par une "
				+"préparation crémeuse à souhait. C’est un fromage pour les amateurs de saveurs prononcées. Spécialité de la maison des fromages, "
				+"le Brie Truffé est un délice, fabriqué par nos soins selon des savoirs-faire secrets, le mariage du Brie et de la Truffe est "
				+"un chef d’œuvre gastronomique ! Nous vous aurons prévenu : le goûter c'est l'adopter !", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{15F}), 
				new SaisieFromage("Brie de Meaux", 
				"Située au cœur de verts pâturages de la Meuse, la Fromagerie Dongé est la référence en matière de Brie de Meaux AOC depuis trois générations. "
				+"Couvert d’un blanc duveteux, d’une croûte fine pigmentée parfois de tâches rouges et proposant une pâte jaune paille clair onctueuse, "
				+"souple mais non coulante, le Brie de Meaux nous offre une saveur fine avec un goût de noisette. C’est un fromage pour les amateurs de "
				+"saveurs prononcées.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.99F, 11.98F, 23.96F}), 
				new SaisieFromage("Brie de Melun", 
				"Plus petit que son grand frère «le Brie de Meaux», il a cependant plus de caractère. Ce fromage au lait cru de vache vous offrira une pâte "
				+"souple de couleur jaune d’or à l’intérieur, et une croûte fleurie blanche parsemée de stries ou de taches rouges ou brunes à l’extérieur. "  
				+"Le Brie de Melun vous proposera une saveur très fruitée avec un léger goût de noisette accompagnée d’une odeur du terroir qui le rendra "
				+"indispensable sur un plateau de fromages. Il pourra aussi entrer dans la confection de spécialités régionales dont la plus connue, "
				+"la croûte au brie.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{9.15F, 18.3F, 36.6F}), 
				new SaisieFromage("Brillat Savarin", 
				"Portant le nom de l'ancien gastronome, ce double crème à la forme d'un disque au lait cru de vache est un fromage à pâte molle à croûte "
				+"fleurie cotonneuse et blanche. Le Brillat Savarin se mange jeune et bien frais, mais il conservera sa douceur au palais en s’affinant et "
				+"vous offrira en bouche des arômes de bois et de noisette avec un cœur de crème aux saveurs douces légèrement acidulées.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{7.5F, 14.5F}), 
				new SaisieFromage("Camembert de Buffone", 
				"Fromage au lait pasteurisé de Bufflonne, il se présente sous la forme d’un petit camembert recouvert d'une fine croûte fleurie blanche, "
				+"renfermant un doux cœur crémeux", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.5F}), 
				new SaisieFromage("Camembert de Normandie AOP", 
				"Connu comme le fromage français par excellence, et de valeur sûre, il ne sera jamais de trop sur un plateau. Le Camembert de Normandie "
				+"vous offrira une saveur fruitée avec un goût légèrement salé qui s’accentuera en s’affinant. "
				+"Moulé à la louche il a une forme régulière et  une surface striée, sa pâte est lisse et souple de couleur ivoire à jaune clair "
				+"lorsqu'il est affiné \"à cœur\". Demi-affiné, il reste au centre de la pâte un \"noyau\" blanc central de 2 mm. "
				+"Il est obligatoirement commercialisé dans une boite en bois.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.6F}), 
				new SaisieFromage("Camembert Gaslondes", 
				"Parfait pour les amateurs de camembert fort, le Gaslondes très moelleux vous proposera un goût et un parfum prononcé sans piquant. "
				+"Fromage au lait cru de vache, il dispose d’une croûte striée et duvetée de blanc légèrement pigmentée de rouge en fonction de l’affinage, "
				+"et qui renferme une pâte souple de couleur blanche à jaune crème. Le Camembert Gaslondes vous apportera des saveurs fruitées accompagnées "
				+"d’arômes laitiers.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.3F}), 
				new SaisieFromage("Chaource fermier", 
				"Excellent toute l'année, le Chaource fermier est très apprécié pour sa pâte. Fromage au lait cru de vache, il propose une croûte blanche "
				+"et duveteuse à l’extérieur, et une pâte fine et fondante à l’intérieur accompagnée d’arômes de crème et de champignons frais, "
				+"relevés par une légère pointe de sel. Sa saveur douce et fruitée de noisette sera délicieuse à déguster en apéritif avec un porto "
				+"ou même un champagne. Un délice de raffinement.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.9F}), 
				new SaisieFromage("Comté 18 mois", 
				"Fromage d'excellence, au lait cru de vache, le Comté est un fromage à pâte pressée cuite et une texture souple et ferme à la fois. "
				+"Le Comté reste un fromage d’exception qui se caractérise par une grande diversité aromatique. "
				+"Il présente des arômes à dominantes fruités en été, et torréfiés avec des nuances de noisettes en hiver. Avant tout une histoire d'hommes "
				+"profondément attachés aux valeurs de terroir et à celles du Comté, les Maîtres de cave Marcel Petite sélectionne leurs Comtés en "
				+"recherchant la meilleure qualité de finesse, subtilité et intensité du goût. Un délice dans vos plateaux !", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.95F, 17.9F, 35.8F}), 
				new SaisieFromage("Comté spécial de Noël", 
				"Ce comté est un produit très rare à obtenir par notre partenaire PETITE. En effet, il est très convoité pour toutes ses qualités. "
				+"Fromage d'excellence, au lait cru de vache, ce Comté à pâte pressée cuite d'une texture souple et ferme à la fois affiné 28 mois, "
				+"vous présentera une pâte plus jaune parsemée de mini-cristaux (appelé tyrosine) signe d'un affinage parfait et réussi. "
				+"Le Comté reste un fromage d’exception qui se caractérise par une grande diversité aromatique. "
				+"Il présente des arômes à dominantes fruités en été, et torréfiés avec des nuances de noisettes en hiver.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{11.5F, 23F, 46F}), 
				new SaisieFromage("Coulommiers", 
				"Grand frère du Camembert et petit frère du Brie, ce fromage a maintenant une place de choix dans les familles. "
				+"Les coulommiers fermiers se font malheureusement rares, mais nous vous le proposons. Fromage au lait cru de vache, "
				+"il est recouvert d’une fine croûte duvetée de blanc qui renferme une pâte jaune claire avec un cœur blanc. "
				+"Le Coulommiers vous offrira un moelleux et une onctuosité accompagnés d’une saveur d’amande douce et d’une odeur de champignons frais, "
				+"de crème et de lait chaud.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{5.5F, 10.99F}), 
				new SaisieFromage("Curé Nantais", 
				"Connu comme le \"fromage nantais\", il a un parfum captivant et immanquable. On peut le déguster toute l'année. "
				+"Il présente un goût de terroir prononcé. Il est proposé froid ou chaud, avec des fruits ou du poireau. C'est un fromage fort, sa pâte est "
				+"souple, crémeuse et percée de quelques petits trous, elle révèle une saveur de lard fumé et un final épicé. "
				+"La croûte est rugueuse, odorante et humide", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.8F}),
				new SaisieFromage("Emmental de Savoie IGP", 
				"Fabriqué en Savoie, au lait cru de vache, il est un fromage à pâte pressée cuite. Ayant une croûte jaune à brun pâle signée de la mention "
				+"Savoie sur le talon, et proposant une pâte jaune clair au toucher fin et souple, l’Emmental français offre une diversité de goût "
				+"aux arômes subtils, doux et fruités. Seul ou accompagné de pain, il s'accorde bien avec un verre de vin. "
				+"Traditionnellement utilisé pour la fondue savoyarde, on l'utilise également dans de nombreuses préparations culinaires, en tranches, "
				+"en cubes, râpé ...", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6F, 12F, 24F}), 
				new SaisieFromage("Emmentaler Suisse", 
				"Indispensable sur un plateau de fromage, l'Emmental Suisse révèle toutes ses subtilités en cuisine, en plats chauds ou froids. "
				+"Savoureux sans être envahissant, il est idéal pour les sandwichs et salades, et même au petit-déjeuner. Les Suisses en raffolent. "  
				+"Fromage au lait cru de vache proposant une pâte ferme et tendre de couleur crème à jaune clair, et une croûte lisse de couleur dorée "
				+"ou brun clair recouverte d’une inscription rouge «Switzerland Emmentaler». "
				+"L’ Emmental Suisse vous offrira un goût doux, tendre aux délicates nuances de noisette et de noix mais gagnera en puissance en s’affinant.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.5F, 13F, 26F}), 
				new SaisieFromage("Epoisses", 
				"Au lait cru de vache, ce fromage dispose d’une croûte brillante orangée renfermant une pâte souple beige clair. "
				+"En bouche, l’ Époisses vous offrira une onctuosité et un goût relevé avec des notes de fruits secs. "
				+"D'un caractère puissant, ce fromage particulièrement goûteux est fabriqué depuis des siècles de tradition par les moines et "
				+"les fermière de la région d’Époisses. Un délice sur un plateau, certains le place au four à même dans sa boîte.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{12.6F}), 
				new SaisieFromage("Fondue Savoyarde", 
				"Idéal pour un repas convivial avec vos amis ou en famille. C'est un mélange de parfum, d'onctuosité, et de raffinement pour "
				+"cette fondue savoyarde. Allez y piquez vos morceaux de pain dans le caquelon au centre de la table. "
				+"La fondue savoyarde est un plat régional de la gastronomie française à base de fromage fondu et de pain, traditionnel des pays de Savoie. "  
				+"Ce plat populaire, vous envoûtera de part ses multiples arômes.", 
				TypeVente.POUR_X_PERSONNES, new String[]{"3","5", "10"}, new float[]{22.5F, 33.75F, 67.5F}), 
				new SaisieFromage("Fourme d'Ambert", 
				"La Fourme d'Ambert est un fromage au lait cru de vache à pâte persillée, elle vous offrira en bouche une saveur délicate et une texture fondante. "
				+"Celle-ci présentera une pâte de couleur blanche à ivoire parsemée de moisissures bleu-vert, et une croûte fine naturelle fleurie "
				+"qui peut présenter des reflets de la même teinte. Reconnu pour être le fromage bleu le plus doux, ce fromage ravira vos papilles "
				+"et celles de vos convives.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.2F, 12.4F, 24.8F}), 
				new SaisieFromage("Galet de Loire", 
				"C’est un fromage au lait pasteurisé de vache à patte molle à croûte fleurie blanche à jaunâtre, et légèrement striée et tachetée. "
				+"Sans odeur et d’un goût de noisette, le galet de Loire nous invite à ne pas se fier sa petite apparence, "
				+"en bouche il reste délicat et onctueux au cœur avec sa pâte est crémeuse et dévoile un goût typé ainsi qu’une importante diversité d’arômes, "
				+"tantôt champignon, tantôt étable.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{5.5F}), 
				new SaisieFromage("Gaperon", 
				"Issu d'Auvergne, le Gaperon est un petit fromage dont la saveur varie suivant qu'on le mange frais, jeune, affiné ou très affiné. "
				+"Il dégage peu d'odeur mais sa saveur reste \"piquante\" à déguster toute l'année. Au lait cru de vache, celui-ci est conçu avec "
				+"ce qu’il reste du beurre après sa fabrication, c’est -à-dire le «babeurre». Le Gaperon dispose d’une pâte de couleur ivoire à "
				+"jaune pâle à l’intérieur et d’une croûte lisse et blanche à l’extérieur. Ce petit fromage parsemé de poivre moulu et de morceaux d’ail "
				+"vous offrira une saveur aromatisée et intense.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.5F, 11.8F}), 
				new SaisieFromage("Gorgonzola", 
				"D’une pâte de couleur blanche parsemée de veines vertes-bleutées, le Gorgonzola propose une texture ferme mais moelleuse à la fois "
				+"aux saveurs particulières et caractéristiques légèrement piquantes. Souvent utilisé dans de nombreuses recettes pour son fondant, "
				+"le Gorgonzola peut également être apprécié sur un plateau de fromages à déguster en fin de repas et pourquoi pas l’associer à une poire. "
				+"Il reste et restera un fromage incontournable de la gastronomie italienne.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5.2F, 10.4F, 20.8F}), 
				new SaisieFromage("Gouda", 
				"Spécialité fermière hollandaise, ce Gouda vieux dispose d'un affinage exceptionnel qui le rend dur et cassant avec un étonnant goût de "
				+"noisette très prononcé. Fromage au lait de vache pasteurisé, il offre une croûte lisse et dure de cire jaune renfermant une pâte ferme "
				+"et friable de couleur crème à jaune. Le Vieux Gouda vous apportera une saveur prononcée et piquante avec des arômes de lait, de crème, "
				+"d’amande à déguster à tous moments de la journée.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.5F, 15F, 30F}), 
				new SaisieFromage("Gouda aux truffes", 
				"Fromage hollandais au lait de vache thermisé, il offre une croûte lisse et dure de cire noire renfermant une pâte jeune et souple agréablement "
				+"parfumé de couleur crème à jaune. La pâte est parsemée de nombreux éclats de truffes. Ce Gouda vous apportera une saveur douce et subtile "
				+"il sera difficile de s'en passer. Très goûteux aux arômes intenses de la truffe noire, il sera irrésistible et pourra se manger à "
				+"l'apéritif ou même être ajouté dans des plats cuisinés. Il vous fera découvrir des associations étonnantes.",
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.75F, 17.5F, 35F}), 
				new SaisieFromage("Gruyère Suisse", 
				"C’est un fromage au lait cru de vache au goût fin, subtil et aromatique. Le Gruyère Suisse renferme une pâte souple et ferme de couleur "
				+"ivoire recouverte d’une croûte grainée brunâtre. D’une saveur inimitable qui s’affirmera en fonction de son affinage, il sera très apprécié "
				+"sur votre plateau fromage. Le Gruyère Suisse traditionnel est fabriqué dans les cantons de Fribourg, c'est l'authenticité du travail "
				+"du fromager qui va apporté au fromage toute la richesse de son goût incomparable.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{10.7F, 21.4F, 42.8F}), 
				new SaisieFromage("Kaltbach Suisse", 
				"En apéro, en fin de repas ou pour agrémenter vos plats, le Kaltbach régalera petits et grands avec son goût très fruité et son fondant "
				+"incomparable. Enrichi en crème et affiné dans la grotte de Kaltbach en Suisse, ce fromage dispose d'une texture moelleuse et ferme à la "
				+"fois et d'une odeur franche mais très agréable.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.7F, 17.4F, 34.8F}), 
				new SaisieFromage("Laguiole", 
				"Ce fromage au lait cru de vache dispose d’une pâte ferme et lisse de couleur jaune paille, recouvert d’une croûte naturelle et épaisse "
				+"de couleur orangé claire ou brun ambré. Reconnaissable au Taureau imprimé sur la croûte suivi du mot \"Laguiole\", "
				+"il vous offrira un goût remarquable et unique des saveurs florales de son terroir à consommer à tout moment, de l’apéritif à la fin du repas.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.5F, 13F, 26F}), 
				new SaisieFromage("Langres Fermier", 
				"Fromage au lait cru de vache, le Langres vous propose une pâte souple, fondante et crémeuse de couleur blanche, recouverte d'une croûte "
				+"fine et brillante de couleur jaune clair à brun en s'affinant. En forme d'un cylindre dont le sommet se creuse formant une cuvette, "
				+"la \"Fontaine\", celle-ci permettant d'y verser du Champagne ou du Marc de Champagne : façon traditionnelle d’accommoder ce fromage, "
				+"vous découvrirez en le dégustant des saveurs relevées avec des notes d'alcool accompagnées d'une forte odeur pénétrante.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{7.9F}), 
				new SaisieFromage("Livarot", 
				"Appelé aussi \"le Colonel\" dû aux cinq bandes en roseau qui entourent sa croûte, appelées \"laiches\", le Livarot au lait cru de vache "
				+"dispose d'une pâte souple et légèrement salée à l'intérieur et d'une croûte orangée et humide à l'extérieur. D'une odeur forte et d'un goût "
				+"relevé aux arômes floraux et aux saveurs de charcuteries fumées, il apportera une note d'originalité sur votre plateau mais pourra "
				+"également constituer un excellent en-cas.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{7.7F, 15.4F}), 
				new SaisieFromage("Maroilles Fermier", 
				"Fromage de caractère le plus connus du nord de la France, le Maroilles vous proposera une odeur forte et une saveur corsée. " 
				+"C'est un fromage au lait cru de vache qui dispose d'une croûte rouge orangée lisse et brillante renfermant une pâte souple et onctueuse. "
				+"A découvrir sur votre plateau de fromages.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{10.69F, 20.99F}), 
				new SaisieFromage("Mimolette Tendre", 
				"La Mimolette ou appelée également \"boule de Lille\" est un fromage au lait pasteurisé  de vache. Cette boule de couleur orangé intérieur "
				+"comme à l'extérieur dispose d'une pâte tendre. La Mimolette jeune  vous offrira en bouche des saveurs délicates de noisettes relevées "
				+"de pointes de sel.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{4.49F, 8.99F, 17.99F}), 
				new SaisieFromage("Mimolette Vieille", 
				"La Mimolette vieille est facilement identifiable par sa forme ronde. Sa croûte est grisâtre, rempli de trous et de fissures. "
				+"Sa pâte, est orange foncée, sèche et cassante. Sa saveur est fruitée, légèrement piquante et se termine par une pointe d'amertume. "
				+"Un fromage de caractère aux arômes salés et sucrés accompagnés d'une odeur fruitée et de cave.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"200 g", "400 g", "1 Kg"}, new float[]{6.6F, 13.2F, 29.69F}), 
				new SaisieFromage("Mont d'Or boite", 
				"Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, présenté dans sa boîte épicéa où il donne l'air d'être "
				+"un peu à l'étroit avec sa croute légèrement plissée, est la star de la table où il peut être dégusté à la petite cuillère. "
				+"Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, légèrement pressée, de consistance crémeuse, légèrement salée. "
				+"Il se reconnaît à sa croûte lavée légèrement \"refleurie\", de couleur jaune à brun clair. "
				+"Il est cerclé d'une sangle d'épicéa et inséré dans une boîte en bois d'épicéa.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{11.8F}), 
				new SaisieFromage("Mont d'Or", 
				"Les amateurs de Mont d'or l'attendent avec impatience : le Vacherin du Haut Doubs, présenté dans sa boîte épicéa où il donne l'air d'être "
				+"un peu à l'étroit avec sa croute légèrement plissée, est la star de la table où il peut être dégusté à la petite cuillère. "
				+"Le Mont d'Or est un fromage au lait cru de vache, à pâte molle, non cuite, légèrement pressée, de consistance crémeuse, légèrement salée. "
				+"Il se reconnaît à sa croûte lavée légèrement \"refleurie\", de couleur jaune à brun clair. "
				+"Il est cerclé d'une sangle d'épicéa et inséré dans une boîte en bois d'épicéa.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{6.75F, 13.5F, 27F}), 
				new SaisieFromage("Montbriac", 
				"Au lait de vache pasteurisé, ce fromage renferme une pâte crémeuse de couleur ivoire légèrement persillée recouverte d’une croûte tendre "
				+"de couleur grise. Le Montbriac connu aussi comme Rochebaron, vous offrira un parfum délicat et une saveur fruitée et salée avec de légers "
				+"arômes du terroir. Ce fromage est le résultat d'une expérience heureuse qui combine les moisissures bleue avec un fromage doux et crémeux"
				+" typiquement français. Dégustez-le en fin de repas avec une baguette bien croustillante.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.8F, 13.6F}), 
				new SaisieFromage("Morbier", 
				"Marqué en son centre d'une célèbre raie noire, le Morbier au lait cru de vache dispose d'une pâte souple et onctueuse colorée entre l'ivoire "
				+"et le jaune pâle avec de légères ouvertures et de rares petits trous. Sa croûte lisse et fine de couleur rosé clair à beige orangé "
				+"renferme bien d'autres surprises et qualités. Le Morbier dévoilera un parfum franc et persistant ainsi qu'une odeur franche et fruité, "
				+"et un léger goût de crème et de fruit comme la noisette.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{5F, 10F, 19.99F}), 
				new SaisieFromage("Munster", 
				"Délicieux et délicat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs délicates et une croûte lisse de couleur dorée "
				+"à orangée. Le Munster au goût relevé et fruité dispose d’une odeur forte et pénétrante. En plateau ou en cuisine, il est souvent "
				+"consommé avec du cumin ou du carvi.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{6.6F, 13.1F}), 
				new SaisieFromage("Munster au Cumin", 
				"Délicieux et délicat fromage au lait cru de vache, il propose une pâte moelleuse aux saveurs délicates et une croûte lisse de couleur dorée "
				+"à orangée parsemée de cumin. Le Munster au goût relevé et fruité dispose d’une odeur forte et pénétrante.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{9.4F, 18.8F}), 
				new SaisieFromage("Neufchâtel Cœur", 
				"Le Neufchâtel convient à tous les palais, sous sa croûte blanche fleurie, se cache une pâte lisse et moelleuse (on la dit \"moussée\") "
				+"de couleur blanche à ivoire. Au lait cru de vache, ce petit fromage en forme de cœur vous apportera une saveur délicate mais soutenue, "
				+"salée et acidulée accompagnée d'une légère odeur de lait. Le Neufchâtel vous offrira un goût de champignons et de lait qui "
				+"s'accentuera en s'affinant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.99F}), 
				new SaisieFromage("Olivet", 
				"C’est un fromage au lait de vache pasteurisé recouvert de cendre, il dispose d’une croûte mince de couleur grise dégageant une légère "
				+"odeur de terre, renfermant une pâte souple de couleur blanche à ivoire. L’Olivet Cendré vous offrira des saveurs fruitées relevées "
				+"d’une pointe de sel. Son processus d’affinage lui permettra de développer un goût d'herbe fraîche plus nuancé que le camembert.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{4.99F}), 
				new SaisieFromage("Parmesan Reggiano", 
				"Le parmesan, est un fromage italien traditionnel, qui jouit d'une renommée mondiale, il a une saveur lactique, fruitée, salée, parfois "
				+"piquante et rentre dans la composition de beaucoup de recettes. Fromage au lait cru de vache, le Parmesan est un fromage à pâte pressée cuite. "
				+"D’une croûte brune huilée, aux saveurs très fruitées et d’un piquant unique, il dispose d’une qualité toujours excellente.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{8.7F, 17.4F, 34.8F}), 
				new SaisieFromage("Pont l'Evêque", 
				"Au lait cru de vache, ce pavé dispose d’une croûte lisse de couleur beige clair à l’extérieur et d’une pâte tendre de couleur jaune pâle "
				+"à l’intérieur. Le Pont l’Évêque au goût subtil et fruité avec des notes de noisettes sera un délice en fin de repas à déguster sans modération.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{5.3F, 10.5F}), 
				new SaisieFromage("Raclette de Savoie", 
				"La Raclette est aussi savoureuse à manger à la main comme fondu, elle est de forme ronde, sa croûte lisse de couleur orange foncé à brun, "
				+"pâte souple caractérisée par une couleur jaune ivoire, goût franc et très parfumée. A pleine maturité elle devient plus corsée.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "1/2 Tomme 2,6 Kg (environ)"}, new float[]{4.52F, 9.04F, 18.08F, 47.01F}), 
				new SaisieFromage("Reblochon", 
				"Au lait cru de vache ce fromage fermier présente une croûte lisse jaune orangé recouverte par une légère mousse blanche, renfermant "
				+"une pâte onctueuse de couleur ivoire. Le Reblochon vous offrira une saveur subtile relevée d’une note de noisette qui reste en bouche "
				+"après l'avoir dégusté. Principalement utilisé pour la traditionnelle Tartiflette, il sera un délice sur vos plateaux de fromages.", 
				TypeVente.ENTIER_OU_MOITIE, new String[]{""}, new float[]{8.99F, 17.6F}), 
				new SaisieFromage("Rosettes de tête de moine", 
				"Pourquoi avoir absolument besoin du friseur à fromage, pour être en mesure d'apprécier la tête de moine ? La saveur de la rosette est garantie "
				+"grâce ce concept. Nous proposons ce service pour assurer des rosettes aérées et solides. Elles sont préparées par nos soins le jour de "
				+"l'expédition. Elles sont conditionnées dans une boite plastique. La quantité par boite peut varier de 12 à 14 rosettes. " 
				+"La tête de moine est un fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à "
				+"jaune clair, légèrement dure et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. ", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{8.9F}), 
				new SaisieFromage("Saint Félicien", 
				"Ce fromage au lait cru de vache vous proposera un goût crémeux légèrement salé et noiseté. Le Saint-Félicien offrira une pâte souple "
				+"recouverte d’une croûte naturelle de couleur blanche à jaune clair. Il sera un fromage fermier qui comblera les amateurs de fromages doux. " 
				+"Le Saint-Félicien séduit de plus en plus de consommateurs par son onctuosité, son crémeux et son bon goût.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.1F}), 
				new SaisieFromage("Saint Marcellin Fermier", 
				"Fromage au lait thermisé de vache, il propose une pâte molle et crémeuse de couleur ivoire recouverte d'une croûte fine et fleurie de "
				+"couleur blanche. D’un goût légèrement acide aux arômes de noisette accompagné d’un parfum boisé, c'est un petit fromage produit dans la Drôme, "
				+"il est à consommer peu affiné accompagné d'une salade mais il développera toute sa typicité quand il sera coulant sous une croûte bleue.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{2.47F}), 
				new SaisieFromage("Saint Nectaire Fermier", 
				"Ce fromage au lait cru de vache à pâte pressée non cuite, propose une belle pâte de texture souple de couleur crème. Il est savoureux et "
				+"doit être mangé à cœur et non pas coulant. Offrant toutes les essences des prairies de son terroir et un délicat goût noisette "
				+"le Saint Nectaire est un fleuron gastronomique auvergnat. Au parfum inimitable de terroir qui laisse échapper quelques odeurs de noisette, "
				+"chaud ou froid, notre fromage s'adapte à vos envies. Ce fromage d'Auvergne pourra se déguster tout simplement sur une généreuse "
				+"tranche de pain de campagne.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "fromage entier de 1,5 Kg (environ)"}, new float[]{7.45F, 14.9F, 29.8F, 40.23F}), 
				new SaisieFromage("Salers", 
				"La personnalité du Salers, l’extraordinaire étendue de sa palette de goûts, permettent des mariages gourmands allant du classique au plus insolite. "
				+"Fromage fermier au lait cru de vache, il dispose d’une pâte jaune et bien liée recouverte d’une croûte dorée, épaisse et fleurie de tâches "
				+"rouges et orangées. Le Salers vous offre un goût corsé, épicé, lactique et fruité à déguster tout au long de l’année. "
				+"Vous l’identifierez par une plaque rouge et une empreinte gravée en creux «Salers-Salers» sur l’une des faces de ce fromage.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.75F, 15.5F, 31F}), 
				new SaisieFromage("Tête de Moine", 
				"Fromage Suisse au lait cru de vache, il propose une croûte ferme brune renfermant une pâte de couleur ivoire à jaune clair, légèrement dure "
				+"et fondante en bouche. La Tête de Moine vous apportera des saveurs aromatiques qui s’affirmeront en s’affinant. Généralement, pour déguster "
				+"la Tête de Moine AOP, il ne faut pas couper le fromage mais le racler en rosettes très fines, grâce au friseur à fromage. "
				+"En effet, le raclage modifie la structure de la pâte, la plus grande surface mise en contact avec l'air met particulièrement en valeur "
				+"l'arôme typique  et permet de mieux la savourer.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"200 g", "400 g", "Tête de Moine entière 850 g (environ)"}, new float[]{7.56F, 15.12F, 28.92F}), 
				new SaisieFromage("Tomme de Savoie", 
				"Doyenne des fromages de Savoie, la Tomme de Savoie est une fabrication ancestrale issue d'un environnement naturel exceptionnel. "
				+"Les saveurs de ce fromage reposaient donc sur les parfums du lait, liés notamment aux herbages spécifiques dont se nourrissaient "
				+"les troupeaux. D’une croûte grise fleurie de moisissures blanches renfermant une pâte tendre de couleur blanche à jaune pâle présentant "
				+"de légères ouvertures. Ce fromage au lait cru de vache offre un goût de noisette légèrement salé accompagné d’un parfum de cave, "
				+"la tomme de Savoie reste un fromage typique à partager toute l’année.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg", "tomme entière de 1,6 Kg (environ)"}, new float[]{5.99F, 11.99F, 23.99F, 30.7F}), 
				new SaisieFromage("Tomme des Pyrénées", 
				"Fromage au lait cru de vache, il présente une croûte striée, orangée et dorée renfermant une pâte souple et onctueuse de couleur jaune "
				+"aérée par de petites ouvertures. La Tomme de Vache offrira en bouche des saveurs fruitées légèrement sucrées et acidulée aux notes de noisettes, "
				+"le tout s’accompagnant d’une légère odeur de cave. La tomme des Pyrénées \"Bethmale\" offre une saveur forte et fruitée qui saura vous "
				+"faire voyager au cœur des montagnes d’Ariège.", 
				TypeVente.A_LA_COUPE_AU_POIDS, new String[]{"250 g", "500 g", "1 Kg"}, new float[]{7.2F, 14.4F, 28.8F}), 
				new SaisieFromage("Trou du Cru", 
				"Petit fromage au lait pasteurisé de vache, il se présente sous la forme d’un petit cylindre recouvert d’une croûte lisse et collante de couleur "
				+"orangé à rouge, renfermant une pâte onctueuse et fondante de couleur jaune clair. D’un goût puissant et délicat à la fois il vous offrira "
				+"des saveurs parfumées, salées et sucrées relevé d’arômes d’alcool, accompagné d’une légère odeur de paille. Ne vous fiez pas à sa petite taille, "
				+"affiné avec du marc de Bourgogne, son goût puissant avec une arrière bouche florale enchantera les amateurs de sensations fortes.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{3.99F}), 
				new SaisieFromage("Vieux Lille", 
				"Au lait cru de vache, le Vieux Lille se présente sous la forme d’un pavé de couleur grisâtre. Sa pâte étant élaborée à base de Maroilles "
				+"macéré dans une saumure, celle-ci est donc souple et offre une odeur puissante accompagné d’un goût prononcé, salé et légèrement piquant.", 
				TypeVente.A_L_UNITE, new String[]{""}, new float[]{6.99F})
		};
		for (SaisieFromage s : fromages) {
			fromagesAuLaitDeVache.add(s.builderFromage());
		}
		for (Fromage f : fromagesAuLaitDeVache)
			f.updateTypeFromage(TypeLait.VACHE);
		return fromagesAuLaitDeVache;	
	}
}
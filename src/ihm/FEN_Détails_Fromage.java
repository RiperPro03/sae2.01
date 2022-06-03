package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import modele.Article;
import modele.Fromage;

import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FEN_Détails_Fromage {

	private JFrame frame;
	private Fromage fromage;
	
	public static void launch(Fromage f) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Détails_Fromage window = new FEN_Détails_Fromage(f);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Create the application.
	 */
	public FEN_Détails_Fromage(Fromage f) {
		this.fromage = f;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // HIDE_ON_CLOSE pour juste fermer cette fenetre
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel NORTH = new JPanel();
		frame.getContentPane().add(NORTH);
		
		JLabel Titre_Détails_Fromage = new JLabel(fromage.getDésignation());
		NORTH.add(Titre_Détails_Fromage);
		
		JPanel détails_du_fromage = new JPanel();
		frame.getContentPane().add(détails_du_fromage);
		détails_du_fromage.setLayout(new BorderLayout(0, 0));
		
		JSlider slider = new JSlider();
		slider.setOrientation(SwingConstants.VERTICAL);
		détails_du_fromage.add(slider, BorderLayout.EAST);
		
		JTextArea information_fromage = new JTextArea();
		information_fromage.setText(fromage.getDescription());
		information_fromage.setEditable(false);
		détails_du_fromage.add(information_fromage, BorderLayout.CENTER);
		
		JPanel FOOTER = new JPanel();
		frame.getContentPane().add(FOOTER);
		FOOTER.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel South_North = new JPanel();
		FlowLayout fl_South_North = (FlowLayout) South_North.getLayout();
		fl_South_North.setAlignment(FlowLayout.LEFT);
		FOOTER.add(South_North);
		
		JComboBox comboBox = new JComboBox();
		String[] listeOption = listeClé();
		comboBox.setModel(new DefaultComboBoxModel(listeOption));
		South_North.add(comboBox);
		
		JSpinner spinner_nb_fromage = new JSpinner();
		South_North.add(spinner_nb_fromage);
		
		JPanel South_South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South_South.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		FOOTER.add(South_South);
		
		JButton btn_ajouter_panier = new JButton("Ajouter au panier");
		addPanier(comboBox, spinner_nb_fromage, btn_ajouter_panier);
		btn_ajouter_panier.setForeground(new Color(0, 0, 0));
		btn_ajouter_panier.setBackground(new Color(50, 205, 50));
		South_South.add(btn_ajouter_panier);
		
		
		JButton btn_annuler_ajout = new JButton("Annuler");
		eventClose(btn_annuler_ajout);
		btn_annuler_ajout.setBackground(new Color(255, 69, 0));
		South_South.add(btn_annuler_ajout);
	}


	private void addPanier(JComboBox comboBox, JSpinner spinner_nb_fromage, JButton btn_ajouter_panier) {
		btn_ajouter_panier.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
				int spVal = (int) spinner_nb_fromage.getValue(); // récupérer la valeur du spinner
				Article choix = null;
				for (Article a : fromage.getArticles()) {
					if (a.getClé() == comboBox.getSelectedItem()) {
						choix = Main.stock.getArticle(fromage.getDésignation(), a.getClé());
						
					}
				}
				if (spVal <= choix.getQuantitéEnStock() && spVal > 0) {
					Main.panier.addArticle(choix, spVal);
					frame.setVisible(false);
				}
			}
		});
	}


	private String[] listeClé() {
		String[] listeOption = new String[fromage.getArticles().size()];
		for (int i = 0; i < fromage.getArticles().size(); i++) {
			listeOption[i] = fromage.getArticles().get(i).getClé();
		}
		return listeOption;
	}


	private void eventClose(JButton btn) {
		btn.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		});
	}

}

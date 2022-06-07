package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import modele.Article;
import modele.Fromage;

import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.SpinnerNumberModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FEN_Détails_Fromage {

	private JFrame frame;
	private Fromage fromage;
	private JTextField affichage_Stock;
	protected JComboBox comboBox;
	private JSpinner spinner_nb_fromage;
	private JTextField Prix;
	
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
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // HIDE_ON_CLOSE pour juste fermer cette fenetre
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel NORTH = new JPanel();
		frame.getContentPane().add(NORTH);
		
		JLabel Titre_Détails_Fromage = new JLabel(fromage.getDésignation());
		NORTH.add(Titre_Détails_Fromage);
		
		JPanel détails_du_fromage = new JPanel();
		frame.getContentPane().add(détails_du_fromage);
		détails_du_fromage.setLayout(new BorderLayout(0, 0));
		
		JTextPane textPane = new JTextPane();
		textPane.setText(fromage.getDescription());
		textPane.setEditable(false);
		détails_du_fromage.add(textPane, BorderLayout.NORTH);
		
		JPanel FOOTER = new JPanel();
		frame.getContentPane().add(FOOTER);
		FOOTER.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel South_North = new JPanel();
		FOOTER.add(South_North);
		String[] listeOption = listeClé();
		South_North.setLayout(new BorderLayout(0, 0));
		
		JPanel South_South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South_South.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		FOOTER.add(South_South);
		
		JButton btn_ajouter_panier = new JButton("Ajouter au panier");
		
		JPanel panel_Quantité = new JPanel();
		South_North.add(panel_Quantité, BorderLayout.WEST);
		
		comboBox = new JComboBox();
		panel_Quantité.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(listeOption));
		
		
		
		spinner_nb_fromage = new JSpinner();
		panel_Quantité.add(spinner_nb_fromage);
		
		updateQteMax(comboBox, spinner_nb_fromage);
		choixOption(comboBox,spinner_nb_fromage);
		
		spinner_nb_fromage.setPreferredSize(new Dimension(50,25));
		addPanier(comboBox, spinner_nb_fromage, btn_ajouter_panier);
		
		JPanel panel_Prix = new JPanel();
		South_North.add(panel_Prix, BorderLayout.EAST);
		
		JLabel lblPrix = new JLabel("Prix unitaire:");
		panel_Prix.add(lblPrix);
		
		Prix = new JTextField();
		panel_Prix.add(Prix);
		Prix.setEditable(false);
		Prix.setColumns(5);
		
		
		JLabel label_Stock = new JLabel("Stock :");
		panel_Quantité.add(label_Stock);
		label_Stock.setHorizontalAlignment(SwingConstants.CENTER);
		
		affichage_Stock = new JTextField();
		panel_Quantité.add(affichage_Stock);
		affichage_Stock.setEditable(false);
		affichage_Stock.setColumns(5);
		btn_ajouter_panier.setForeground(new Color(0, 0, 0));
		btn_ajouter_panier.setBackground(new Color(50, 205, 50));
		South_South.add(btn_ajouter_panier);
		updateAffichageStockPrix(comboBox);
		
		JButton btn_annuler_ajout = new JButton("Annuler");
		eventClose(btn_annuler_ajout);
		btn_annuler_ajout.setBackground(new Color(255, 69, 0));
		South_South.add(btn_annuler_ajout);
		refreshWindowAtFocus();
	}


	private void updateQteMax(JComboBox comboBox, JSpinner spinner_nb_fromage) {
		Article choix = null;
		for (Article a : fromage.getArticles()) {
			if (a.getClé() == comboBox.getSelectedItem()) {
				choix = Main.stock.getArticle(fromage.getDésignation(), a.getClé());
			}
		}
		if (choix.getQuantitéEnStock() != 0) {
			spinner_nb_fromage.setModel(new SpinnerNumberModel(1, 1, choix.getQuantitéEnStock(), 1));
		} else {
			spinner_nb_fromage.setModel(new SpinnerNumberModel(0, 0, 0, 0));
		}
		
	}


	private void choixOption(JComboBox comboBox, JSpinner spinner_nb_fromage) {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox) {
					updateAffichageStockPrix(comboBox);
					updateQteMax(comboBox, spinner_nb_fromage);
				}
			}
		});
	}


	private void updateAffichageStockPrix(JComboBox comboBox) {
		Article choix = null;
		for (Article a : fromage.getArticles()) {
			if (a.getClé() == comboBox.getSelectedItem()) {
				choix = Main.stock.getArticle(fromage.getDésignation(), a.getClé());
				
			}
		}
		String str = "" + choix.getQuantitéEnStock();
		affichage_Stock.setText(str);
		str = choix.getPrixTTC() + "€";
		Prix.setText(str);
		
	}


	private void addPanier(JComboBox comboBox, JSpinner spinner_nb_fromage, JButton btn_ajouter_panier) {
		btn_ajouter_panier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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
				} else {
					JOptionPane.showMessageDialog(null, 
					         "L'article est en rupture de stock",
					         "Attention",
					         JOptionPane.ERROR_MESSAGE);
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
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
	public void refreshWindowAtFocus() {
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				updateAffichageStockPrix(comboBox);
				updateQteMax(comboBox,FEN_Détails_Fromage.this.spinner_nb_fromage);
			}
			public void windowLostFocus(WindowEvent e) {
				updateAffichageStockPrix(comboBox);
				updateQteMax(comboBox,FEN_Détails_Fromage.this.spinner_nb_fromage);
			}
		});
	}

}

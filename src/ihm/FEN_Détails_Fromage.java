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

public class FEN_Détails_Fromage {

	private JFrame frame;
	private Fromage fromage;


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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel NORTH = new JPanel();
		frame.getContentPane().add(NORTH);
		
		JLabel Titre_Détails_Fromage = new JLabel("Nom frometon");
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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Type de vente : Prix TTC"}));
		South_North.add(comboBox);
		
		JSpinner spinner_nb_fromage = new JSpinner();
		South_North.add(spinner_nb_fromage);
		
		JPanel South_South = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South_South.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		FOOTER.add(South_South);
		
		JButton btn_ajouter_panier = new JButton("Ajouter au panier");
		btn_ajouter_panier.setForeground(new Color(0, 0, 0));
		btn_ajouter_panier.setBackground(new Color(50, 205, 50));
		South_South.add(btn_ajouter_panier);
		
		JButton btn_annuler_ajout = new JButton("Annuler");
		btn_annuler_ajout.setBackground(new Color(255, 69, 0));
		South_South.add(btn_annuler_ajout);
	}

}

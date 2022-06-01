package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import modele.Articles;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.JSlider;

public class FEN_Accueil {
	public modele.Articles stock;
	public modele.Articles panier;
	

	private JFrame frame;
	private JTextField txtFromageQuiRit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Accueil window = new FEN_Accueil();
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
	public FEN_Accueil() {
		stock = modele.GenerationFromages.générationBaseFromages();
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
		
		JPanel header = new JPanel();
		header.setBorder(null);
		frame.getContentPane().add(header);
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel image_header = new JLabel("Attente image");
		header.add(image_header);
		
		txtFromageQuiRit = new JTextField();
		txtFromageQuiRit.setForeground(Color.BLACK);
		txtFromageQuiRit.setAlignmentX(Component.LEFT_ALIGNMENT);
		txtFromageQuiRit.setBackground(Color.WHITE);
		txtFromageQuiRit.setFont(new Font("Roboto Light", Font.PLAIN, 14));
		txtFromageQuiRit.setHorizontalAlignment(SwingConstants.CENTER);
		txtFromageQuiRit.setEditable(false);
		txtFromageQuiRit.setText("Fromage qui rit");
		header.add(txtFromageQuiRit);
		txtFromageQuiRit.setColumns(1);
		
		JButton btn_panier = new JButton("indic_panier");
		header.add(btn_panier);
		
		JPanel sélection_type = new JPanel();
		sélection_type.setBorder(null);
		frame.getContentPane().add(sélection_type);
		sélection_type.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn_tout_fromage = new JButton("Tout");
		sélection_type.add(btn_tout_fromage);
		
		JButton btn_fromage_brebis = new JButton("Attente icon b");
		sélection_type.add(btn_fromage_brebis);
		
		JButton btn_fromage_vache = new JButton("Attente icon v");
		sélection_type.add(btn_fromage_vache);
		
		JButton btn_fromage_chèvre = new JButton("Attente icon");
		sélection_type.add(btn_fromage_chèvre);
		
		JPanel parcours_fromage = new JPanel();
		frame.getContentPane().add(parcours_fromage);
		parcours_fromage.setLayout(new BorderLayout(0, 0));
		
		JList liste_fromage = new JList();
		parcours_fromage.add(liste_fromage, BorderLayout.CENTER);
		
		JSlider slider = new JSlider();
		slider.setFont(new Font("Tahoma", Font.PLAIN, 11));
		slider.setOrientation(SwingConstants.VERTICAL);
		parcours_fromage.add(slider, BorderLayout.EAST);
	}

}

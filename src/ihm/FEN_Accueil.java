package ihm;

import modele.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Color;
import javax.swing.JSlider;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class FEN_Accueil {
	
	private JFrame frame;
	private JTextField txtFromageQuiRit;
	private JList liste_fromage;
	private String[] fromagesListeDs;

	/**
	 * Launch the application.
	 */
	public static void launch() {
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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBorder(null);
		frame.getContentPane().add(header, BorderLayout.NORTH);
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
		btn_panier.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				FEN_Panier.launch();
			}
		});
		header.add(btn_panier);
		
		JPanel sélection_type = new JPanel();
		sélection_type.setBorder(null);
		frame.getContentPane().add(sélection_type, BorderLayout.SOUTH);
		sélection_type.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn_tout_fromage = new JButton("Tout");
		affichageTout(btn_tout_fromage);
		sélection_type.add(btn_tout_fromage);
		
		JButton btn_fromage_brebis = new JButton("Attente icon b");
		filtre(btn_fromage_brebis,TypeLait.BREBIS);
		sélection_type.add(btn_fromage_brebis);
		
		JButton btn_fromage_vache = new JButton("Attente icon v");
		filtre(btn_fromage_vache,TypeLait.VACHE);
		sélection_type.add(btn_fromage_vache);
		
		JButton btn_fromage_chèvre = new JButton("Attente icon c");
		filtre(btn_fromage_chèvre,TypeLait.CHEVRE);
		sélection_type.add(btn_fromage_chèvre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1);
				
		fromagesListeDs = afficherFromagesAccueil(Main.stock.getLesFromages());
		liste_fromage = new JList(fromagesListeDs);
		liste_fromage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Fromage f = Main.stock.getFromage((String)liste_fromage.getSelectedValue());
				FEN_Détails_Fromage.launch(f);
				
			}
		});
		liste_fromage.setVisibleRowCount(10);
		scrollPane_1.setViewportView(liste_fromage);
	}

	public void affichageTout(JButton btn_tout_fromage) {
		btn_tout_fromage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateListeFromageAccueil(Main.stock.getLesFromages());
			}
		});
	}

	public void filtre(JButton btn_fromage_brebis,modele.TypeLait lait) {
		btn_fromage_brebis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FEN_Accueil.this.updateListeFromageAccueil(Main.stock.fromagesAuLaitDe(lait));
			}
		});
	}

	public String[] afficherFromagesAccueil(List<Fromage> lesFromages) {
		String[] fromagesListeD = new String[lesFromages.size()];
		for (int i = 0; i < lesFromages.size(); i++) {
			fromagesListeD[i] = lesFromages.get(i).getDésignation();
		}
		return fromagesListeD;
	}
	
	public void updateListeFromageAccueil(List<Fromage> lesFromages) {
		this.fromagesListeDs = afficherFromagesAccueil(lesFromages);
		this.liste_fromage.setListData(fromagesListeDs);
	}

}

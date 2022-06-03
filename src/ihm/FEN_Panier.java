package ihm;

import modele.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.DropMode;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;
import java.awt.CardLayout;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class FEN_Panier {

	private JFrame frame;
	private JPanel South;
	private JPanel Center;
	private JPanel South2;
	private JComboBox comboBox;
	private JTextField txtModeDeLivraison;
	private JPanel South3;
	private JButton Bouton1;
	private JButton Bouton2;
	private JButton Bouton3;
	private JLabel titrePanier;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton refreshBTN;
	
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Panier window = new FEN_Panier();
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
	public FEN_Panier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel North = new JPanel();
		frame.getContentPane().add(North, BorderLayout.NORTH);
		
		titrePanier = new JLabel("Panier");
		titrePanier.setFont(new Font("Tahoma", Font.PLAIN, 20));
		North.add(titrePanier);
		
		South = new JPanel();
		frame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(new GridLayout(2, 0, 0, 0));
		
		South2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) South2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		South.add(South2);
		
		txtModeDeLivraison = new JTextField();
		txtModeDeLivraison.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModeDeLivraison.setText("Mode de livraison");
		txtModeDeLivraison.setEditable(false);
		South2.add(txtModeDeLivraison);
		txtModeDeLivraison.setColumns(10);
		
		comboBox = new JComboBox();
		String[] listeOption = listeLivreur();
		comboBox.setModel(new DefaultComboBoxModel(listeOption));
		South2.add(comboBox);
		
		refreshBTN = new JButton("Refresh");
		refreshBTN.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				updatePanier();
			}
		});
		South2.add(refreshBTN);
		
		South3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) South3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		South.add(South3);
		
		Bouton1 = new JButton("Commander");
		Bouton1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Panier : ");
				for (Article a : Main.panier.getList()) {
					System.out.println(a.toStringAvecStock()); // avoir la quantité d'un article dans le panier
				}
				System.out.println("Stock : ");
				for (Article a : Main.panier.getList()) {
					System.out.println(Main.stock.getArticle(a.getFromage().getDésignation(), a.getClé()).toStringAvecStock()); // avoir la quantité d'un article dans le stock
				}
				
				modele.GenFacture facture = new modele.GenFacture(Main.panier);
				facture.genFac("test");

				
			}
		});
		Bouton1.setForeground(Color.BLACK);
		Bouton1.setBackground(Color.GREEN);
		South3.add(Bouton1);
		
		Bouton2 = new JButton("Vider le panier");
		Bouton2.setBackground(Color.RED);
		South3.add(Bouton2);
		
		Bouton3 = new JButton("Continuer les achats");
		Bouton3.setForeground(Color.WHITE);
		Bouton3.setBackground(Color.BLUE);
		South3.add(Bouton3);
		
		Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BoxLayout(Center, BoxLayout.X_AXIS));
		
		scrollPane = new JScrollPane();
		Center.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Produits", "Prix", "Quantit\u00E9", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		updatePanier();
		
		
		scrollPane.setViewportView(table);
	}

	private String[] listeLivreur() {
		String[] listeOption = new String[3];
		listeOption[0] = "COLISSIMO";
		listeOption[1] = "DHL";
		listeOption[2] = "MONDIAL_RELAI";
		return listeOption;
	}

	private void updatePanier() {
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		if (m.getRowCount() > 0) {
		    for (int i = m.getRowCount() - 1; i > -1; i--) {
		        m.removeRow(i);
		    }
		}
		for (Article a : Main.panier.getList()) {
			m.addRow(new Object[] {
					a.getFromage().getDésignation() + " (" + a.getClé() + ")",
					a.getPrixTTC(),
					a.getQuantitéEnStock(),
					a.getPrixTTC() * a.getQuantitéEnStock()
			});
		}
	}

}

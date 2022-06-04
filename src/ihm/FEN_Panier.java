package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modele.Article;
import modele.ModeLivraison;

import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FEN_Panier {

	private JFrame frame;
	private JPanel South;
	private JPanel Center;
	private JPanel South2;
	private JComboBox comboBox;
	private JPanel South3;
	private JButton Bouton1;
	private JButton Bouton2;
	private JButton Bouton3;
	private JLabel titrePanier;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton refreshBTN;
	private JPanel panel_Mode_Livraison;
	private JLabel affichage_Total;
	private JPanel panel_Total_Panier;
	private JTextField textField;
	private JLabel mode_De_Livraison;
	
	
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
		South.add(South2);
		South2.setLayout(new BorderLayout(0, 0));
		String[] listeOption = listeLivreur();
		
		panel_Mode_Livraison = new JPanel();
		South2.add(panel_Mode_Livraison, BorderLayout.EAST);
		
		affichage_Total = new JLabel("Total :");
		panel_Mode_Livraison.add(affichage_Total);
		
		textField = new JTextField();
		textField.setEditable(false);
		updateAffichageTotal();
		panel_Mode_Livraison.add(textField);
		textField.setColumns(5);
		
		panel_Total_Panier = new JPanel();
		South2.add(panel_Total_Panier, BorderLayout.WEST);
		
		mode_De_Livraison = new JLabel("Mode de livraison :");
		panel_Total_Panier.add(mode_De_Livraison);
		
		comboBox = new JComboBox();
		panel_Total_Panier.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox) {
					System.out.println(comboBox.getSelectedItem());		//Affiche la nouvelle selection du combo box
					
					updateAffichageTotal();
					
//					for (ModeLivraison mL : ModeLivraison.values()) {
//						if (mL.toString() == (String)comboBox.getSelectedItem()) {
//							Main.panier.setModeLivraison(mL);
//							
//						}
//					}
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(listeOption));
		
		refreshBTN = new JButton("Refresh");
		panel_Total_Panier.add(refreshBTN);
		refreshBTN.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				updatePanier();
			}
		});
		
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
				facture.genFac("facture");

				
			}
		});
		Bouton1.setForeground(Color.BLACK);
		Bouton1.setBackground(Color.GREEN);
		South3.add(Bouton1);
		
		Bouton2 = new JButton("Vider le panier");
		Bouton2.addMouseListener(viderPanier());
		Bouton2.setBackground(Color.RED);
		South3.add(Bouton2);
		
		Bouton3 = new JButton("Continuer les achats");
		Bouton3.addMouseListener(closeFEN());
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
				"Produits", "Prix Unitaire", "Quantit\u00E9", "Total"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		updatePanier();
		
		
		scrollPane.setViewportView(table);
	}

	private void updateAffichageTotal() {
		String stockArticle = "" + Main.panier.getTotal();
		textField.setText(stockArticle);
	}

	private MouseAdapter closeFEN() {
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.setVisible(false);
			}
		};
	}

	private MouseAdapter viderPanier() {
		return new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Main.panier.viderPanier(Main.stock);
				updatePanier();
				updateAffichageTotal();
			}
		};
	}

	private String[] listeLivreur() {
		String[] listeOption = new String[3];
		for (int i = 0; i < modele.ModeLivraison.getAllValues().size(); i++) {
			listeOption[i] = modele.ModeLivraison.getAllValues().get(i);
		}
		return listeOption;
	}

	private void updatePanier() {
		updateAffichageTotal();
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

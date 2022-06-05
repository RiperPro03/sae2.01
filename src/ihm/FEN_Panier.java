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
import modele.Panier;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
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
	private JPanel panel_Mode_Livraison;
	private JLabel affichage_Total;
	private JPanel panel_Total_Panier;
	private JTextField textField;
	private JLabel mode_De_Livraison;
	private JButton supArticle;
	
	
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

		panel_Total_Panier = new JPanel();
		South2.add(panel_Total_Panier, BorderLayout.WEST);
		
		mode_De_Livraison = new JLabel("Mode de livraison :");
		panel_Total_Panier.add(mode_De_Livraison);
		
		comboBox = new JComboBox();
		panel_Total_Panier.add(comboBox);
		updateChoix();
		comboBox.setModel(new DefaultComboBoxModel(listeOption));
		
		supArticle = new JButton("Supprimer l'article selectionné");
		South2.add(supArticle, BorderLayout.EAST);
		
		South3 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) South3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		South.add(South3);
		
		Bouton1 = new JButton("Commander");
		commanderPanier();
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
		refreshWindowAtFocus();
		
		supUnArticleEvent();
		
		scrollPane.setViewportView(table);
	}

	private void commanderPanier() {
		Bouton1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if(Main.panier.isEmpty()) {
					msgErreur("Vous n'avez pas d'articles à commander");
					return;
				}
				System.out.println("Panier : ");
				for (Article a : Main.panier.getList()) {
					System.out.println(a.toStringAvecStock()); // avoir la quantité d'un article dans le panier
				}
				System.out.println("Stock : ");
				for (Article a : Main.panier.getList()) {
					System.out.println(Main.stock.getArticle(a.getFromage().getDésignation(), a.getClé()).toStringAvecStock()); // avoir la quantité d'un article dans le stock
				}
				
				FEN_Info_Facturation.launch();

				
			}
		});
	}

	private void supUnArticleEvent() {
		supArticle.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel m = (DefaultTableModel) table.getModel();
				if (table.getSelectedRow() == -1) {
					if (table.getSelectedRow() == 0) {
						msgErreur("Pas d'article à supprimer");
					} else {
						msgErreur("Selectionner un article à supprimer");
					}
				} else {
					if (table.getSelectedRow() == table.getRowCount() - 1 || table.getSelectedRow() == table.getRowCount() - 2 || table.getSelectedRow() == table.getRowCount() - 3) {
						msgErreur("Selectionner un article à supprimer");
					} else {
						Main.panier.supprimerUnArticle(table.getSelectedRow());
						m.removeRow(table.getSelectedRow());
						updatePanier();
					}
				}
			}

			
		});
	}
	
	private void msgErreur(String msg) {
		JOptionPane.showMessageDialog(null, 
		         msg,
		         "Attention",
		         JOptionPane.ERROR_MESSAGE);
	}

	private void updateChoix() {
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == comboBox) {
					Main.panier.setModeLivraison(ModeLivraison.getModeLivraison((String)comboBox.getSelectedItem()));
					updatePanier();
				}
			}
		});
	}
	public void refreshWindowAtFocus() {
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				updatePanier();
			}
			public void windowLostFocus(WindowEvent e) {
				updatePanier();
			}
		});
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
				if(Main.panier.isEmpty()) {
					msgErreur("Aucun article a supprimer");
					return;
				}
				Main.panier.viderPanier(Main.stock);
				updatePanier();
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
		Main.panier.setModeLivraison(ModeLivraison.getModeLivraison((String)comboBox.getSelectedItem()));
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		if (m.getRowCount() > 0) {
		    for (int i = m.getRowCount() - 1; i > -1; i--) {
		        m.removeRow(i);
		    }
		}		

		for (Article a : Main.panier.getList()) {
			m.addRow(new Object[] {
					a.getFromage().getDésignation() + " (" + a.getClé() + ")",
					a.getPrixTTC() + "€",
					a.getQuantitéEnStock(),
					String.format("%.2f", a.getPrixTTC() * a.getQuantitéEnStock()) + "€"
			});
		}
		m.addRow(new Object[] {
				"",
				"",
				"SOUS TOTAL TTC",
				String.format("%.2f", Main.panier.getTotalSansLivraison()) + "€"
		});
		
		m.addRow(new Object[] {
				"",
				"",
				"FRAIS DE PORT",
				String.format("%.2f", Main.panier.getLivreur().getPrix()) + "€"
		});
		m.addRow(new Object[] {
				"",
				"",
				"TOTAL",
				String.format("%.2f", Main.panier.getTotal()) + "€"
		});
	}

}

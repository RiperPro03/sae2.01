package ihm;

import modele.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JTextField;

public class FEN_Info_Facturation {

	private JFrame frame;
	private JTable table1;
	private JTable table2;

	
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FEN_Info_Facturation window = new FEN_Info_Facturation();
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
	public FEN_Info_Facturation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel North = new JPanel();
		frame.getContentPane().add(North, BorderLayout.NORTH);
		
		JLabel titreInfoFacture = new JLabel("Information facture");
		titreInfoFacture.setFont(new Font("Tahoma", Font.PLAIN, 20));
		North.add(titreInfoFacture);
		
		JPanel South = new JPanel();
		frame.getContentPane().add(South, BorderLayout.SOUTH);
		South.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton Bouton1 = new JButton("Valider");
		Bouton1.setBackground(Color.GREEN);
		South.add(Bouton1);
		
		JButton Bouton2 = new JButton("Annuler");
		Bouton2.setBackground(Color.RED);
		Bouton2.setForeground(Color.BLACK);
		South.add(Bouton2);
		
		JPanel Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BoxLayout(Center, BoxLayout.X_AXIS));
		
		table1 = new JTable();
		table1.setEnabled(false);
		table1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nom"},
				{"Pr\u00E9nom"},
				{"Adresse 1"},
				{"Code Postal"},
				{"Ville"},
				{"T\u00E9l\u00E9phone"},
				{"Mail"},
			},
			new String[] {
				"Info"
			}
		));
		Center.add(table1);
		
		table2 = new JTable();
		table2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
				{null},
			},
			new String[] {
				"New column"
			}
		));
		Center.add(table2);
	}

}

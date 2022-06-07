package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import modele.GenFacture;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class FEN_Info_Facturation {

	private JFrame frame;
	private JTextField Label_Nom;
	private JTextField Label_Prénom;
	private JTextField Label_Adresse;
	private JTextField Label_Code_Postal;
	private JTextField Label_Ville;
	private JTextField Label_Téléphone;
	private JTextField Label_Mail;
	private JTextField Nom;
	private JTextField Prénom;
	private JTextField Adresse;
	private JTextField Code_Postal;
	private JTextField Ville;
	private JTextField Téléphone;
	private JTextField Mail;

	private List<String> infoClient = new LinkedList<String>();

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
		frame.setBounds(100, 100, 600, 400);
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
		commander(Bouton1);
		Bouton1.setBackground(Color.GREEN);
		South.add(Bouton1);

		JButton Bouton2 = new JButton("Annuler");
		fermerFEN(Bouton2);
		Bouton2.setBackground(Color.RED);
		Bouton2.setForeground(Color.BLACK);
		South.add(Bouton2);

		JPanel Center = new JPanel();
		frame.getContentPane().add(Center, BorderLayout.CENTER);
		Center.setLayout(new BorderLayout(0, 0));

		JPanel Information = new JPanel();
		Center.add(Information, BorderLayout.NORTH);
		Information.setLayout(new BoxLayout(Information, BoxLayout.X_AXIS));

		JPanel Label_Information = new JPanel();
		Information.add(Label_Information);
		Label_Information.setLayout(new BoxLayout(Label_Information, BoxLayout.Y_AXIS));

		Label_Nom = new JTextField();
		Label_Nom.setEditable(false);
		Label_Nom.setText("Nom");
		Label_Information.add(Label_Nom);
		Label_Nom.setColumns(10);

		Label_Prénom = new JTextField();
		Label_Prénom.setEditable(false);
		Label_Prénom.setText("Prénom");
		Label_Information.add(Label_Prénom);
		Label_Prénom.setColumns(10);

		Label_Adresse = new JTextField();
		Label_Adresse.setText("Adresse");
		Label_Adresse.setEditable(false);
		Label_Information.add(Label_Adresse);
		Label_Adresse.setColumns(10);

		Label_Code_Postal = new JTextField();
		Label_Code_Postal.setText("Code Postal");
		Label_Code_Postal.setEditable(false);
		Label_Information.add(Label_Code_Postal);
		Label_Code_Postal.setColumns(10);

		Label_Ville = new JTextField();
		Label_Ville.setEditable(false);
		Label_Ville.setText("Ville");
		Label_Information.add(Label_Ville);
		Label_Ville.setColumns(10);

		Label_Téléphone = new JTextField();
		Label_Téléphone.setText("Téléphone");
		Label_Téléphone.setEditable(false);
		Label_Information.add(Label_Téléphone);
		Label_Téléphone.setColumns(10);

		Label_Mail = new JTextField();
		Label_Mail.setText("Mail");
		Label_Mail.setEditable(false);
		Label_Information.add(Label_Mail);
		Label_Mail.setColumns(10);

		JPanel Remplir_Information = new JPanel();
		Information.add(Remplir_Information);
		Remplir_Information.setLayout(new BoxLayout(Remplir_Information, BoxLayout.Y_AXIS));

		Nom = new JTextField();
		Remplir_Information.add(Nom);
		Nom.setColumns(10);

		Prénom = new JTextField();
		Remplir_Information.add(Prénom);
		Prénom.setColumns(10);

		Adresse = new JTextField();
		Remplir_Information.add(Adresse);
		Adresse.setColumns(10);

		Code_Postal = new JTextField();
		Remplir_Information.add(Code_Postal);
		Code_Postal.setColumns(10);

		Ville = new JTextField();
		Remplir_Information.add(Ville);
		Ville.setColumns(10);

		Téléphone = new JTextField();
		Remplir_Information.add(Téléphone);
		Téléphone.setColumns(10);

		Mail = new JTextField();
		Remplir_Information.add(Mail);
		Mail.setColumns(10);


	}

	private void commander(JButton Bouton1) {
		Bouton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Nom.getText().isEmpty() || Prénom.getText().isEmpty() || Adresse.getText().isEmpty() || Ville.getText().isEmpty() || Téléphone.getText().isEmpty() || Mail.getText().isEmpty()) {
					msgErreur("Veillez saisir vos informations de facturation");
					return;
				}
				infoClient.add(Nom.getText());
				infoClient.add(Prénom.getText());
				infoClient.add(Adresse.getText());
				infoClient.add(Code_Postal.getText());
				infoClient.add(Ville.getText());
				infoClient.add(Téléphone.getText());
				infoClient.add(Mail.getText());
				GenFacture facture = new GenFacture(Main.panier,infoClient);
				String nomFac = Nom.getText() + "_Facture";
				facture.genFac(nomFac);
				
				String laFacture = facture.factureToDisplay();
				FEN_AffichageFacture.launch(laFacture);
				
				infoClient.clear();
				Main.panier.commander();
				JOptionPane.showMessageDialog(null, 
						"Merci de nous avoir choisi vous allez recevoir une facture en copie",
						"Merci de votre confiance",
						JOptionPane.INFORMATION_MESSAGE);
				frame.setVisible(false);

			}
		});
	}

	private void fermerFEN(JButton Bouton2) {
		Bouton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
	}
	private void msgErreur(String msg) {
		JOptionPane.showMessageDialog(null, 
				msg,
				"Attention",
				JOptionPane.ERROR_MESSAGE);
	}

}
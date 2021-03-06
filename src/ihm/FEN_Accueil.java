package ihm;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import modele.Fromage;
import modele.TypeLait;

import java.awt.Font;
import java.awt.Component;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class FEN_Accueil {
	
	private JFrame frame;
	private JTextField txtFromageQuiRit;
	private JList liste_fromage;
	private String[] fromagesListeDs;
	private JButton btn_panier;

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
		frame.setBounds(100, 100, 525, 622);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel header = new JPanel();
		header.setBorder(null);
		frame.getContentPane().add(header, BorderLayout.NORTH);
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel image_header = new JLabel("     ");
		image_header.setHorizontalAlignment(SwingConstants.CENTER);
		easterEgg(image_header);
		ImageIcon fromageImg = new ImageIcon("src/img/iconFromage.png");
		Image image = fromageImg.getImage();
		Image newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		fromageImg = new ImageIcon(newimg);
		image_header.setIcon(fromageImg);
		Border border = image_header.getBorder();
		Border margin = new EmptyBorder(10,10,10,10);
		image_header.setBorder(new CompoundBorder(border, margin));
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
		
		btn_panier = new JButton(" 0??? ");
		ImageIcon panierImg = new ImageIcon("src/img/iconCaddie.png");
		image = panierImg.getImage();
		newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		panierImg = new ImageIcon(newimg);
		btn_panier.setIcon(panierImg);
		refreshWindowAtFocus();
		ouvrirPanier();
		header.add(btn_panier);
		
		JPanel s??lection_type = new JPanel();
		s??lection_type.setBorder(null);
		frame.getContentPane().add(s??lection_type, BorderLayout.SOUTH);
		s??lection_type.setLayout(new GridLayout(0, 4, 0, 0));
		
		JButton btn_tout_fromage = new JButton("Tout");
		affichageTout(btn_tout_fromage);
		s??lection_type.add(btn_tout_fromage);
		
		JButton btn_fromage_brebis = new JButton("");
		ImageIcon brebisImg = new ImageIcon("src/img/iconBrebis.png");
		image = brebisImg.getImage();
		newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		brebisImg = new ImageIcon(newimg);
		btn_fromage_brebis.setIcon(brebisImg);
		
		filtre(btn_fromage_brebis,TypeLait.BREBIS);
		s??lection_type.add(btn_fromage_brebis);
		
		JButton btn_fromage_vache = new JButton("");
		ImageIcon vacheImg = new ImageIcon("src/img/iconVache.png");
		image = vacheImg.getImage();
		newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		vacheImg = new ImageIcon(newimg);
		btn_fromage_vache.setIcon(vacheImg);
		filtre(btn_fromage_vache,TypeLait.VACHE);
		s??lection_type.add(btn_fromage_vache);
		JButton btn_fromage_ch??vre = new JButton("");
		ImageIcon ch??vreImg = new ImageIcon("src/img/iconCh??vre.png");
		image = ch??vreImg.getImage(); 
		newimg = image.getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		ch??vreImg = new ImageIcon(newimg);
		btn_fromage_ch??vre.setIcon(ch??vreImg);
		
		filtre(btn_fromage_ch??vre,TypeLait.CHEVRE);
		s??lection_type.add(btn_fromage_ch??vre);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1);
				
		fromagesListeDs = afficherFromagesAccueil(Main.stock.getLesFromages());
		liste_fromage = new JList(fromagesListeDs);
		ouvrirDetailFromage();
		liste_fromage.setVisibleRowCount(10);
		scrollPane_1.setViewportView(liste_fromage);
	}

	private void ouvrirDetailFromage() {
		liste_fromage.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Fromage f = Main.stock.getFromage((String)liste_fromage.getSelectedValue());
				FEN_D??tails_Fromage.launch(f);
				
			}
		});
	}

	private void ouvrirPanier() {
		btn_panier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FEN_Panier.launch();
			}
		});
	}

	private void easterEgg(JLabel image_header) {
		image_header.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, 
		                 "hmmmmmm le bon fromage de ch??vre",
		                 "Easter Egg",
		                 JOptionPane.INFORMATION_MESSAGE);
			}
		});
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
			fromagesListeD[i] = lesFromages.get(i).getD??signation();
		}
		return fromagesListeD;
	}
	
	public void updateListeFromageAccueil(List<Fromage> lesFromages) {
		this.fromagesListeDs = afficherFromagesAccueil(lesFromages);
		this.liste_fromage.setListData(fromagesListeDs);
	}
	public void refreshWindowAtFocus() {
		frame.addWindowFocusListener(new WindowFocusListener() {
			public void windowGainedFocus(WindowEvent e) {
				updatePanierPrix();
			}
			public void windowLostFocus(WindowEvent e) {
				updatePanierPrix();
			}
		});
	}

	protected void updatePanierPrix() {
		this.btn_panier.setText(String.format("%.2f",Main.panier.getTotalSansLivraison()) + "???");
	}
		
	}
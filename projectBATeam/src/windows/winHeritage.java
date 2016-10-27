package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public abstract class winHeritage extends JFrame {

	protected JMenuBar menuBar;
	protected JMenu mnEntretien;
	protected JMenuItem mnItemAjouter;
	protected JMenuItem mnItemModifier;
	protected JMenuItem mnItemDtruire ;
	protected JMenu mnListes;
	protected JMenu mnRapports;
	protected JMenu mnQuitter;
	protected JMenuItem mnItemListeDesBons;

	
	protected JPanel panelHeritage;
	protected JButton btnAnnuler;
	protected JButton btnSuivant;
	protected JButton btnDernier;
	protected JButton btnPrecedent;
	protected JButton btnPremier;
	protected JButton btnAjouter;
	protected JButton btnSupprimer;
	protected JButton btnConsulter;
	protected JButton btnModifier;
	protected JButton btnQuitter;
	protected JButton btnEnregistrer;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//c'est une classe abstraite, on ne peux pas l'instancier
					//winHeritage frame = new winHeritage();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public winHeritage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 700);
		panelHeritage = new JPanel();
		panelHeritage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelHeritage);
		panelHeritage.setLayout(null);
		
		JLabel lblLogo = new JLabel("Logo");
		lblLogo.setIcon(new ImageIcon(winHeritage.class.getResource("/elementsGraphiques/Images/BATeam.jpg")));
		lblLogo.setBounds(6, 6, 100, 41);
		panelHeritage.add(lblLogo);
		
		btnSuivant = new JButton(">");
		btnSuivant.setBounds(242, 16, 30, 22);
		panelHeritage.add(btnSuivant);
		
		btnDernier = new JButton(">>");
		btnDernier.setBounds(284, 16, 30, 22);
		panelHeritage.add(btnDernier);
		
		btnPrecedent = new JButton("<");
		btnPrecedent.setBounds(200, 16, 30, 22);
		panelHeritage.add(btnPrecedent);
		
	    btnPremier = new JButton("<<");
		btnPremier.setBounds(158, 16, 30, 22);
		panelHeritage.add(btnPremier);
		
		btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(6, 102, 150, 50);
		panelHeritage.add(btnAjouter);
		
		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(6, 191, 150, 50);
		panelHeritage.add(btnSupprimer);
		
		btnConsulter = new JButton("Consulter");
		btnConsulter.setBounds(6, 368, 150, 50);
		panelHeritage.add(btnConsulter);
		
		btnModifier = new JButton("Modifier");
		btnModifier.setBounds(6, 282, 150, 50);
		panelHeritage.add(btnModifier);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setBounds(6, 450, 150, 50);
		panelHeritage.add(btnQuitter);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(6, 577, 150, 30);
		panelHeritage.add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(6, 620, 150, 30);
		panelHeritage.add(btnAnnuler);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnEntretien = new JMenu("Entretien");
		menuBar.add(mnEntretien);
		
		mnItemAjouter = new JMenuItem("Ajouter");
		mnEntretien.add(mnItemAjouter);
		
		mnItemModifier = new JMenuItem("Modifier");
		mnEntretien.add(mnItemModifier);
		
		mnItemDtruire = new JMenuItem("Détruire");
		mnEntretien.add(mnItemDtruire);
		
		mnListes = new JMenu("Listes");
		menuBar.add(mnListes);
		
		mnItemListeDesBons = new JMenuItem("Liste des bons d'achats pour un intervalle de date");
		mnListes.add(mnItemListeDesBons);
		
		mnRapports = new JMenu("Rapports");
		menuBar.add(mnRapports);
		
		mnQuitter = new JMenu("Quitter");
		menuBar.add(mnQuitter);
	}
}

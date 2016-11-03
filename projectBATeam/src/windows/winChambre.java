package windows;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import controleurs.ctrlChambre;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class winChambre extends winHeritage {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelChambre;
	private JLabel lblNoChambre;
	private JLabel lblEtage;
	private JLabel lblCodeType;
	private JLabel lblCodelocalisation;
	private JLabel lblEtat;
	private JLabel lblPrix;
	private JLabel lblDescriptionCodeType;
	private JLabel lblDescriptionCodeLocalisation;
	private JTextField txtNoChambre;
	private JTextField txtEtage;
	private JTextField txtEtat;
	private JTextField txtCodeType;
	private JTextField txtCodeLocalisation;
	private JTextField txtPrix;
	private JTextField txtDescriptionCodeType;
	private JTextField txtDescriptionCodeLocalisation;
	private JTextField txtMemo;
	public JCheckBox chckbxEnEtat;
	public JCheckBox chckbxHorsDusage;
	public JButton btnAjoutAyant;
	public JButton btnSupprimerAyant;
	
	public boolean AjoutActive = false;
	
	private ctrlChambre leControllerChambre ;
	private winChambre instance;
	private static JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winHeritage frame = new winChambre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public winChambre() {
		super();

		instance = this;
		Setup();
		ModeConsultation();
		
		

//---------------ACTION DES BOUTON DE LA FRAME----------------------------
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(AjoutActive == true)
				{
					ModeConsultation();
				}
			}
		});
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
					leControllerChambre.validationChambre(instance);	
			}
		});
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winChambre.this.dispose();			
			}
		});
		btnModifier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnConsulter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModeConsultation();
			}
		});
		btnSupprimer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnAjouter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ModeAjout();
				leControllerChambre.setAjout();
			}
		});
		
		
		
//---------------ACTION DU MENU DE LA FRAME----------------------------

		mnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winChambre.this.dispose();			
				}
		});		
		mnRapports.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		mnListes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		mnEntretien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});

		//Gestion de la souris sur le menu et la navigation

		btnPremier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.Premier(instance);
			}
		});
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.BonPrecedent(instance);
			}
		});
		btnDernier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.Dernier(instance);
			}
		});
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.BonSuivant(instance);
			}
		});
		btnAjoutAyant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				leControllerChambre.addCodCom();
			}
		});
		btnSupprimerAyant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.removeCodCom();
			}
		});
		txtNoChambre.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(AjoutActive == false)
			{
				leControllerChambre.ListeChambres(instance, AjoutActive);
			}
		}
		});
		txtCodeType.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(AjoutActive == true)
			{
				leControllerChambre.ListeCodType(instance, AjoutActive);
			}
		}
		});
		txtCodeLocalisation.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if(AjoutActive == true)
			{
				leControllerChambre.ListeCodLocalisation(instance, AjoutActive);
			}
		}
		});
		chckbxEnEtat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.setChckbxEnEtatSelected(leControllerChambre.getChckbxEnEtatSelected(instance), instance);
			}
		});
		chckbxHorsDusage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerChambre.setChckbxHorsDusageSelected(leControllerChambre.getChckbxEnEtatSelected(instance), instance);
			}
		});
		
		

	}
	private void Setup()
	{
			leControllerChambre = new ctrlChambre(instance);
		
		   //Composants graphiques des chambres	    
			panelChambre = new JPanel();
			panelChambre.setBackground(SystemColor.windowBorder);
			panelChambre.setBounds(204, 108, 890, 205);
			getContentPane().add(panelChambre);
			panelChambre.setLayout(null);
			
			lblNoChambre = new JLabel("No. Chambre :");
			lblNoChambre.setBounds(6, 6, 92, 16);
			panelChambre.add(lblNoChambre);
			
			lblEtage = new JLabel("Etage :");
			lblEtage.setBounds(6, 48, 82, 16);
			panelChambre.add(lblEtage);
			
			lblEtat = new JLabel("Etat :");
			lblEtat.setBounds(6, 103, 82, 16);
			panelChambre.add(lblEtat);

		    lblCodeType = new JLabel("Code_Type :");
			lblCodeType.setBounds(255, 6, 130, 16);
			panelChambre.add(lblCodeType);
			
			lblCodelocalisation = new JLabel("Code_Localisation :");
			lblCodelocalisation.setBounds(255, 48, 130, 16);
			panelChambre.add(lblCodelocalisation);
			
			lblPrix = new JLabel("Prix :");
			lblPrix.setBounds(255, 103, 130, 16);
			panelChambre.add(lblPrix);
			
			lblDescriptionCodeType = new JLabel("Description :");
			lblDescriptionCodeType.setBounds(556, 6, 130, 16);
			panelChambre.add(lblDescriptionCodeType);
			
			lblDescriptionCodeLocalisation = new JLabel("Description :");
			lblDescriptionCodeLocalisation.setBounds(556, 48, 130, 16);
			panelChambre.add(lblDescriptionCodeLocalisation);
					
			chckbxEnEtat = new JCheckBox("En état");
			chckbxEnEtat.setEnabled(false);
			chckbxEnEtat.setVisible(false);
			chckbxEnEtat.setBounds(102, 131, 75, 23);

			
			chckbxHorsDusage = new JCheckBox("Hors d'usage");
			chckbxHorsDusage.setEnabled(false);
			chckbxHorsDusage.setVisible(false);
			chckbxHorsDusage.setBounds(102, 150, 128, 23);


			
			panelChambre.add(getTxtNoChambre());
			panelChambre.add(getTxtEtage());
			panelChambre.add(getTxtPrix());
			panelChambre.add(getTxtEtat());
			panelChambre.add(getTxtMemo());
			panelChambre.add(getTxtCodTypeCha());
			panelChambre.add(getTxtDescType());
			panelChambre.add(getTxtCodLoc());
			panelChambre.add(getTxtDescLoc());
			panelChambre.add(chckbxEnEtat);
			panelChambre.add(chckbxHorsDusage);


			btnAjoutAyant = new JButton("+");
			btnAjoutAyant.setEnabled(false);
			btnAjoutAyant.setVisible(false);
			btnAjoutAyant.setBounds(204, 324, 30, 30);
			getContentPane().add(btnAjoutAyant);
			
			btnSupprimerAyant = new JButton("-");
			btnSupprimerAyant.setEnabled(false);
			btnSupprimerAyant.setVisible(false);
			btnSupprimerAyant.setBounds(246, 324, 30, 30);
			getContentPane().add(btnSupprimerAyant);

			
			//label titre indiquant l'information de la chambre
			JLabel lblInfoChambre = new JLabel("Information sur la Chambre :");
			lblInfoChambre.setBounds(204, 74, 196, 16);
			getContentPane().add(lblInfoChambre);
			
			//composante graphique de Ayant
			getContentPane().add(getScrollPane());
			

			
			
			
	}
	private void ModeConsultation() {
		leControllerChambre = new ctrlChambre(instance);
		
		this.AjoutActive = false;
		
		btnConsulter.setEnabled(false);
		btnEnregistrer.setEnabled(false);
		btnAnnuler.setEnabled(false);
		btnAjoutAyant.setEnabled(false);
		btnAjoutAyant.setVisible(false);
		btnSupprimerAyant.setEnabled(false);
		btnSupprimerAyant.setVisible(false);
		btnAjouter.setEnabled(true);
		btnPrecedent.setEnabled(true);
		btnDernier.setEnabled(true);
		btnPremier.setEnabled(true);
		btnSuivant.setEnabled(true);

		txtNoChambre.setEditable(false);
		txtEtage.setEditable(false);
		txtPrix.setEditable(false);
		txtMemo.setEditable(false);
		txtEtat.setEditable(false);
		txtCodeType.setEditable(false);
		txtDescriptionCodeType.setEditable(false);
		txtCodeLocalisation.setEditable(false);
		txtDescriptionCodeLocalisation.setEditable(false);
		chckbxEnEtat.setVisible(false);
		chckbxHorsDusage.setVisible(false);
	
	}
	private void ModeAjout()
	{
		btnAjouter.setEnabled(false);
		btnConsulter.setEnabled(true);
		btnEnregistrer.setEnabled(true);
		btnAnnuler.setEnabled(true);
		btnPrecedent.setEnabled(false);
		btnDernier.setEnabled(false);
		btnPremier.setEnabled(false);
		btnSuivant.setEnabled(false);
		btnAjoutAyant.setEnabled(true);
		btnAjoutAyant.setVisible(true);
		btnSupprimerAyant.setEnabled(true);
		btnSupprimerAyant.setVisible(true);
		
		this.AjoutActive = true;
		
		txtNoChambre.setEditable(true);
		txtNoChambre.setText("");
		txtEtage.setEditable(true);
		txtEtage.setText("");
		txtPrix.setEditable(true);
		txtPrix.setText("");
		txtMemo.setEditable(true);
		txtMemo.setText("");
		txtEtat.setEditable(false);
		txtEtat.setText("");
		txtCodeType.setEditable(false);
		txtCodeType.setText("");
		txtDescriptionCodeType.setEditable(false);
		txtDescriptionCodeType.setText("");
		txtCodeLocalisation.setEditable(false);
		txtCodeLocalisation.setText("");
		txtDescriptionCodeLocalisation.setEditable(false);
		txtDescriptionCodeLocalisation.setText("");
		
		chckbxEnEtat.setEnabled(true);
		chckbxEnEtat.setVisible(true);
		

		chckbxHorsDusage.setEnabled(true);
		chckbxHorsDusage.setVisible(true);
		
		JTable tableVide = new JTable();
		setjScrollPane(tableVide);
		

	}
	private JScrollPane getScrollPane() {
		scrollPane.setBounds(204, 370, 890, 205);
		return scrollPane;		
	}
	public static void setjScrollPane(JTable UneTable)
	{
		if (scrollPane == null) 
		   {
			scrollPane = new JScrollPane(UneTable);
			scrollPane.setBounds(20, 7,515, 175);
		   }
		scrollPane.setViewportView(UneTable);
	}
	public static void addjScrollPane(JTable UneTable)
	{
		if (scrollPane == null) 
		   {
			scrollPane = new JScrollPane(UneTable);
			scrollPane.setBounds(20, 7,515, 175);
		   }
		scrollPane.add(UneTable);
		scrollPane.setViewportView(UneTable);
	}
	public JTextField getTxtNoChambre() {
		if(txtNoChambre == null)
		{
			txtNoChambre = new JTextField();
			txtNoChambre.setBounds(100, 1, 130, 26);
			txtNoChambre.setColumns(10);
		}
		return txtNoChambre;
	}
	public JTextField getTxtEtage() {
		if(txtEtage == null)
		{
			txtEtage = new JTextField();
			txtEtage.setColumns(10);
			txtEtage.setBounds(100, 43, 130, 26);
		}
		return txtEtage;
	}
	public JTextField getTxtPrix() {
		if(txtPrix == null)
		{
			txtPrix = new JTextField("$",10);
			txtPrix.setColumns(10);
			txtPrix.setBounds(389, 98, 130, 26);
		}
		
		return txtPrix;
	}
	public JTextField getTxtMemo() {
		if(txtMemo == null)
		{
			txtMemo = new JTextField();
			txtMemo.setText("Description spéciale de la chambre");
			txtMemo.setBounds(556, 103, 328, 81);
			txtMemo.setColumns(10);
		}
		
		return txtMemo;
	}
	public JTextField getTxtEtat() {
		if(txtEtat == null)
		{
			txtEtat = new JTextField();
			txtEtat.setColumns(10);
			txtEtat.setBounds(100, 98, 130, 26);
		}
		
		return txtEtat;
	}
	public JTextField getTxtCodTypeCha() {
		if(txtCodeType == null)
		{
			txtCodeType = new JTextField();
			txtCodeType.setBounds(389, 1, 130, 26);
			txtCodeType.setColumns(10);
		}
		
		return txtCodeType;
	}
	public JTextField getTxtDescType() {
		if(txtDescriptionCodeType == null)
		{
			txtDescriptionCodeType = new JTextField();
			txtDescriptionCodeType.setColumns(10);
			txtDescriptionCodeType.setBounds(656, 1, 228, 26);
		}
		
		return txtDescriptionCodeType;
	}
	public JTextField getTxtCodLoc() {
		if(txtCodeLocalisation == null)
		{
			txtCodeLocalisation = new JTextField();
			txtCodeLocalisation.setColumns(10);
			txtCodeLocalisation.setBounds(389, 43, 130, 26);
		}
		
		return txtCodeLocalisation;
	}
	public JTextField getTxtDescLoc() {
		if(txtDescriptionCodeLocalisation == null)
		{
			txtDescriptionCodeLocalisation = new JTextField();
			txtDescriptionCodeLocalisation.setColumns(10);
			txtDescriptionCodeLocalisation.setBounds(656, 43, 228, 26);
		}
		
		return txtDescriptionCodeLocalisation;
	}
}


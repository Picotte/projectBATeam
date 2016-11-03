package windows;

import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleurs.ctrlReservation;

public class winReservation extends winHeritage {
//------test2
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelReservationDeGauche;
	private JLabel lblNoClient;
	private JTextField txtNoClient;
	public JTable tableReservationDe;
	private JPanel panelReservationDeDroite;
	private JLabel lblNoreservation;
	private JTextField txtNoReser;
	private JLabel lblNom;
	private JTextField txtNom;
	private JLabel lblAdresse;
	private JTextField txtAdresse;
	private JLabel lblTlphone;
	private JTextField txtTelephone;
	private JTextField txtFax;
	private JLabel lblFax;
	private JLabel lblTypeDeCarte;
	private JTextField txtTypeCarte;
	private JLabel lblExpiration;
	private JTextField txtExpiration;
	private JLabel lblSoldeD;
	private JTextField txtSoldeDu;
	private JLabel lblRservLe;
	private JLabel lblDateDeDbut;
	private JLabel lblDateDeFin;
	private JTextField txtDateReser;
	private JTextField txtDateDebut;
	private JTextField txtDateFin;
	private JLabel lblInformationSurLe;
	private JLabel lblInformationSurLa;
	
	private ctrlReservation leControllerReservation;
	private winReservation instance;
	private static JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winHeritage frame = new winReservation();
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
	public winReservation() {
		super();
		instance = this;

		
		

//---------------ACTION DES BOUTON DE LA FRAME----------------------------
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winReservation.this.dispose();			
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
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		
		
//---------------ACTION DU MENU DE LA FRAME----------------------------

		mnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winReservation.this.dispose();			
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
		
		ModeConsultation();

	}
	
	private void setup(){
		
		leControllerReservation = new ctrlReservation(instance);
		
		panelReservationDeGauche = new JPanel();
		panelReservationDeGauche.setBackground(SystemColor.windowBorder);
		panelReservationDeGauche.setBounds(182, 108, 469, 205);
		getContentPane().add(panelReservationDeGauche);
		panelReservationDeGauche.setLayout(null);

		lblNoClient = new JLabel("Client no :");
		lblNoClient.setBounds(20, 10, 77, 16);
		panelReservationDeGauche.add(lblNoClient);
		panelReservationDeGauche.add(getTxtNoClient());
		lblNom = new JLabel("Nom :");
		lblNom.setBounds(200, 10, 46, 16);
		panelReservationDeGauche.add(lblNom);
		panelReservationDeGauche.add(getTxtNom());
		lblAdresse = new JLabel("Adresse :");
		lblAdresse.setBounds(20, 50, 77, 16);
		panelReservationDeGauche.add(lblAdresse);
		panelReservationDeGauche.add(getTxtAdresse());
		lblTlphone = new JLabel("Téléphone :");
		lblTlphone.setBounds(20, 90, 77, 16);
		panelReservationDeGauche.add(lblTlphone);
		panelReservationDeGauche.add(getTxtTelephone());
		panelReservationDeGauche.add(getTxtFax());
		lblFax = new JLabel("Fax :");
		lblFax.setBounds(275, 90, 35, 16);
		panelReservationDeGauche.add(lblFax);
		lblTypeDeCarte = new JLabel("Type de Carte :");
		lblTypeDeCarte.setBounds(20, 130, 100, 16);
		panelReservationDeGauche.add(lblTypeDeCarte);
		panelReservationDeGauche.add(getTxtTypeCarte());
		lblExpiration = new JLabel("Expiration :");
		lblExpiration.setBounds(20, 170, 100, 16);
		panelReservationDeGauche.add(lblExpiration);
		panelReservationDeGauche.add(getTxtExpiration());
		lblSoldeD = new JLabel("Solde dü :");
		lblSoldeD.setBounds(274, 170, 64, 16);
		panelReservationDeGauche.add(lblSoldeD);
		panelReservationDeGauche.add(getTxtSoldeDu());
		panelReservationDeDroite = new JPanel();
		panelReservationDeDroite.setLayout(null);
		panelReservationDeDroite.setBackground(SystemColor.windowBorder);
		panelReservationDeDroite.setBounds(685, 108, 440, 205);
		getContentPane().add(panelReservationDeDroite);
		lblNoreservation = new JLabel("No.Reservation :");
		lblNoreservation.setBounds(70, 20, 115, 16);
		panelReservationDeDroite.add(lblNoreservation);
		panelReservationDeDroite.add(getTxtNoReser());
		lblRservLe = new JLabel("Réservé le :");
		lblRservLe.setBounds(70, 70, 92, 16);
		panelReservationDeDroite.add(lblRservLe);
		lblDateDeDbut = new JLabel("Date de début :");
		lblDateDeDbut.setBounds(70, 120, 115, 16);
		panelReservationDeDroite.add(lblDateDeDbut);
		lblDateDeFin = new JLabel("Date de fin :");
		lblDateDeFin.setBounds(70, 170, 92, 16);
		panelReservationDeDroite.add(lblDateDeFin);
		panelReservationDeDroite.add(getTxtDateReser());
		panelReservationDeDroite.add(getTxtDateDebut());
		panelReservationDeDroite.add(getTxtDateFin());
	
		getContentPane().add(getScrollPane());
		
		JLabel lblInformationSurLe = new JLabel("Information sur le client qui réserve");
		lblInformationSurLe.setBounds(182, 80, 290, 16);
		getContentPane().add(lblInformationSurLe);
		
		JLabel lblInformationSurLa = new JLabel("Information sur la réservation");
		lblInformationSurLa.setBounds(685, 80, 290, 16);
		getContentPane().add(lblInformationSurLa);
		
		
	}

	private void ModeConsultation() {
		setup();
		
		lblInformationSurLe = new JLabel("Information sur le client qui réserve");
		lblInformationSurLe.setBounds(182, 80, 240, 16);
		getContentPane().add(lblInformationSurLe);
		
		lblInformationSurLa = new JLabel("Information sur la réservation");
		lblInformationSurLa.setBounds(685, 80, 240, 16);
		getContentPane().add(lblInformationSurLa);
		
		//Gestion de la souris sur le menu et la navigation
		
		btnPremier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerReservation.Premier(instance);
			}
		});
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerReservation.BonPrecedent(instance);
			}
		});
		btnDernier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerReservation.Dernier(instance);
			}
		});
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leControllerReservation.BonSuivant(instance);
			}
		});
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
	
	public JTextField getTxtNoClient() {
		if(txtNoClient == null)
		{
			txtNoClient = new JTextField();
			txtNoClient.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					leControllerReservation.ListeClient(instance);
				}
			});
			txtNoClient.setEditable(false);
			txtNoClient.setBounds(125, 5, 64, 26);
			txtNoClient.setColumns(10);
		}
		return txtNoClient;
	}
	public JTextField getTxtNom() {
		if(txtNom == null)
		{
			txtNom = new JTextField();
			txtNom.setEditable(false);
			txtNom.setBounds(250, 5, 200, 26);
			txtNom.setColumns(10);
		}
		return txtNom;
	}
	public JTextField getTxtAdresse() {
		if(txtAdresse == null)
		{
			txtAdresse = new JTextField();
			txtAdresse.setEditable(false);
			txtAdresse.setBounds(125, 45, 325, 26);
			txtAdresse.setColumns(10);
		}
		return txtAdresse;
	}
	public JTextField getTxtTelephone() {
		if(txtTelephone == null)
		{
			txtTelephone = new JTextField();
			txtTelephone.setEditable(false);
			txtTelephone.setBounds(125, 85, 130, 26);
			txtTelephone.setColumns(10);
		}
		return txtTelephone;
	}
	public JTextField getTxtFax() {
		if(txtFax == null)
		{
			txtFax = new JTextField();
			txtFax.setEditable(false);
			txtFax.setBounds(320, 85, 130, 26);
			txtFax.setColumns(10);
		}
		return txtFax;
	}
	public JTextField getTxtTypeCarte() {
		if(txtTypeCarte == null)
		{
			txtTypeCarte = new JTextField();
			txtTypeCarte.setEditable(false);
			txtTypeCarte.setBounds(125, 125, 130, 26);
			txtTypeCarte.setColumns(10);
		}
		return txtTypeCarte;
	}
	public JTextField getTxtExpiration() {
		if(txtExpiration == null)
		{
			txtExpiration = new JTextField();
			txtExpiration.setEditable(false);
			txtExpiration.setBounds(125, 165, 130, 26);
			txtExpiration.setColumns(10);
		}
		return txtExpiration;
	}
	public JTextField getTxtSoldeDu() {
		if(txtSoldeDu == null)
		{
			txtSoldeDu = new JTextField();
			txtSoldeDu.setEditable(false);
			txtSoldeDu.setBounds(350, 165, 100, 26);
			txtSoldeDu.setColumns(10);
		}
		return txtSoldeDu;
	}
	public JTextField getTxtNoReser() {
		if(txtNoReser == null)
		{
			txtNoReser = new JTextField();
			txtNoReser.setEditable(false);
			txtNoReser.setBounds(217, 15, 130, 26);
			txtNoReser.setColumns(10);
		}
		return txtNoReser;
	}
	public JTextField getTxtDateReser() {
		if(txtDateReser == null)
		{
			txtDateReser = new JTextField();
			txtDateReser.setEditable(false);
			txtDateReser.setBounds(217, 65, 130, 26);
			txtDateReser.setColumns(10);
		}
		return txtDateReser;
	}
	public JTextField getTxtDateDebut() {
		if(txtDateDebut == null)
		{
			txtDateDebut = new JTextField();
			txtDateDebut.setEditable(false);
			txtDateDebut.setBounds(217, 115, 130, 26);
			txtDateDebut.setColumns(10);
		}
		return txtDateDebut;
	}
	public JTextField getTxtDateFin() {
		if(txtDateFin == null)
		{
			txtDateFin = new JTextField();
			txtDateFin.setEditable(false);
			txtDateFin.setBounds(217, 165, 130, 26);
			txtDateFin.setColumns(10);
		}
		return txtDateFin;
	}
}

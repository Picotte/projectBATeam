package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import controleurs.ctrlArrive;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;;

public class winArriver extends winHeritage {

	private JPanel contentPane;
	private JTextField textFieldClientNo;
	private JTextField textFieldClientNom;
	private JTextField textFieldAdresse;
	private JTextField textFieldTelephone;
	private JTextField textFieldFax;
	private JTextField textFieldNumeroChambre;
	private JTextField textFieldNoReser;
	private JTextField textFieldReservLe;
	private JTextField textFieldDateDebut;
	private JTextField textFieldDateFin;
	private JTextField textFieldClientNoReserv;
	private JTextField textFieldNomReserv;
	private static JScrollPane scrollPaneZoneN;
	private winArriver instance;
	private ctrlArrive ctrlArr = null;
	private JButton btnPickList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winHeritage frame = new winArriver();
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
	public winArriver() {
		instance = this;
		
		Setup();
		ctrlArr = new ctrlArrive(instance);
		
		ModeConsultation();
		
		
		/*setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);*/
		
		
		/*BOUTON*/
		btnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winArriver.this.dispose();			
			}
		});
		
		btnEnregistrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		});
		
		btnAnnuler.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "En construction", "Désolé",JOptionPane.ERROR_MESSAGE);
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
		
		mnQuitter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				winPrincipale fenPrincipale = new winPrincipale();
	     		fenPrincipale.setVisible(true);
				winArriver.this.dispose();			
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
		
	}
	
	private void ModeConsultation(){
		this.textFieldAdresse.setEditable(false);
		this.textFieldClientNo.setEditable(false);
		this.textFieldClientNom.setEditable(false);
		this.textFieldClientNoReserv.setEditable(false);
		this.textFieldDateDebut.setEditable(false);
		this.textFieldDateFin.setEditable(false);
		this.textFieldFax.setEditable(false);
		this.textFieldNomReserv.setEditable(false);
		this.textFieldNoReser.setEditable(false);
		this.textFieldNumeroChambre.setEditable(false);
		this.textFieldReservLe.setEditable(false);
		this.textFieldTelephone.setEditable(false);
		this.btnConsulter.setEnabled(false);
		this.btnEnregistrer.setEnabled(false);
		this.btnAnnuler.setEnabled(false);
	}
	
	private void Setup(){
		JPanel panelClient = new JPanel();
		panelClient.setBackground(SystemColor.windowBorder);
		panelClient.setBounds(176, 88, 469, 280);
		getContentPane().add(panelClient);
		panelClient.setLayout(null);
		
		textFieldClientNo = new JTextField();
		textFieldClientNo.setBounds(97, 40, 130, 26);
		panelClient.add(textFieldClientNo);
		textFieldClientNo.setColumns(10);
		
		JLabel lblClientNo = new JLabel("Client No:");
		lblClientNo.setBounds(30, 45, 63, 16);
		panelClient.add(lblClientNo);
		
		textFieldClientNom = new JTextField();
		textFieldClientNom.setBounds(296, 40, 138, 26);
		panelClient.add(textFieldClientNom);
		textFieldClientNom.setColumns(10);
		
		JLabel lblNom = new JLabel("Nom:");
		lblNom.setBounds(250, 45, 34, 16);
		panelClient.add(lblNom);
		
		JLabel lblAdresse = new JLabel("Adresse:");
		lblAdresse.setBounds(39, 104, 54, 16);
		panelClient.add(lblAdresse);
		
		textFieldAdresse = new JTextField();
		textFieldAdresse.setBounds(97, 99, 337, 26);
		panelClient.add(textFieldAdresse);
		textFieldAdresse.setColumns(10);
		
		JLabel lblTlphone = new JLabel("Téléphone:");
		lblTlphone.setBounds(24, 163, 69, 16);
		panelClient.add(lblTlphone);
		
		textFieldTelephone = new JTextField();
		textFieldTelephone.setBounds(97, 158, 130, 26);
		panelClient.add(textFieldTelephone);
		textFieldTelephone.setColumns(10);
		
		JLabel lblFax = new JLabel("Fax:");
		lblFax.setBounds(258, 163, 26, 16);
		panelClient.add(lblFax);
		
		textFieldFax = new JTextField();
		textFieldFax.setBounds(296, 158, 138, 26);
		panelClient.add(textFieldFax);
		textFieldFax.setColumns(10);
		
		textFieldNumeroChambre = new JTextField();
		textFieldNumeroChambre.setBounds(156, 218, 130, 26);
		panelClient.add(textFieldNumeroChambre);
		textFieldNumeroChambre.setColumns(10);
		
		JLabel lblNumroChambre = new JLabel("Numéro Chambre:");
		lblNumroChambre.setBounds(30, 223, 114, 16);
		panelClient.add(lblNumroChambre);
		
		btnPickList = new JButton("...");
		btnPickList.setBounds(6, 6, 44, 29);
		panelClient.add(btnPickList);
		
		JPanel panelReservation = new JPanel();
		panelReservation.setBackground(SystemColor.windowBorder);
		panelReservation.setBounds(674, 88, 440, 280);
		getContentPane().add(panelReservation);
		panelReservation.setLayout(null);
		
		JLabel lblNoReservation = new JLabel("No. Réservation:");
		lblNoReservation.setBounds(26, 43, 103, 16);
		panelReservation.add(lblNoReservation);
		
		textFieldNoReser = new JTextField();
		textFieldNoReser.setBounds(141, 38, 179, 26);
		panelReservation.add(textFieldNoReser);
		textFieldNoReser.setColumns(10);
		
		JLabel lblReservLe = new JLabel("Réservé le:");
		lblReservLe.setBounds(62, 103, 67, 16);
		panelReservation.add(lblReservLe);
		
		textFieldReservLe = new JTextField();
		textFieldReservLe.setBounds(141, 98, 179, 26);
		panelReservation.add(textFieldReservLe);
		textFieldReservLe.setColumns(10);
		
		JLabel lblDateDeDebut = new JLabel("Date de début:");
		lblDateDeDebut.setBounds(37, 163, 92, 16);
		panelReservation.add(lblDateDeDebut);
		
		textFieldDateDebut = new JTextField();
		textFieldDateDebut.setBounds(141, 158, 179, 26);
		panelReservation.add(textFieldDateDebut);
		textFieldDateDebut.setColumns(10);
		
		JLabel lblDateDeFin = new JLabel("Date de fin:");
		lblDateDeFin.setBounds(56, 198, 73, 16);
		panelReservation.add(lblDateDeFin);
		
		textFieldDateFin = new JTextField();
		textFieldDateFin.setBounds(141, 196, 179, 26);
		panelReservation.add(textFieldDateFin);
		textFieldDateFin.setColumns(10);
		
		JLabel lblClientNoReserv = new JLabel("Client no:");
		lblClientNoReserv.setBounds(26, 239, 61, 16);
		panelReservation.add(lblClientNoReserv);
		
		textFieldClientNoReserv = new JTextField();
		textFieldClientNoReserv.setBounds(99, 234, 78, 26);
		panelReservation.add(textFieldClientNoReserv);
		textFieldClientNoReserv.setColumns(10);
		
		JLabel lblNomReserv = new JLabel("Nom:");
		lblNomReserv.setBounds(189, 239, 34, 16);
		panelReservation.add(lblNomReserv);
		
		textFieldNomReserv = new JTextField();
		textFieldNomReserv.setBounds(235, 234, 145, 26);
		panelReservation.add(textFieldNomReserv);
		textFieldNomReserv.setColumns(10);
		
		JLabel lblInforClient = new JLabel("Information sur le client");
		lblInforClient.setBounds(176, 60, 152, 16);
		getContentPane().add(lblInforClient);
		
		JLabel lblInformationSurLa = new JLabel("Information sur la réservation");
		lblInformationSurLa.setBounds(674, 60, 192, 16);
		getContentPane().add(lblInformationSurLa);
		
		scrollPaneZoneN = new JScrollPane();
		scrollPaneZoneN.setBounds(176, 392, 938, 235);
		getContentPane().add(scrollPaneZoneN);
		
		btnPickList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrlArr.PkArriver(instance);
			}
		});
		
		btnPremier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlArr.Premier(instance);
			}
		});
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlArr.BonPrecedent(instance);
			}
		});
		btnDernier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlArr.Dernier(instance);
			}
		});
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlArr.BonSuivant(instance);
			}
		});
	}
	
	public JTextField getTxtClientNo(){
		return this.textFieldClientNo;
	}
	
	public JTextField getTxtClientNom(){
		return this.textFieldClientNom;
	}
	
	public JTextField getTxtAdresse(){
		return this.textFieldAdresse;
	}
	
	public JTextField getTxtTelephone(){
		return this.textFieldTelephone;
	}
	
	public JTextField getTxtFax(){
		return this.textFieldFax;
	}
	
	public JTextField getTxtNoCham(){
		return this.textFieldNumeroChambre;
	}
	
	public JTextField getTxtNoReser(){
		return this.textFieldNoReser;
	}
	
	public JTextField getTxtReservLe(){
		return this.textFieldReservLe;
	}
	
	public JTextField getTxtDateDebut(){
		return this.textFieldDateDebut;	
	}
	
	public JTextField getTxtDateFin(){
		return this.textFieldDateFin;
	}
	
	public JTextField getTxtClientNoReserv(){
		return this.textFieldClientNoReserv;
	}
	
	public JTextField getTxtNomReserv(){
		return this.textFieldNomReserv;
	}
	
	public static void setScrollPane(JTable UneTable)
	{
		scrollPaneZoneN.setViewportView(UneTable);
	}
	
	public static JScrollPane getScrollPane()
	{
		return scrollPaneZoneN;
	}
}

package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleurs.ctrlArrive;
import controleurs.ctrlDepart;

public class winDepart extends winHeritage {

	private JPanel contentPane;

	private JTextField textFieldClientNo;
	private JTextField textFieldClientNom;
	private JTextField textFieldAdresse;
	private JTextField textFieldTelephone;
	private JTextField textFieldFax;
	private JTextField textFieldTypeCarte;
	private JTextField textFieldNoReser;
	private JTextField textFieldReservLe;
	private JTextField textFieldDateDebut;
	private JTextField textFieldDateFin;
	private JTextField textFieldConfirmPar;
	private static JScrollPane scrollPaneZoneN;
	private winDepart instance;
	private ctrlDepart ctrlDepart = null;
	private JButton btnPickList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winHeritage frame = new winDepart();
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
	public winDepart() {
		instance = this;
		
		Setup();
		
		ctrlDepart = new ctrlDepart(instance);
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
		
		textFieldTypeCarte = new JTextField();
		textFieldTypeCarte.setBounds(127, 218, 170, 26);
		panelClient.add(textFieldTypeCarte);
		textFieldTypeCarte.setColumns(10);
		
		JLabel lblTypeCarte = new JLabel("Type de Carte:");
		lblTypeCarte.setBounds(30, 223, 114, 16);
		panelClient.add(lblTypeCarte);
		
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
		
		JLabel lblConfirmPar = new JLabel("Confirme par:");
		lblConfirmPar.setBounds(43, 239, 86, 16);
		panelReservation.add(lblConfirmPar);
		
		textFieldConfirmPar = new JTextField();
		textFieldConfirmPar.setBounds(141, 234, 179, 26);
		panelReservation.add(textFieldConfirmPar);
		textFieldConfirmPar.setColumns(10);
		
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
				//ctrlDepart.PkArriver(instance);
			}
		});
		
		btnPremier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlDepart.Premier(instance);
			}
		});
		btnPrecedent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlDepart.BonPrecedent(instance);
			}
		});
		btnDernier.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlDepart.Dernier(instance);
			}
		});
		btnSuivant.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ctrlDepart.BonSuivant(instance);
			}
		});
	}
}

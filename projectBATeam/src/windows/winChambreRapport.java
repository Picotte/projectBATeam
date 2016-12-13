package windows;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controleurs.ctrlChambre;
import controleurs.ctrlRapportChambre;
import utils.MouseClick;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JLabel;

public class winChambreRapport extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel pnPrinc;
	ctrlRapportChambre controller;
	private JTextField TBoxDate;
	private JButton btnAnnuler;
	private JButton btnGenerer;
	private JLabel lblDateDebut;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public winChambreRapport() {

		setTitle("Rapport");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnPrinc = new JPanel();
		pnPrinc.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnPrinc);
		pnPrinc.setLayout(null);
		
		
		createWidgets();
		createListener();
		controller = new ctrlRapportChambre(this);

			
	}
	
	void createWidgets(){
	
		TBoxDate = new JTextField();
		TBoxDate.setBounds(216, 86, 117, 29);
		pnPrinc.add(TBoxDate);
		TBoxDate.setColumns(10);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(216, 148, 117, 29);
		pnPrinc.add(btnAnnuler);
		
		btnGenerer = new JButton("Generer");
		btnGenerer.setBounds(44, 148, 117, 29);
		pnPrinc.add(btnGenerer);
		
		lblDateDebut = new JLabel("Date debut");
		lblDateDebut.setBounds(52, 81, 109, 39);
		pnPrinc.add(lblDateDebut);
	}
	
	void createListener(){
	
		btnGenerer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.generateRapport();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		btnAnnuler.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.annuler();
			}
		});
		
		TBoxDate.addMouseListener(new MouseClick(){
			public void mouseClicked(java.awt.event.MouseEvent arg0) {
				controller.pickDate(TBoxDate);
			}
		});
	}
	
	public JTextField TBoxDate(){return TBoxDate;}
}
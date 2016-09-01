package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class winConnexion extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNomUtilisateur;
	private JTextField textFieldMotDePasse;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					winConnexion frame = new winConnexion();
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
	public winConnexion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldNomUtilisateur = new JTextField();
		textFieldNomUtilisateur.setBounds(22, 45, 246, 33);
		contentPane.add(textFieldNomUtilisateur);
		textFieldNomUtilisateur.setColumns(10);
		
		JLabel lbNomUtilisateur = new JLabel("Nom d'utilisateur:");
		lbNomUtilisateur.setBounds(22, 17, 113, 16);
		contentPane.add(lbNomUtilisateur);
		
		JLabel lbMotDePasse = new JLabel("Mot de passe:");
		lbMotDePasse.setBounds(22, 90, 113, 16);
		contentPane.add(lbMotDePasse);
		
		textFieldMotDePasse = new JTextField();
		textFieldMotDePasse.setColumns(10);
		textFieldMotDePasse.setBounds(22, 118, 246, 33);
		contentPane.add(textFieldMotDePasse);
		
		JButton btnConnexion = new JButton("Connexion");
		btnConnexion.setBounds(22, 163, 117, 29);
		contentPane.add(btnConnexion);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(151, 163, 117, 29);
		contentPane.add(btnAnnuler);
	}
}

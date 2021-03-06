package controleurs;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.sound.sampled.DataLine;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.text.MaskFormatter;

import windows.winArriver;
import windows.winPickList;
import modeles.modConnexion;
import modeles.Model;
import modeles.ProcsE03;
import utils.Mode;
import utils.RapportLaucher;

public class ctrlArrive {
	private int position = 0;
	public Model modArrive = null;
	public Model modDe = null;
	private winArriver instance = null;
	private boolean valid[] = {false, false, false};
	private Mode mode;
	private int posPkCli = 0;
	private int posPkReser = 0;
	private JTable table = null;
	private Object insertValue[] = new Object[3];
	private Object updateValue;
	private int typeOfModif = 1;
	
	
	
	
	
	public ctrlArrive(winArriver instance){
		modArrive = ProcsE03.SELECT_ARRIVE();
		validInstance(instance);
		modeConsultation();
		affecteValeurs();
	}
	
	
	private void modeConsultation(){
		mode = Mode.CONSULTATION;
		position = 0;
		instance.getTextFieldAdresse().setEditable(false);
		instance.getTextFieldClientNo().setEditable(false);
		instance.getTextFieldClientNom().setEditable(false);
		instance.getTextFieldClientNoReserv().setEditable(false);
		instance.getTextFieldDateDebut().setEditable(false);
		instance.getTextFieldDateFin().setEditable(false);
		instance.getTextFieldFax().setEditable(false);
		instance.getTextFieldNomReserv().setEditable(false);
		instance.getTextFieldNoReser().setEditable(false);
		instance.getTextFieldNumeroChambre().setEditable(false);
		instance.getTextFieldReservLe().setEditable(false);
		instance.getTextFieldTelephone().setEditable(false);
		
		instance.getBtnConsulter().setEnabled(false);
		instance.getBtnEnregistrer().setEnabled(false);
		instance.getBtnAnnuler().setEnabled(false);
		instance.getBtnAjouter().setEnabled(true);
		instance.getBtnPickList().setEnabled(true);
		instance.getBtnPrecedent().setEnabled(true);
		instance.getBtnPremier().setEnabled(true);
		instance.getBtnDernier().setEnabled(true);
		instance.getBtnSuivant().setEnabled(true);
	}
	
	
	
	private void modeAjout(){
		mode = Mode.AJOUT;
		instance.getTextFieldAdresse().setText("");
		instance.getTextFieldClientNo().setText("");
		instance.getTextFieldClientNom().setText("");
		instance.getTextFieldClientNoReserv().setText("");
		instance.getTextFieldDateDebut().setText("");
		instance.getTextFieldDateFin().setText("");
		instance.getTextFieldFax().setText("");
		instance.getTextFieldNomReserv().setText("");
		instance.getTextFieldNoReser().setText("");
		instance.getTextFieldNumeroChambre().setText("");
		instance.getTextFieldReservLe().setText("");
		instance.getTextFieldTelephone().setText("");
		
		instance.getBtnAjouter().setEnabled(false);
		instance.getBtnPickList().setEnabled(false);
		instance.getBtnConsulter().setEnabled(false);
		instance.getBtnEnregistrer().setEnabled(false);
		instance.getBtnPrecedent().setEnabled(false);
		instance.getBtnPremier().setEnabled(false);
		instance.getBtnDernier().setEnabled(false);
		instance.getBtnSuivant().setEnabled(false);
		instance.getBtnAnnuler().setEnabled(true);
		this.valid[0] = false;
		this.valid[1] = false;
		this.valid[2] = false;
	
		
		instance.setScrollPane(null);
	}
	
	private void modeModification(){
		mode = Mode.MODIFICATION;
		
		instance.getBtnConsulter().setEnabled(false);
		instance.getBtnEnregistrer().setEnabled(false);
		instance.getBtnAnnuler().setEnabled(false);
		instance.getBtnAjouter().setEnabled(false);
		instance.getBtnPickList().setEnabled(true);
		instance.getBtnPrecedent().setEnabled(true);
		instance.getBtnPremier().setEnabled(true);
		instance.getBtnDernier().setEnabled(true);
		instance.getBtnSuivant().setEnabled(true);
		
		this.valid[0] = false;
		this.valid[1] = false;
		this.valid[2] = false;
	}
	
	public void affecteValeurs(){
		
		//SectionArriver	
		instance.getTextFieldClientNo().setText(modArrive.getValueAt(position, 2).toString());
		instance.getTextFieldClientNom().setText(modArrive.getValueAt(position, 3).toString());
		instance.getTextFieldNumeroChambre().setText(modArrive.getValueAt(position, 4).toString());
		instance.getTextFieldTelephone().setText(modArrive.getValueAt(position, 5).toString());
		instance.getTextFieldFax().setText(modArrive.getValueAt(position, 6).toString());
		instance.getTextFieldAdresse().setText(modArrive.getValueAt(position, 7).toString());
		instance.getTextFieldNoReser().setText(modArrive.getValueAt(position, 8).toString());
		instance.getTextFieldReservLe().setText(modArrive.getValueAt(position, 9).toString());
		instance.getTextFieldDateDebut().setText(modArrive.getValueAt(position, 10).toString());
		instance.getTextFieldDateFin().setText(modArrive.getValueAt(position, 11).toString());
		instance.getTextFieldClientNoReserv().setText(modArrive.getValueAt(position, 12).toString());
		instance.getTextFieldNomReserv().setText(modArrive.getValueAt(position, 13).toString());
		
		//Section N
		//System.out.println(modArrive.getValueAt(ligne, 7));
		modDe = ProcsE03.SELECT_DE(modArrive.getValueAt(position, 1).toString());
		table = new JTable(modDe);
		if(mode == Mode.MODIFICATION){
			table.addMouseListener(new MouseAdapter() {
		  		@Override
		  		public void mousePressed(MouseEvent e) {
		  			if(modDe.getValueAt(table.getSelectedRow(), 3).toString().equals("0")) {
			  			updateValue = modDe.getValueAt(table.getSelectedRow(), 0);
			  			
			  			instance.getTextFieldNumeroChambre().setText(modDe.getValueAt(table.getSelectedRow(), 0).toString());
			  			
		  				instance.getBtnEnregistrer().setEnabled(true);
		  				typeOfModif = 1;
		  			}
		  			else{
		  				System.out.println(modDe.getValueAt(table.getSelectedRow(), 3));
		  				JOptionPane.showMessageDialog(null, "Veuiller Selectionner une chambre non attribuee", "Désolé",JOptionPane.ERROR_MESSAGE);
		  			}
		  		}
		  	});
		}
		winArriver.setScrollPane(table);
		
	}
	
	
	public void annuler(winArriver instance){
		validInstance(instance);
		modeConsultation();
		affecteValeurs();
	}
	
	public void pkClient(winArriver instance){
		if(mode == Mode.AJOUT){
			if(valid[0]){
				validInstance(instance);
				posPkCli = winPickList.pickFromTable(ProcsE03.SELECT_PK_CLIENT(), "Liste des clients");
				Model modPKCli = ProcsE03.SELECT_PK_CLIENT();
				instance.getTextFieldClientNo().setText(modPKCli.getValueAt(posPkCli, 0).toString());
				instance.getTextFieldClientNom().setText(modPKCli.getValueAt(posPkCli, 1).toString());
				instance.getTextFieldAdresse().setText(modPKCli.getValueAt(posPkCli, 2).toString());
				instance.getTextFieldTelephone().setText(modPKCli.getValueAt(posPkCli, 3).toString());
				instance.getTextFieldFax().setText(modPKCli.getValueAt(posPkCli, 4).toString());
				insertValue[1] = modPKCli.getValueAt(posPkCli, 0);
				valid[1] = true;
			}
			else{
				JOptionPane.showMessageDialog(null, "Veuiller Selectionner une reservation avant", "Désolé",JOptionPane.ERROR_MESSAGE);
			}
		}
	}
	
	public void pkReservation(winArriver instance){
		validInstance(instance);
		if(mode == Mode.AJOUT){
			posPkReser = winPickList.pickFromTable(ProcsE03.SELECT_PK_RESERVATION(), "Liste des reservations");
			Model modPKReser = ProcsE03.SELECT_PK_RESERVATION();
			instance.getTextFieldNoReser().setText(modPKReser.getValueAt(posPkReser, 0).toString());
			instance.getTextFieldClientNoReserv().setText(modPKReser.getValueAt(posPkReser, 1).toString());
			instance.getTextFieldNomReserv().setText(modPKReser.getValueAt(posPkReser, 2).toString());
			instance.getTextFieldReservLe().setText(modPKReser.getValueAt(posPkReser, 3).toString());
			instance.getTextFieldDateDebut().setText(modPKReser.getValueAt(posPkReser, 4).toString());
			instance.getTextFieldDateFin().setText(modPKReser.getValueAt(posPkReser, 5).toString());
			insertValue[0] = modPKReser.getValueAt(posPkReser, 0);
			
			Model modDeAjout = ProcsE03.SELECT_DE_MODE_AJOUT(modPKReser.getValueAt(posPkReser, 0).toString());
			table = new JTable(modDeAjout);
			winArriver.setScrollPane(table);
			
			table.addMouseListener(new MouseAdapter() {
		  		@Override
		  		public void mousePressed(MouseEvent e) {
		  			
		  			if(valid[1]){
		  				instance.getTextFieldNumeroChambre().setText(modDeAjout.getValueAt(table.getSelectedRow(),0).toString());
		  				insertValue[2] = modDeAjout.getValueAt(table.getSelectedRow(),0);
		  				valid[2] = true;
		  				if(valid[0] && valid[1] && valid[2])
		  					instance.getBtnEnregistrer().setEnabled(true);
		  			}
		  			else{
		  				JOptionPane.showMessageDialog(null, "Veuiller Selectionner un Client avant", "Désolé",JOptionPane.ERROR_MESSAGE);
		  			}
		  		}
		  	});
			
			valid[0] = true;
		}
		
	}
	
	
	
	public void enregistrer(winArriver instance){
		validInstance(instance);
		if(mode == Mode.AJOUT){
			if(ProcsE03.INSERT_ARRIVE(insertValue[0], insertValue[1], insertValue[2])){
				JOptionPane.showMessageDialog(null, "INSERT DONE", "Accepter",JOptionPane.INFORMATION_MESSAGE);
				modeConsultation();
				modArrive = ProcsE03.SELECT_ARRIVE();
				affecteValeurs();
				valid[0] = false;
				valid[1] = false;
				valid[2] = false;
			}	
		}
		else if(mode == Mode.MODIFICATION){
			if(ProcsE03.UPDATE_ARRIVE(modArrive.getValueAt(position, 0), modArrive.getValueAt(position, 1), modArrive.getValueAt(position, 4), modArrive.getValueAt(position, 1), updateValue, typeOfModif)){
				JOptionPane.showMessageDialog(null, "UPDATE DONE", "Accepter",JOptionPane.INFORMATION_MESSAGE);
				modeConsultation();
				modArrive = ProcsE03.SELECT_ARRIVE();
				affecteValeurs();
				valid[0] = false;
				valid[1] = false;
				valid[2] = false;	
			}
		}
	}
	
	private void validInstance(winArriver instance){
		if(this.instance == null)
			this.instance = instance;
	}
	
	public void ajouter(winArriver instance){
		validInstance(instance);
		modeAjout();
	}
	
	public void pkChambre(winArriver instance){
		validInstance(instance);
		if(mode == Mode.MODIFICATION){
			try{
				updateValue = ProcsE03.SELECT_PK_CHAMBRE().getValueAt(winPickList.pickFromTable(ProcsE03.SELECT_PK_CHAMBRE(), "Chambre disponible"), 0).toString();
				instance.getTextFieldNumeroChambre().setText(updateValue.toString());
				typeOfModif = 2;
				instance.getBtnEnregistrer().setEnabled(true);
			}catch(IndexOutOfBoundsException e){
				
			}
		}
			
		
	}
	
	public void supprimer(winArriver instance){
		validInstance(instance);
		String a = modArrive.getValueAt(position, 0).toString();
		ProcsE03.DELETE_ARRIVER(modArrive.getValueAt(position, 0), modArrive.getValueAt(position, 1), modArrive.getValueAt(position, 2));
		modArrive = ProcsE03.SELECT_ARRIVE();
		position = 0;
		affecteValeurs();
		if(a.equals(modArrive.getValueAt(position, 0).toString())){
			JOptionPane.showMessageDialog(null, "Impossible de supprimer cette entrer", "Refuser",JOptionPane.ERROR_MESSAGE);
		}
		else{
			JOptionPane.showMessageDialog(null, "Entrer supprimer", "Accepter",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void modifier(winArriver instance){
		validInstance(instance);
		modeModification();
		modArrive = ProcsE03.SELECT_ARRIVE_MODIF();
		position = 0;
		try{
			affecteValeurs();
		}catch(IndexOutOfBoundsException e){
			modeConsultation();
			modArrive = ProcsE03.SELECT_ARRIVE();
			affecteValeurs();
			position = 0;
			valid[0] = false;
			valid[1] = false;
			valid[2] = false;
		}
	}
	
	public void pkArriver(winArriver instance){
		validInstance(instance);
		if(mode == Mode.CONSULTATION){
			position = winPickList.pickFromTable(ProcsE03.SELECT_PK_ARRIVE(),"listes des arrive");
			affecteValeurs();	
		}
		else if(mode == Mode.MODIFICATION){
			position = winPickList.pickFromTable(ProcsE03.SELECT_ARRIVE_MODIF(),"listes des arrive");
			affecteValeurs();
		}
	}
	
	
	
	public void rapport(winArriver instance){
		RapportLaucher.apercu("rapportArrive.jrxml",new HashMap<String,Object>());
	}
	
	public void premier(winArriver instance) {
		validInstance(instance);
		position = 0;
	    affecteValeurs();		
	}
	
	public void precedent(winArriver instance) {
		validInstance(instance);
		if (position> 0)
			position--;
		else position = modArrive.getRowCount() - 1;

		affecteValeurs();	
	}
	public void dernier(winArriver instance) {
		validInstance(instance);
		position = modArrive.getRowCount() - 1;
	    affecteValeurs();		
	}
	public void suivant(winArriver instance) {
		validInstance(instance);
		if (position < modArrive.getRowCount() - 1)
			 position++;
		else position = 0;
		
		affecteValeurs();		
	}
}

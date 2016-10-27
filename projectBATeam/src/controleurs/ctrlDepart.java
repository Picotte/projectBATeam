package controleurs;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JTable;

import modeles.Model;
import modeles.ProcsE03;
import windows.winDepart;
import windows.winPickList;

public class ctrlDepart {
	private int position = 0;
	public Model modDepart = null;
	public Model modListeDepart = null;
	DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	
	public ctrlDepart(winDepart instance){
		position = 0;
		modDepart = ProcsE03.SELECT_DEPART();
		
		AffecteValeurs(instance);
	}
	
	public void AffecteValeurs(winDepart instance){
		instance.getTextFieldClientNo().setText(modDepart.getValueAt(position, 1).toString());
		instance.getTextFieldClientNom().setText(modDepart.getValueAt(position, 2).toString());
		instance.getTextFieldAdresse().setText(modDepart.getValueAt(position, 3).toString());
		instance.getTextFieldTelephone().setText(modDepart.getValueAt(position, 4).toString());
		instance.getTextFieldFax().setText(modDepart.getValueAt(position,5).toString());
		instance.getTextFieldTypeCarte().setText(modDepart.getValueAt(position, 6).toString());
		instance.getTextFieldNoReser().setText(modDepart.getValueAt(position, 7).toString());
		instance.getTextFieldReservLe().setText(modDepart.getValueAt(position, 8).toString());
		instance.getTextFieldDateDebut().setText(modDepart.getValueAt(position, 9).toString());
		instance.getTextFieldDateFin().setText(modDepart.getValueAt(position, 10).toString());
		instance.getTextFieldConfirmPar().setText(modDepart.getValueAt(position, 11).toString());
		
		
		modListeDepart = ProcsE03.SELECT_LISTEDEPART(modDepart.getValueAt(position, 7).toString());
		winDepart.setScrollPane(new JTable(modListeDepart));
	}
	
	
	
	
	public void Premier(winDepart instance) {
		 position = 0;
	     AffecteValeurs(instance);		
	}
	public void BonPrecedent(winDepart instance) {
		if (position> 0)
			position--;
		else position = modDepart.getRowCount()-1;
		AffecteValeurs(instance);	
	}
	public void Dernier(winDepart instance) {
		position = modDepart.getRowCount()-1;
	     AffecteValeurs(instance);		
	}
	public void BonSuivant(winDepart instance) {
		if (position< modDepart.getRowCount()-1)
			 position++;
		else position = 0;
		AffecteValeurs(instance);		
	}
}

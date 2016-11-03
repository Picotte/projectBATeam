package controleurs;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import modeles.modDe;
import modeles.modReservation;
import windows.winReservation;
import windows.winPickList;
import windows.winPrincipale;


public class ctrlReservation {

	public modReservation modeleReservation = null;
	private int position = 0;
	public modDe modeleDe = null;
	public ctrlReservation(winReservation instance) {
		
	modeleReservation = new modReservation();	
	AffecteValeurs(instance,position);

	}
	private void AffecteValeurs(winReservation instance, int ligne) {
			
		 modeleReservation.setCourant((int) modeleReservation.getValueAt(ligne,0));
	    //Affichage des informations de la chambre
		instance.getTxtNoClient().setText(modeleReservation.getValueAt(ligne, 0).toString());
		instance.getTxtNom().setText(modeleReservation.getValueAt(ligne, 1).toString());   
		instance.getTxtAdresse().setText(modeleReservation.getValueAt(ligne, 2).toString());
		instance.getTxtTelephone().setText(modeleReservation.getValueAt(ligne, 3).toString());
		instance.getTxtFax().setText(modeleReservation.getValueAt(ligne, 4).toString());
		instance.getTxtTypeCarte().setText(modeleReservation.getValueAt(ligne, 5).toString());
		instance.getTxtExpiration().setText(modeleReservation.getValueAt(ligne, 6).toString());
		instance.getTxtSoldeDu().setText(modeleReservation.getValueAt(ligne, 7).toString());
		instance.getTxtNoReser().setText(modeleReservation.getValueAt(ligne, 8).toString());
		instance.getTxtDateReser().setText(modeleReservation.getValueAt(ligne, 9).toString());
		instance.getTxtDateDebut().setText(modeleReservation.getValueAt(ligne, 10).toString());
		instance.getTxtDateFin().setText(modeleReservation.getValueAt(ligne, 11).toString());

		
		//Affichage des commodité de la chambre
		
		modeleDe = new modDe((int)modeleReservation.getValueAt(ligne, 8));
		winReservation.setjScrollPane(new JTable(modeleDe));
	}
	
	public void Premier(winReservation instance) {
		 position = 0;
	     AffecteValeurs(instance,position);		
	}
	public void BonPrecedent(winReservation instance) {
		if (position > 0)
			position--;
		else position = modeleReservation.getLesEnreg().size()-1;
		modeleReservation.setCourant((int)modeleReservation.getValueAt(position, 0));
		AffecteValeurs(instance,position);	
	}
	public void Dernier(winReservation instance) {
		position = modeleReservation.getLesEnreg().size()-1;
	     AffecteValeurs(instance,position);		
	}
	public void BonSuivant(winReservation instance) {
		if (position< modeleReservation.getLesEnreg().size()-1)
			 position++;
		else position = 0;
		modeleReservation.setCourant((int)modeleReservation.getValueAt(position, 0));
		AffecteValeurs(instance,position);		
	}
	public void ListeClient (winReservation instance){   
	    position = winPickList.pickFromTable(new modReservation(),"listes des client");
		AffecteValeurs(instance, position);	
	}


}

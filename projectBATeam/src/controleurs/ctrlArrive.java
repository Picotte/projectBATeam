package controleurs;

import javax.swing.JTable;
import windows.winArriver;
import windows.winChambre;
import modeles.modArriver;
import modeles.modDe;

public class ctrlArrive {
	private int position = 0;
	public modArriver modArrive = null;
	public modDe modDe_ = null;
	
	public ctrlArrive(winArriver instance){
		
		modArrive = new modArriver();
		
		AffecteValeurs(instance, position);
	}
	
	public void AffecteValeurs(winArriver instance, int ligne){
		
		modArrive.setCurrent((int) modArrive.getValueAt(ligne, 13));
		//SectionArriver
		instance.getTxtClientNo().setText(modArrive.getValueAt(ligne, 0).toString());
		instance.getTxtClientNom().setText(modArrive.getValueAt(ligne, 1).toString());
		instance.getTxtAdresse().setText(modArrive.getValueAt(ligne, 2).toString());
		instance.getTxtTelephone().setText(modArrive.getValueAt(ligne, 3).toString());
		instance.getTxtFax().setText(modArrive.getValueAt(ligne, 4).toString());
		instance.getTxtNoCham().setText(modArrive.getValueAt(ligne, 5).toString());
		
		//SectionReservation
		instance.getTxtNoReser().setText(modArrive.getValueAt(ligne, 7).toString());
		instance.getTxtReservLe().setText(modArrive.getValueAt(ligne, 8).toString());
		instance.getTxtDateDebut().setText(modArrive.getValueAt(ligne, 9).toString());
		instance.getTxtDateFin().setText(modArrive.getValueAt(ligne, 10).toString());
		instance.getTxtClientNoReserv().setText(modArrive.getValueAt(ligne, 11).toString());
		instance.getTxtNomReserv().setText(modArrive.getValueAt(ligne, 12).toString());
		
		//Section N
		modDe_ = new modDe((int)modArrive.getValueAt(ligne, 7));
		instance.setScrollPane(new JTable(modDe_)); 
	}
	
	public void Premier(winArriver instance) {
		 position = 0;
	     AffecteValeurs(instance,position);		
	}
	public void BonPrecedent(winArriver instance) {
		if (position> 0)
			position--;
		else position= 0;
		modArrive.setCurrent((int)modArrive.getValueAt(position, 13));
		AffecteValeurs(instance,position);	
	}
	public void Dernier(winArriver instance) {
		position = modArrive.getLesEnreg().size()-1;
	     AffecteValeurs(instance,position);		
	}
	public void BonSuivant(winArriver instance) {
		if (position< modArrive.getLesEnreg().size())
			 position++;
		else position = modArrive.getLesEnreg().size()-1;
		modArrive.setCurrent((int)modArrive.getValueAt(position, 0));
		AffecteValeurs(instance,position);		
	}
}

package controleurs;

import javax.swing.JTable;
import windows.winDepart;
import windows.winPickList;

public class ctrlDepart {
	private int position = 0;
	//public modDepart modDepart_ = null;
	//public modReservationDepart modReservationDepart_ = null;
	
	public ctrlDepart(winDepart instance){
		
		//modReservationDepart_ = new modReservationDepart();
		
		AffecteValeurs(instance, position);
	}
	
	public void AffecteValeurs(winDepart instance, int ligne){
		
		
		
	}
	
	
	public void Premier(winDepart instance) {
		 position = 0;
	     AffecteValeurs(instance,position);		
	}
	public void BonPrecedent(winDepart instance) {
		//if (position> 0)
		//	position--;
		//else position = modDepart.getLesEnreg().size()-1;
		//modArrive.setCurrent((int)modDepart.getValueAt(position, 13));
		AffecteValeurs(instance,position);	
	}
	public void Dernier(winDepart instance) {
		//position = modArrive.getLesEnreg().size()-1;
	     AffecteValeurs(instance,position);		
	}
	public void BonSuivant(winDepart instance) {
		//if (position< modArrive.getLesEnreg().size()-1)
		//	 position++;
		//else position = 0;
		//modArrive.setCurrent((int)modArrive.getValueAt(position, 13));
		AffecteValeurs(instance,position);		
	}
}

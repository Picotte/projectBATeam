package controleurs;

import javax.swing.JOptionPane;

import modeles.modConnexion;
import windows.winArriver;
import windows.winChambre;
import windows.winDepart;
import windows.winPrincipale;


public class ctrlPrincipale {

	private winPrincipale fenetre;
	public ctrlPrincipale(winPrincipale fenetre) {
		
   this.fenetre = fenetre;
	}
	
	public  void ActionBtn(int bouton)
	{
		switch (bouton)
		   { case 1 :  	winChambre fenChambre = new winChambre();
		   			   	fenChambre.setVisible(true);
		   			   	fenetre.dispose();
			           	break;
		     case 2 : 	JOptionPane.showMessageDialog(null, "La gestion des clients est en construction","En cours de développement...",JOptionPane.PLAIN_MESSAGE);
		     		  	break;
		     case 3 : 	//winReservation fenReservation = new winReservation();
		     		  	//fenReservation.setVisible(true);
		     		  	fenetre.dispose();
		     		  	break;
		     case 4 :	winArriver fenArriver = new winArriver();
		                fenArriver.setVisible(true);
			          	fenetre.dispose();
			          	break;
		     case 5 : 	winDepart fenDepart = new winDepart();
             			fenDepart.setVisible(true);
             			fenetre.dispose();
    		  		  	break;
		     case 6 : 	modConnexion.getInstance().deconnexion();
		     		  	fenetre.dispose();
		     		  	break; 
		     
		   }
		
	}
}

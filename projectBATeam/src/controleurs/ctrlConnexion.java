package controleurs;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

//import windows.WinBon;
//import windows.WinListBons;
import modeles.modConnexion;
import windows.winPrincipale;


public class ctrlConnexion {
	static ResultSet jeuEnreg = null;
	
	public static void connexion(JDialog fenetre,String nomUsager, String mdp) 
	 {  
		
	    try {
	       
	  	    modConnexion.getInstance().connexion("EQU03PRG03","j11254");   	
	       	
	       	//testConnexion();
	       	
	       	fenetre.dispose();
	        
	      winPrincipale fendebut = new winPrincipale();
	    //	WinListBons fendebut = new WinListBons();
	    // 	WinBon fendebut = new WinBon();
	     	fendebut.setVisible(true);
	      
	          	} 
	    catch (Exception e) 
	    	{
	    		e.printStackTrace();
	    	//System.out.println(e.getMessage());
	     	JOptionPane.showMessageDialog(null, "Information inexistante", "Désolé", JOptionPane.WARNING_MESSAGE);
	    	}
	    
	  }
	

private static void testConnexion() throws SQLException
 { 
	
	//Appel de procédure stockée avec un paramètre en lecture
	
/*	String sql = "{call test(?)}";
	CallableStatement call = ModConnexion.getInstance().getLaConnectionStatique().prepareCall(sql); 
	//passage de la chaîne "ioio" comme valeur du premier paramètre 
	call.setString(1,"ioio"); 
	call.execute();*/
	
/*	
 * 
 *  Exécution d'une requête simple*/
  
    String vCode = "";
	String vNom = "";
	
	PreparedStatement prepare = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("Select viewArriver.NoArrive from EQU03prg01.viewArriver");
  	jeuEnreg = prepare.executeQuery();
	
  	while (jeuEnreg.next())
		{
			vCode = jeuEnreg.getString(1);
			//vNom = jeuEnreg.getString(2);
			System.out.println(" " +vCode);
		}
	
}

} 



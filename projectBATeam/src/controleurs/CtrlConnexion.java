package controleurs;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import windows.WinCnx;
import windows.WinPrincipal;
import modeles.ModConnexion;

@SuppressWarnings("unused")
public class CtrlConnexion {
	static ResultSet jeuEnreg = null;
	
	public static void connexion(JDialog fenetre,String nomUsager, String mdp) 
	 {  
		
	    try {
	       
	  	    ModConnexion.getInstance().connexion(nomUsager,mdp);   	
	       	
	       	testConnexion();
	       	
	       	fenetre.dispose();
	       	WinPrincipal fendebut = new WinPrincipal();
	       	fendebut.setVisible(true);
	      
	          	} 
	    catch (Exception e) 
	    	{
	    		//e.printStackTrace();
	     	JOptionPane.showMessageDialog(null, "En construction", "Désolé", JOptionPane.WARNING_MESSAGE);
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
 *  Exécution d'une requête simple
   */
    String vCode = "";
	String vNom = "";
	
	PreparedStatement prepare = ModConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT * FROM FJEAN.DM_ACH");
  	jeuEnreg = prepare.executeQuery();
	
  	while (jeuEnreg.next())
		{
			vCode = jeuEnreg.getString(1);
			vNom = jeuEnreg.getString(2);
			System.out.println(" " +vCode + "  " + vNom);
		}
	
}

}



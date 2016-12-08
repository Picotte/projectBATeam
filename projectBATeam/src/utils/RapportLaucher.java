package utils;
import utils.PathRapportHelper;

import java.io.File;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import modeles.modConnexion;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;


public final class RapportLaucher {
	private static Connection laConnexion = modConnexion.getInstance().getLaConnectionStatique();
	
	private static JasperDesign design = null;
	private static JasperReport report = null;
	private static JasperPrint print = null;
	private static String chemin = PathRapportHelper.getRepertoireCourant()
									+ PathRapportHelper.getSeparateur()
									+ "src" + PathRapportHelper.getSeparateur()
									+ "rapport" + PathRapportHelper.getSeparateur();
	
	public static void chargeEtcompile(String rapport)
	{ 		
		try
		{   
		  design = JRXmlLoader.load(chemin	+ rapport);
		  report = JasperCompileManager.compileReport(design);
		
		  HashMap<String, Object> mesParametres = new HashMap<String,Object>();
		  //mesParametres.put("Date1", convertirChaineEnDateJava("2008-10-01"));
		  //mesParametres.put("Date2", convertirChaineEnDateJava("2008-10-31"));
	
		 //Affichage du rapport
		  print = JasperFillManager.fillReport(report, mesParametres, laConnexion);
		  
		  //Pour exporter le rapport en pdf
		  JFileChooser save = new JFileChooser();
		  save.setSelectedFile(new File("Fichier.pdf"));
		  int retour = save.showSaveDialog(save);
		  if(retour == JFileChooser.APPROVE_OPTION)
		  {
			  try
			  {
				  JasperExportManager.exportReportToPdfFile(print, save.getSelectedFile().getAbsolutePath());
			  }
			  catch(Exception e)
			  {
				  JOptionPane.showMessageDialog(null, "Exportation impossible","Erreur",JOptionPane.ERROR_MESSAGE);
			  }
	  
		  }
	
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "La compilation du rapport a échoué : \n"
			+ e.getMessage()+JOptionPane.ERROR_MESSAGE);
		}
}
		
	
	public static void apercu(String rapport)
	{
		chargeEtcompile(rapport);
		try
		{
			JasperViewer.viewReport(print,false);
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "Erreur lors de l'aperçu \n"+e.getMessage()+JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}



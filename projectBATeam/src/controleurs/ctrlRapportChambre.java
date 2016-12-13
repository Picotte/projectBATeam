package controleurs;

//TODO 
//CREATE TABLE WITH DATE
//CREATE TABLE WITH ALL CHAMBRE DISPONIBLE ORDER BY TYPECHAM ET NOCHAM WITH 7 BOOLEAN 
//PARCOURIR TOUT LES DE ET REGARDER TOUT LES RESERVATION ASSOCIER A CETTE CHAMBRE SAVOIR SI YA UNE RESERVATION POUR CHACUNE DES 7 DATES

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modeles.modConnexion;
import modeles.Model;
import utils.PathRapportHelper;
import utils.Query;
import windows.winChambreRapport;
import windows.winPickDate;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
public class ctrlRapportChambre {
	

	private static Connection laConnexion = modConnexion.getInstance().getLaConnectionStatique();
	
	private static JasperDesign design = null;
	private static JasperReport report = null;
	private static JasperPrint print = null;
	private static String chemin = PathRapportHelper.getRepertoireCourant()
									+ PathRapportHelper.getSeparateur()
									+  PathRapportHelper.getSeparateur()
									+ "src/rapport" + PathRapportHelper.getSeparateur();
	
	winChambreRapport window;
	Model chambres;
	Model de;
	Model reser;
	Model chambreRapport;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public ctrlRapportChambre(winChambreRapport window){
		this.window = window;
	}
	public void generateRapport() throws ParseException{
		// do the shit
		//create dateRapport
	
		if(!window.TBoxDate().getText().equals("")){
			//init les tables
			initDateRapport();
			initTableRapport();
			Date choosenDay = dateFormat.parse(window.TBoxDate().getText());
			//construit le rapport
			//pour chacune des chambre de tablerapport
			for(int i = 0 ; i < chambres.getRowCount();i++){
				Query selectDe = new Query("select * from de where ? = de.nocham");
				de = selectDe.execute(chambres.getValueAt(i, 0));


				//pour chacun des DE de cette chambre
				for(int j = 0 ; j < de.getRowCount();j++){
					Query selectReser = new Query("select * from reservation where ? = reservation.IDRESER");
					reser = selectReser.execute(de.getValueAt(j, 0));
					
					//pour chacune des date
					Date min, max;
					min = dateFormat.parse((String)reser.getValueAt(0, 3));
					max = dateFormat.parse((String)reser.getValueAt(0, 4));

					for(int k = 0 ; k < 7 ; k++){
						//on regarde si la date est between les date de la reservation 
						Date d = new Date(choosenDay.getTime()+(k*24*60*60*1000));
						if((d.after(min) && d.before(max)) || d.compareTo(min) == 0 || d.compareTo(max) == 0 ){
							//on update pour rendre non dispo
							if(chambres.getValueAt(i, 0).equals("150")){
								System.out.println("150 : dispo" + (k+1) + " idreser : " +reser.getValueAt(0, 0));
								System.out.println("dateDebut : " + reser.getValueAt(0, 3) + " dateFin : " +reser.getValueAt(0, 4) + " datechoisi : " + window.TBoxDate().getText());
								System.out.println("compareDateDebut : " + min + " compareDateFin : " + max);
							}
							try {    
								PreparedStatement query = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("UPDATE tablerapport SET tablerapport.dispo"+ (k+1) +" = 0 WHERE tablerapport.nocham = ?");
								query.setObject(1,chambres.getValueAt(i, 0));
								query.executeQuery();
								
								} catch (SQLException e) {
									JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
									System.out.println("problem avec le update de la tableRapport");
								}
						}
					}
				}
					
			}
				
			//generer rapport
			
			
			chargeEtcompile("rapportChambre.jrxml");
			try
			{
				JasperViewer.viewReport(print,false);
			}
			catch(Exception e)
			{
				JOptionPane.showMessageDialog(null, "Erreur lors de l'aperçu \n"+e.getMessage()+JOptionPane.ERROR_MESSAGE);
			}
			
			//on drop les tables
			try {    
				PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("delete from dateRapport");
				state.executeQuery();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
					System.out.println("problem avec drop table dateRapport");
				}
			try {    
				PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("delete from tableRapport");
				state.executeQuery();
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
					System.out.println("problem avec drop table tableRapport");
				}
		}
		else{
			JOptionPane.showMessageDialog(window,"veuillez choisir une date d'abord");
		}

	}
	
	//private static Query SELECT_DEPART = new Query("select * from depart where   = ? and to_date(?,'yyyy-mm-dd') = to_date(depart.datedepart,'yy-mm-dd')");
	public void annuler(){
		window.dispose();
	}
	public void pickDate(JTextField TBox){
		winPickDate.pickDate(window,TBox);
	}
	
	private void initDateRapport(){
		
/*		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("create table dateRapport(date1 date not null,date2 date not null,date3 date not null,date4 date not null,date5 date not null,date6 date not null,date7 date not null)");
			state.executeQuery();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
				System.out.println("problem avec la query creation dateRapport");
			}
		*/
			//insert into dateRapport with the first Date
			try {    
				CallableStatement  query = modConnexion.getInstance().getLaConnectionStatique().prepareCall("{call CreateRapportTable(?)}");
					query.setObject(1,window.TBoxDate().getText());
				query.executeUpdate();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
				System.out.println("problem insertion dateRapport ");
			}
		
	}
	
	private void initTableRapport(){
/*
 * 		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("create table tableRapport(noCham varchar2(3) not null,codTypCha varchar2(2) not null,dispo1 smallint not null,dispo2 smallint not null,dispo3 smallint not null,dispo4 smallint not null,dispo5 smallint not null,dispo6 smallint not null,dispo7 smallint not null)");
			state.executeQuery();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
				System.out.println("problem avec la query creation tableRapport");
			}
		*/
			//aller chercher toute les chambre en etat
		Query selectChambre = new Query("select * from chambre where chambre.etat = 1");
		chambres = selectChambre.execute();
		
		//pour chacune des chambre on fait un insert dans tableRapport avec son numero et son type ainsi que 7 boolean a true
		for(int i = 0 ; i < chambres.getRowCount();i++){
			try {    
				PreparedStatement query = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("insert into tableRapport values(?,?,1,1,1,1,1,1,1)");
				query.setObject(1,chambres.getValueAt(i, 0));
				query.setObject(2,chambres.getValueAt(i, 4));
				query.executeQuery();
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
					System.out.println("problem avec le insert de la tableRapport");
				}
		}
		
	}
	
	public static void chargeEtcompile(String rapport)
	{ 		
		try
		{   
		  design = JRXmlLoader.load(chemin	+ rapport);
		  report = JasperCompileManager.compileReport(design);
		
		  HashMap<String, Object> mesParametres = new HashMap<String,Object>();
		//  mesParametres.put("Date1", convertirChaineEnDateJava("2008-10-01"));
		//  mesParametres.put("Date2", convertirChaineEnDateJava("2008-10-31"));
	
		 //Affichage du rapport
		  print= JasperFillManager.fillReport(report, mesParametres, laConnexion);
		  
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
}
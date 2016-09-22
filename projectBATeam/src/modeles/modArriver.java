package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class modArriver extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	
	private int noArr;
	private int clientNoArriver;
	private String nomArriver;
	private String adresseArriver;
	private String telephoneArriver;
	private String faxArriver;
	private int noChamArriver;
	private int noReserArriver;
	
	private int IdReser;
	private Date dateReserver;
	private Date dateDebut;
	private Date dateFin;
	private int IdCliReser;
	private String NomReser;
	
	
	private int current = 0;
	
	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}


	private ArrayList<modArriver> lesArrivees = new ArrayList<modArriver>();
	public final  String[] lesTitres = {" "};
	
	public modArriver(){
		lireEnreg();
	}
	
	public modArriver(int noArrive, int clientNoArriver, String nomArriver, String adresseArriver, String telephoneArriver, String faxArriver, 
					  int noChamArriver, int noReserArriver, int IdReser, Date dateReserver, Date dateDebut, Date dateFin, int IdCliReser, 
					  String NomReser){
		this.noArr = noArrive;
		
		this.clientNoArriver = clientNoArriver;
		this.nomArriver = nomArriver;
		this.adresseArriver = adresseArriver;
		this.telephoneArriver = telephoneArriver;
		this.faxArriver = faxArriver;
		this.noChamArriver = noChamArriver;
		this.noReserArriver = noReserArriver;
		
		this.IdReser = IdReser;
		this.dateReserver = dateReserver;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.IdCliReser = IdCliReser;
		this.NomReser = NomReser;
	}
	
	public void lireEnreg() {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement
					("Select viewArriver.NoArrive , viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nom, viewArriver.NoCham, "
							+ "viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse,  "
							+ "viewArriverReservation.IdReser, viewArriverReservation.dateReser, viewArriverReservation.dateDebut"
							+ ", viewArriverReservation.dateFin, viewArriverReservation.IdCli, viewArriverReservation.Nom"
							+ "  from viewArriver, viewArriverReservation where viewArriverReservation.IdReser = viewArriver.IdReser"); //requete
			ResultSet rs = state.executeQuery();
			
			while (rs.next()) {
				
				lesArrivees.add(new modArriver(rs.getInt("viewArriver.NoArrive"),
											   rs.getInt("viewArriver.IdCli"), 
											   rs.getString("viewArriver.Nom"), 
											   rs.getString("viewArriver.Adresse"), 
											   rs.getString("viewArriver.Telephone"), 
											   rs.getString("viewArriver.Fax"), 
											   rs.getInt("viewArriver.NoCham"), 
											   rs.getInt("viewArriver.IdReser"),
											   rs.getInt("viewArriverReservation.IdReser"), 
											   rs.getDate("viewArriverReservation.dateReser"),
											   rs.getDate("viewArriverReservation.dateDebut"),
											   rs.getDate("viewArriverReservation.dateFin"),
											   rs.getInt("viewArriverReservation.IdCli"),
											   rs.getString("viewArriverReservation.Nom")
											   ) );
				this.setCurrent(rs.getInt("viewArriver.NoArrive"));
			} 
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans Arriver.java",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public Object getValueAt(int rowIndex, int columnIndex) {
		modArriver arriver = (modArriver)lesArrivees.get(rowIndex);
		if(columnIndex == 0) return arriver.clientNoArriver;
		if(columnIndex == 1) return arriver.nomArriver;
		if(columnIndex == 2) return arriver.adresseArriver;
		if(columnIndex == 3) return arriver.telephoneArriver;
		if(columnIndex == 4) return arriver.faxArriver;
		if(columnIndex == 5) return arriver.noChamArriver;
		if(columnIndex == 6) return arriver.noReserArriver;
		if(columnIndex == 7) return arriver.IdReser;
		if(columnIndex == 8) return arriver.dateReserver;
		if(columnIndex == 9) return arriver.dateDebut;
		if(columnIndex == 10) return arriver.dateFin;
		if(columnIndex == 11) return arriver.IdCliReser;
		if(columnIndex == 12) return arriver.NomReser;
		else return arriver.noArr;
	}
	
	@Override
	public int getRowCount() {
		return lesArrivees.size();
	}

	
	@Override
	public int getColumnCount() {	
		return lesTitres.length;
		}
	
	public ArrayList<modArriver> getLesEnreg() {
		return lesArrivees;
	}

}

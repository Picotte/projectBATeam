package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class modReservation extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private int noClient;
	private String nom;
	private String adresse;
	private String telephone;
	private String fax;
	private String typeCarte;
	private Date expiration;
	private float soldeDu;
	private int noReser;
	private Date dateReser;
	private Date dateDebut;
	private Date dateFin;

	private int courant = 0;

	private ArrayList<modReservation> lesReservations = new ArrayList<modReservation>();
	public final  String[] lesTitres = {"noClient", "nom","adresse","telephone","fax","typeCarte","expiration","soldeDu","noReser", "dateReser", "dateDebut", "dateFin"};
	
	/*
	 * Constructeur 1
	 */
	public modReservation() {
		lireEnreg();
	}
	/*
	 * Constructeur 2 - sert surtout pour peupler la liste des bons pour la consultation
	 */
	public modReservation(int noClient,String nom,String adresse,String telephone,String fax,String typeCarte,Date expiration,float soldeDu,int noReser, Date dateReser, Date dateDebut, Date dateFin) {
		this.noClient = noClient;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.fax = fax;
		this.typeCarte = typeCarte;
		this.expiration = expiration;
		this.soldeDu = soldeDu;
		this.noReser = noReser;	
		this.dateReser = dateReser;	
		this.dateDebut = dateDebut;	
		this.dateFin = dateFin;	
	}
	@Override
	public int getRowCount() {
		return lesReservations.size();
	}
	@Override
	public int getColumnCount() {	
		return lesTitres.length;
		}
	public String getColumnName(int columnIndex)
	{
		return lesTitres[columnIndex];
	}
	public Object getValueAt(int rowIndex, int columnIndex) {
		modReservation uneReservation = (modReservation)lesReservations.get(rowIndex);
		if(columnIndex == 0) return uneReservation.noClient;
		if(columnIndex == 1) return uneReservation.nom;
		if(columnIndex == 2) return uneReservation.adresse;
		if(columnIndex == 3) return uneReservation.telephone;
		if(columnIndex == 4) return uneReservation.fax;
		if(columnIndex == 5) return uneReservation.typeCarte;
		if(columnIndex == 6) return uneReservation.expiration;
		if(columnIndex == 7) return uneReservation.soldeDu;
		if(columnIndex == 8) return uneReservation.noReser;
		if(columnIndex == 9) return uneReservation.dateReser;
		if(columnIndex == 10) return uneReservation.dateDebut;
		else return uneReservation.dateFin;
	}
	public ArrayList<modReservation> getLesEnreg() {
		return lesReservations;
	}
	public void lireEnreg() {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT EQU03PRG01.CLIENT.IDCLI,EQU03PRG01.CLIENT.NOM,EQU03PRG01.CLIENT.ADRESSE,EQU03PRG01.CLIENT.TELEPHONE,EQU03PRG01.CLIENT.FAX,EQU03PRG01.CLIENT.TYPECARTE,EQU03PRG01.CLIENT.DATEEXP,EQU03PRG01.CLIENT.SOLDE_DU,EQU03PRG01.RESERVATION.IDRESER,EQU03PRG01.RESERVATION.DATERESER,EQU03PRG01.RESERVATION.DATEDEBUT,EQU03PRG01.RESERVATION.DATEFIN FROM EQU03PRG01.CLIENT,EQU03PRG01.RESERVATION WHERE EQU03PRG01.CLIENT.IDCLI = EQU03PRG01.RESERVATION.IDCLI order by EQU03PRG01.RESERVATION.IDRESER");
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				lesReservations.add(new modReservation(rs.getInt("IDCLI"),rs.getString("NOM"),rs.getString("ADRESSE"),rs.getString("TELEPHONE"),rs.getString("FAX"),rs.getString("TYPECARTE"),rs.getDate("DATEEXP"),rs.getFloat("SOLDE_DU"),rs.getInt("IDRESER"), rs.getDate("DATERESER"), rs.getDate("DATEDEBUT"), rs.getDate("DATEFIN"))); 
				this.setCourant(noClient);
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans modReservation.java lors de listing",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
 public int getCourant() {
		return courant;
	}
	public void setCourant(int courant) {
		this.courant = courant;
	}
}
package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class modListAyant extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private String codCom;
	private String descCom;


	private int courant = 0;
	private ArrayList<modListAyant> lesTypes = new ArrayList<modListAyant>();
	public final  String[] lesTitres = {"codCom", "descCom"};
	/*
	 * Constructeur 1
	 */
	public modListAyant(int ligne) {
		super();
		lireEnreg(ligne);	
	}
	public modListAyant() {
		super();
		lireEnreg();	
	}
	/*
	 * Constructeur 2 - sert surtout pour peupler la liste des bons pour la consultation
	 */
	public modListAyant(String codCom,String descCom) {
		this.codCom = codCom;
		this.descCom = descCom;	
	}
	@Override
	public int getRowCount() {
		return lesTypes.size();
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
		modListAyant uneListAyant = (modListAyant)lesTypes.get(rowIndex);
		if(columnIndex == 0) return uneListAyant.codCom;
		if(columnIndex == 1) return uneListAyant.descCom;
		else return uneListAyant.codCom;
	}
	public ArrayList<modListAyant> getLesEnreg() {
		return lesTypes;
	}
	public ArrayList<modListAyant> getlesBons() {
		return lesTypes;
	}	
	public void lireEnreg() {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT DISTINCT EQU03PRG01.AYANT.CODCOM, EQU03PRG01.COMMODITE.DESCCOM FROM EQU03PRG01.COMMODITE,EQU03PRG01.AYANT WHERE EQU03PRG01.AYANT.CODCOM = EQU03PRG01.COMMODITE.CODCOM");			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
						String codCom = rs.getString("CODCOM");
						lesTypes.add(new modListAyant(rs.getString("CODCOM"),rs.getString("DESCCOM"))); 
					
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans modListAyant.java lors de listing",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void lireEnreg(int ligne) {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT DISTINCT EQU03PRG01.AYANT.CODCOM, EQU03PRG01.COMMODITE.DESCCOM FROM EQU03PRG01.COMMODITE,EQU03PRG01.CHAMBRE,EQU03PRG01.AYANT WHERE EQU03PRG01.AYANT.CODCOM = EQU03PRG01.COMMODITE.CODCOM");			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				this.setCourant(ligne);
						String codCom = rs.getString("CODCOM");
						lesTypes.add(new modListAyant(rs.getString("CODCOM"),rs.getString("DESCCOM"))); 
						this.setCourant(ligne);
					
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans modListAyant.java lors de listing",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
 int getCourant() {
		return courant;
	}
	public void setCourant(int courant) {
		this.courant = courant;
	}
}
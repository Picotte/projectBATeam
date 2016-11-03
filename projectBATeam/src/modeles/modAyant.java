package modeles;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class modAyant extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private String codCom;
	private String descCom;
	private int noCham;
	private String tmp = null;


	private int courant = 0;
	private ArrayList<modAyant> lesTypes = new ArrayList<modAyant>();
	public final  String[] lesTitres = {"codCom", "descCom"};
	/*
	 * Constructeur 1
	 */
	public modAyant(int noCham) {
		super();
		lireEnreg(noCham);	
	}
	/*
	 * Constructeur 2 - sert surtout pour peupler la liste des bons pour la consultation
	 */
	public modAyant(String codCom,String descCom) {
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
		modAyant uneChambre = (modAyant)lesTypes.get(rowIndex);
		if(columnIndex == 0) return uneChambre.codCom;
		if(columnIndex == 1) return uneChambre.descCom;
		else return uneChambre.codCom;
	}
	public ArrayList<modAyant> getLesEnreg() {
		return lesTypes;
	}
	public ArrayList<modAyant> getlesBons() {
		return lesTypes;
	}	
	public void lireEnreg(int noCham2) {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT DISTINCT EQU03PRG01.AYANT.NOCHAM,EQU03PRG01.AYANT.CODCOM, EQU03PRG01.COMMODITE.DESCCOM FROM EQU03PRG01.COMMODITE,EQU03PRG01.CHAMBRE,EQU03PRG01.AYANT WHERE EQU03PRG01.AYANT.NOCHAM = "+noCham2+" AND EQU03PRG01.AYANT.CODCOM = EQU03PRG01.COMMODITE.CODCOM");			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
					int noCham = rs.getInt("NOCHAM");
					this.noCham = noCham;
					this.setCourant(noCham);
						String codCom = rs.getString("CODCOM");
						lesTypes.add(new modAyant(rs.getString("CODCOM"),rs.getString("DESCCOM"))); 
						this.setCourant(noCham);
					
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans modAyant.java lors de listing",
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
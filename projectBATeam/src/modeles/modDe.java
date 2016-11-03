package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class modDe extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String NoCham;
	private String CodeCham;
	private float Prix;
	private String Occupe;
	private int courant = 0;
	
	private ArrayList<modDe> lesDe = new ArrayList<modDe>();
	public final  String[] lesTitres = {"No.Cham", "Code Type", "Prix", "Occupe"};
	
	public int getCourant() {
		return courant;
	}

	public void setCourant(int courant) {
		this.courant = courant;
	}

	public modDe(int noReser){
		lireEnreg(noReser);
	}
	
	public modDe(String NC, String CC, float P, String O){
		this.NoCham = NC;
		this.CodeCham = CC;
		this.Prix = P;
		this.Occupe = O;
	}
	
	public void lireEnreg(int _noReser) {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement
					("SELECT VIEWDE.NOCHAM, VIEWDE.CODTYPCHA, VIEWDE.PRIX, VIEWDE.ATTRIBUEE FROM EQU03PRG01.VIEWDE WHERE VIEWDE.IDRESER = " + _noReser );			
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
					this.setCourant(rs.getInt("NOCHAM"));
					lesDe.add(new modDe(rs.getString("NOCHAM"),
										rs.getString("CODTYPCHA"), 
										rs.getInt("PRIX"), 
										rs.getString("ATTRIBUEE")));
					
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré dans modDe.java lors de listing",
					"ALERTE", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lesDe.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return lesTitres.length;
	}
	
	@Override
	public String getColumnName(int columnIndex)
	{
		// TODO Auto-generated method stub
		return lesTitres[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		modDe uneDe = (modDe)lesDe.get(rowIndex);
		if(columnIndex == 0) return uneDe.NoCham;
		if(columnIndex == 1) return uneDe.CodeCham;
		if(columnIndex == 2) return uneDe.Prix;
		else return uneDe.Occupe;
	}
}

package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class modListCodeType extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	private String codTypCha;
	private String descType;


	private int courant = 0;

	private ArrayList<modListCodeType> lesCodeTypeCham = new ArrayList<modListCodeType>();
	public final  String[] lesTitres = {"codTypCha","descType"};
	/*
	 * Constructeur 1
	 */
	public modListCodeType() {
		lireEnreg();	
	}
	/*
	 * Constructeur 2 - sert surtout pour peupler la liste des bons pour la consultation
	 */	
	public modListCodeType(String codTypCha,String descType) {

		this.codTypCha = codTypCha;
		this.descType = descType;

	}
	@Override
	public int getRowCount() {
		return lesCodeTypeCham.size();
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
		modListCodeType unCodeType = (modListCodeType)lesCodeTypeCham.get(rowIndex);
		if(columnIndex == 0) return unCodeType.codTypCha;
		else return unCodeType.descType;
	}
	public ArrayList<modListCodeType> getLesEnreg() {
		return lesCodeTypeCham;
	}
	public void lireEnreg() {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT DISTINCT EQU03PRG01.TYPECHAM.CODTYPCHA,EQU03PRG01.TYPECHAM.DESCTYPE FROM EQU03PRG01.CHAMBRE,EQU03PRG01.TYPECHAM  order by EQU03PRG01.TYPECHAM.CODTYPCHA");
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				lesCodeTypeCham.add(new modListCodeType(rs.getString("CODTYPCHA"),rs.getString("DESCTYPE"))); 
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré, il n'y a aucun type de chambre a afficher",
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
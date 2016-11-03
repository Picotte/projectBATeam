package modeles;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class modListCodeLocalisation extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	private String codLoc;
	private String descLoc;

	private int courant = 0;

	private ArrayList<modListCodeLocalisation> lesCodeLocalisation = new ArrayList<modListCodeLocalisation>();
	public final  String[] lesTitres = {"codLoc","descLoc"};
	/*
	 * Constructeur 1
	 */
	public modListCodeLocalisation() {
		lireEnreg();	
	}
	/*
	 * Constructeur 2 - sert surtout pour peupler la liste des bons pour la consultation
	 */	
	public modListCodeLocalisation(String codLoc,String descLoc) {

		this.codLoc = codLoc;
		this.descLoc = descLoc;	
	}
	@Override
	public int getRowCount() {
		return lesCodeLocalisation.size();
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
		modListCodeLocalisation unCodeLocalisation = (modListCodeLocalisation)lesCodeLocalisation.get(rowIndex);
		if(columnIndex == 0) return unCodeLocalisation.codLoc;
		else return unCodeLocalisation.descLoc;
	}
	public ArrayList<modListCodeLocalisation> getLesEnreg() {
		return lesCodeLocalisation;
	}
	public void lireEnreg() {
		try {    
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement("SELECT DISTINCT EQU03PRG01.LOCALISATION.CODLOC,EQU03PRG01.LOCALISATION.DESCLOC FROM EQU03PRG01.CHAMBRE,EQU03PRG01.LOCALISATION order by EQU03PRG01.LOCALISATION.CODLOC");
			ResultSet rs = state.executeQuery();
			while (rs.next()) {
				lesCodeLocalisation.add(new modListCodeLocalisation(rs.getString("CODLOC"),rs.getString("DESCLOC"))); 
			} 		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Probleme rencontré, il n'y a aucun type de localisation a afficher",
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
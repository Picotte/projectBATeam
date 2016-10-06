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
        private int NoCham;
        private String CodeCham;
        private float Prix;
        private String Occupe;
        private int courant;
        
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
        
        public modDe(int NC, String CC, float P, String O){
                this.NoCham = NC;
                this.CodeCham = CC;
                this.Prix = P;
                this.Occupe = O;
        }
        
        public void lireEnreg(int _noReser) {
                try {    
                        PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement
                                        ("SELECT VIEWDE.NOCHAM, VIEWDE.CODTYPCHA, VIEWDE.PRIX, VIEWDE.ATTRIBUEE FROM EQU03PRG01.VIEWDE WHERE IDRESER = " + _noReser );
                        ResultSet rs = state.executeQuery();
                        while (rs.next()) {
                                        this.setCourant(rs.getInt("NOCHAM"));
                                        lesDe.add(new modDe(rs.getInt("NOCHAM"),
                                        rs.getString("CODTYPCHA"), 
                                        rs.getInt("PRIX"), 
                                        rs.getString("ATTRIBUEE")));
                                        
                        }                 
                } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Probleme rencontré dans modAyant.java lors de listing",
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

        public String getColumnName(int columnIndex)
    	{
    		return lesTitres[columnIndex];
    	}
        	
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
                modDe uneDe = (modDe)lesDe.get(rowIndex);
                if(columnIndex == 0) 
                {
                	System.out.println(uneDe.NoCham);
                	return uneDe.NoCham;
                }
                if(columnIndex == 1) 
                {
                	System.out.println(uneDe.CodeCham);
                	return uneDe.CodeCham;
                }
                	
                if(columnIndex == 2) 
                {
                	System.out.println(uneDe.Prix);
                	return uneDe.Prix;
                }
                else
                {
                	System.out.println(uneDe.Occupe);
                	return uneDe.Occupe;
                }
        }
        
        
        
}
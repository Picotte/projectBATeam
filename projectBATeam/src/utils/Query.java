package utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modeles.modConnexion;
import modeles.Model;

public class Query {
	private final DateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
	private String query;
	public Query(String statement){
		this.query = statement;
	}

	public Model execute(Object... params){
		try {    
			Model model = new Model();
			PreparedStatement state = modConnexion.getInstance().getLaConnectionStatique().prepareStatement(query);
			int paramIndex = 1;
			for(Object param:params){
				state.setObject(paramIndex , param);
				paramIndex++;
			}

			ResultSet rs = state.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			for(int i = 0 ; i < columnCount;i++)
				model.columnTitle().add(rsmd.getColumnName(i+1));
	
			while (rs.next()) {
				ArrayList<Object> row = new ArrayList<Object>();
				for(int i = 0 ; i < columnCount; i++){
					Object object = rs.getObject(i+1);
					if(object.getClass() == java.sql.Timestamp.class){
						object = formatDate.format(object);
					}
					row.add(object);
				}
				model.data().add(row); 
			} 
			return model;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println("problem with this statement : " + query);
		}
		return null;
	}
}
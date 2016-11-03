package utils;

import java.sql.CallableStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import modeles.modConnexion;

public class Procedure {
	String statement;
	public Procedure(String statement){
		this.statement = statement;
	}
	
	public boolean execute(Object... params){
		try {    
			CallableStatement  query = modConnexion.getInstance().getLaConnectionStatique().prepareCall(statement);
			int paramIndex = 1;
			for(Object param:params){
				query.setObject(paramIndex , param);
				paramIndex++;
			}
			query.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println("problem with this statement : " + statement);
			return false;
		}
		return true;
	}
}

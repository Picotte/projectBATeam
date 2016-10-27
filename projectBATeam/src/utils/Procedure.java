package utils;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modeles.modConnexion;

public class Procedure {
	String statement;
	public Procedure(String statement){
		this.statement = statement;
	}
	
	public boolean execute(ArrayList<String> sqlParameters){
		try {    
			CallableStatement  query = modConnexion.getInstance().getLaConnectionStatique().prepareCall(statement);
			for(int i = 0 ; i < sqlParameters.size() ;i++)
				query.setObject(i + 1 , sqlParameters.get(i));
			query.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println("problem with this statement : " + statement);
			return false;
		}
		return true;
	}
	
	public boolean execute(String param){
		try {    
			CallableStatement  query = modConnexion.getInstance().getLaConnectionStatique().prepareCall(statement);
				query.setObject(1, param);
			query.executeUpdate();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ALERTE", JOptionPane.ERROR_MESSAGE);
			System.out.println("problem with this statement : " + statement);
			return false;
		}
		return true;
	}
}

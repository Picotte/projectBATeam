package modeles;

import java.util.ArrayList;

import utils.Procedure;
import utils.Query;

public final class procsE02 {


	private static Query SELECT_RESERVATION = new Query("SELECT * FROM vueReservation");
	private static Query SELECT_CHAMBRE = new Query("SELECT EQU03PRG01.CHAMBRE.NOCHAM,EQU03PRG01.CHAMBRE.ETAGE,EQU03PRG01.CHAMBRE.PRIX,EQU03PRG01.CHAMBRE.ETAT,EQU03PRG01.CHAMBRE.MEMO,EQU03PRG01.TYPECHAM.CODTYPCHA,EQU03PRG01.TYPECHAM.DESCTYPE,EQU03PRG01.LOCALISATION.CODLOC,EQU03PRG01.LOCALISATION.DESCLOC FROM EQU03PRG01.CHAMBRE,EQU03PRG01.TYPECHAM,EQU03PRG01.LOCALISATION WHERE EQU03PRG01.CHAMBRE.CODTYPCHA = EQU03PRG01.TYPECHAM.CODTYPCHA AND EQU03PRG01.CHAMBRE.CODLOC = EQU03PRG01.LOCALISATION.CODLOC order by EQU03PRG01.CHAMBRE.NOCHAM");
	private static Query SELECT_AYANT;
	private static Query SELECT_CODCOM = new Query("SELECT EQU03PRG01.COMMODITE.CodCom, EQU03PRG01.COMMODITE.DescCom from EQU03PRG01.COMMODITE");
	private static Procedure INSERT_CHAMBRE = new Procedure("INSERT INTO EQU03PRG01.CHAMBRE VALUES(?,?,?,?,?,?,?)");
	private static Procedure INSERT_AYANT = new Procedure("INSERT INTO EQU03PRG01.AYANT VALUES (?,?)");
	private static Procedure UPDATE_ADDTYPECHAM;
	private static Procedure UPDATE_SUPPTYPECHAM;

	private static Query SELECT_DE = new Query("select * from EQU03PRG01.DE");
	private static Procedure UPDATE_CHAMBRE;
	private static Procedure DELETE_AYANT;
	private static Procedure DELETE_CHAMBRE;
	
	

	/**
	 * @return le modele chambre formater comme suit:
	 * nocham,etage,etat,codtyp,destyp,codloc,descloc,prix,memo
	 */
	public static  Model SELECT_CHAMBRE(){
		return SELECT_CHAMBRE.execute();
	}

	/**
	 * @return le modele codcom
	 * codcom,descCom
	 */
	public static Model SELECT_CODCOM(){
		return SELECT_CODCOM.execute();
	}
	
	/**
	 * @param le numero de la chambre 
	 * @return la liste des commodite pour une chambre formater comme suit:
	 * codCom,descCom
	 */
	public static  Model SELECT_AYANT(String noCham){
		SELECT_AYANT = new Query("SELECT EQU03PRG01.COMMODITE.CodCom , EQU03PRG01.COMMODITE.DescCom FROM EQU03PRG01.COMMODITE , EQU03PRG01.AYANT WHERE EQU03PRG01.COMMODITE.CodCom = EQU03PRG01.AYANT.CodCom AND EQU03PRG01.AYANT.noCham = "+noCham);
		return SELECT_AYANT.execute();
	}
	/**
	 * @return le modele de formater comme suit:
	 * idReser,Nocham,Attribuee
	 */
	public static  Model SELECT_DE(){
		return SELECT_DE.execute();
	}
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_CHAMBRE(String text, String text2, float text3, int text4, String text5,
			String text6, String text7) {
		return INSERT_CHAMBRE.execute(text, text2, text3, text4, text5,text6, text7);
	}
	
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,codcom
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_AYANT(String nocham, String codcom) {
		return INSERT_AYANT.execute(nocham, codcom);
	}



	
	/**
	 * @param sqlParameters list de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed 
	 */
	public static boolean UPDATE_ADDTYPECHAM(String codTypCham){
		System.out.println(codTypCham);
		UPDATE_ADDTYPECHAM = new Procedure("UPDATE EQU03PRG01.TYPECHAM SET NBDISPO = NBDISPO+1 WHERE EQU03PRG01.TYPECHAM.CODTYPCHA = '"+codTypCham+"'");

		return UPDATE_ADDTYPECHAM.execute();
	}
	/**
	 * @param sqlParameters list de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed 
	 */
	public static boolean UPDATE_SUPPTYPECHAM(String codTypCham){
		System.out.println(codTypCham);
		UPDATE_SUPPTYPECHAM = new Procedure("UPDATE EQU03PRG01.TYPECHAM SET NBDISPO = NBDISPO-1 WHERE EQU03PRG01.TYPECHAM.CODTYPCHA = '"+codTypCham+"'");

		return UPDATE_SUPPTYPECHAM.execute();
	}
	/**
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed 
	 */
	public static boolean UPDATE_CHAMBRE(String noCham, String etage, float prix, int etat, String codTypCha,
			String codLoc, String memo){
		UPDATE_CHAMBRE = new Procedure("UPDATE EQU03PRG01.CHAMBRE SET ETAGE = '"+etage+"', PRIX = "+prix+", ETAT = "+etat+", CODTYPCHA = '"+codTypCha+"', CODLOC = '"+codLoc+"', MEMO = '"+memo+"' WHERE EQU03PRG01.CHAMBRE.NOCHAM = '"+noCham+"'");
		return UPDATE_CHAMBRE.execute();
	}
	/**
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	public static boolean DELETE_AYANT(String nocham){
		DELETE_AYANT = new Procedure("DELETE FROM EQU03PRG01.AYANT WHERE noCham = '"+nocham+"'");
		return DELETE_AYANT.execute();
	}
	
	/** 
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	public static boolean DELETE_CHAMBRE(String nocham){
		DELETE_CHAMBRE = new Procedure("DELETE FROM EQU03PRG01.CHAMBRE WHERE noCham = '"+nocham+"'");

		return DELETE_CHAMBRE.execute();
	}
}

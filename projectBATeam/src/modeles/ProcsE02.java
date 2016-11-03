package modeles;

import java.util.ArrayList;

import utils.Procedure;
import utils.Query;

public final class ProcsE02 {


	private static Query SELECT_RESERVATION = new Query("SELECT * FROM vueReservation");
	private static Query SELECT_CHAMBRE = new Query("SELECT EQU03PRG01.CHAMBRE.NOCHAM,EQU03PRG01.CHAMBRE.ETAGE,EQU03PRG01.CHAMBRE.PRIX,EQU03PRG01.CHAMBRE.ETAT,EQU03PRG01.CHAMBRE.MEMO,EQU03PRG01.TYPECHAM.CODTYPCHA,EQU03PRG01.TYPECHAM.DESCTYPE,EQU03PRG01.LOCALISATION.CODLOC,EQU03PRG01.LOCALISATION.DESCLOC FROM EQU03PRG01.CHAMBRE,EQU03PRG01.TYPECHAM,EQU03PRG01.LOCALISATION WHERE EQU03PRG01.CHAMBRE.CODTYPCHA = EQU03PRG01.TYPECHAM.CODTYPCHA AND EQU03PRG01.CHAMBRE.CODLOC = EQU03PRG01.LOCALISATION.CODLOC order by EQU03PRG01.CHAMBRE.NOCHAM");
	private static Query SELECT_AYANT = new Query("SELECT COMMODITE.CodCom , COMMODITE.DescCom FROM COMMODITE , AYANT where COMMODITE.CodCom = AYANT.CodCom and AYANT.noCham = @noCham");
	private static Query SELECT_CODCOM = new Query("SELECT EQU03PRG01.COMMODITE.CodCom, EQU03PRG01.COMMODITE.DescCom from EQU03PRG01.COMMODITE");
	private static Procedure INSERT_CHAMBRE = new Procedure("INSERT into EQU03PRG01.CHAMBRE VALUES( ? , ? , ? , ? , ? , ? , ? )");
	private static Procedure INSERT_AYANT = new Procedure("INSERT into EQU03PRG01.AYANT VALUES ( ? , ? )");
	//private static Query UPDATE_CHAMBRE = new Query("UPDATE INTO EQU03PRG01.CHAMBRE VALUES(?,?,?,?,?,?,?)");
	//private static Query DELETE_AYANT = new Query(" DELETE EQU03PRG01.AYANT(?)");
	//private static Query DELETE_CHAMBRE = new Query("DELETE EQU03PRG01.CHAMBRE(?)");
	
	
	/**
	 * @return le modele reservation formater comme suit:
	 * idCli,nom,adresse,telephone,fax,typeCarte,dateExp,soldeDu,IdReser,dateReser,dateDebut,dateFin
	 */
	public static  Model SELECT_RESERVATION(){
		return SELECT_RESERVATION.execute(null);
	}
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
		return SELECT_AYANT.execute(noCham);
	}
	
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_CHAMBRE(ArrayList<String> sqlParameters){
		return INSERT_CHAMBRE.execute(sqlParameters);
	}
	
	/**
	 * @param sqlParameters List de parametres comme suit
	 * @param nocham,codcom
	 * @return true if the procedure succeed
	 */
	public static boolean INSERT_AYANT(ArrayList<String> sqlParameters){
		return INSERT_AYANT.execute( sqlParameters);
	}
	
	/**
	 * @param sqlParameters list de parametres comme suit
	 * @param nocham,etage,prix,etat,codtyp,codloc,memo
	 * @return true if the procedure succeed 
	 */
/*	public static boolean UPDATE_CHAMBRE(ArrayList<String> sqlParameters){
		return UPDATE_CHAMBRE.execute(sqlParameters);
	}*/
	
	/**
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	/*public static boolean DELETE_AYANT(String nocham){
		return DELETE_AYANT.execute(nocham);
	}*/
	
	/** 
	 * @param nocham
	 * @return true if the procedure succeed
	 */
	/*public static boolean DELETE_CHAMBRE(String nocham){
		return DELETE_CHAMBRE.execute(nocham);
	}*/
}

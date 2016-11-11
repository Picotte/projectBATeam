package modeles;

import utils.Procedure;
import utils.Query;

public final class ProcsE03 {
	
	private static Query SELECT_ARRIVE = new Query("Select viewArriver.NoArrive , viewArriver.IdReser as IdR, viewArriver.IdCli , viewArriver.Nom, viewArriver.NoCham, viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser, viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin, viewArriverReservation.IdCli as IdCliR, viewArriverReservation.Nom as NomR FROM EQU03prg01.viewArriver, EQU03prg01.viewArriverReservation where viewArriverReservation.IdReser = viewArriver.IdReser");
	private static Query SELECT_DE = new Query("SELECT NOCHAM, CODTYPCHA, PRIX, ATTRIBUEE FROM EQU03PRG01.VIEWDE WHERE IDRESER = ?");
	private static Query SELECT_PK_ARRIVE = new Query("SELECT viewArriver.IdReser as NoReser, viewArriver.IdCli as NoCli, viewArriver.Nom as Nom, viewArriver.NoCham as NoCham FROM EQU03prg01.viewArriver");
	private static Query SELECT_DEPART = new Query("SELECT NoDepart, IdCli, Nom, Adresse, Telephone, Fax, TypeCarte, IdReser, dateReser, dateDebut, dateFin, ConfirmePar FROM EQU03prg01.viewDepart");
	private static Query SELECT_LISTEDEPART = new Query("SELECT v.IdReser, v.NoCham, v.IdCli, v.Nom, v.dateDepart FROM EQU03prg01.viewListeDepart v WHERE v.IdReser = ?");
	private static Query SELECT_PK_CLIENT = new Query("SELECT c.IdCli, c.Nom, c.Adresse, c.Telephone, c.Fax FROM EQU03prg01.CLIENT c Where c.IdCli not in (Select a.IdCli from EQU03prg01.Arrive a)");
	//Modifier la PK reservation pour date de fin <= today >= date de debut
	private static Query SELECT_PK_RESERVATION = new Query("SELECT  r.IdReser, r.IdCli, c.Nom, r.dateReser, r.dateDebut, r.dateFin from EQU03prg01.RESERVATION r, EQU03prg01.CLIENT c Where r.IdCli = c.IdCli and r.IdReser in (Select d.IdReser from EQU03prg01.DE d Where d.ATTRIBUEE != 1)");
	private static Query SELECT_DE_MODE_AJOUT = new Query("SELECT d.NOCHAM, ch.CODTYPCHA, ch.PRIX, d.ATTRIBUEE FROM EQU03prg01.DE d, EQU03prg01.CHAMBRE ch WHERE d.NoCham = ch.NoCham and d.IdReser = ? and d.ATTRIBUEE != 1");
	private static Procedure INSERT_ARRIVE = new Procedure("call EQU03PRG01.INSERT_ARRIVER(?,?,?)");
	private static Procedure UPDATE_ARRIVE = new Procedure("call EQU03PRG01.UPDATE_ARRIVER(?,?,?,?,?)");
	
	static Query SELECT_ARRIVE_MODIF = new Query("Select viewArriver.NoArrive , viewArriver.IdReser as IdR, viewArriver.IdCli , viewArriver.Nom, viewArriver.NoCham, viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser, viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin, viewArriverReservation.IdCli as IdCliR, viewArriverReservation.Nom as NomR FROM EQU03prg01.viewArriver, EQU03prg01.viewArriverReservation where viewArriverReservation.IdReser = viewArriver.IdReser and (viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nocham) not in (SELECT IdReser, IdCli, nocham from EQU03PRG01.depart)");
	
	/**
	 * @return le model des arriver dans lordre suivant:
	 * NoArrive, IdR, IdCli, Nom, NoCham, Telephone, Fax, Adresse, IdReser, dateReser, dateDebut, dateFin, IdCliR, NomR
	 */
	public static Model SELECT_ARRIVE_MODIF(){
		return SELECT_ARRIVE_MODIF.execute();
	}
	
	
	public static boolean UPDATE_ARRIVE(Object updateValue1, Object updateValue2, Object updateValue3, Object updateValue4, Object updateValue5){
		return UPDATE_ARRIVE.execute(updateValue1,updateValue2,updateValue3,updateValue4,updateValue5);	
	}
	
	/**
	 * @return le model des arriver dans lordre suivant:
	 * NoArrive, IdR, IdCli, Nom, NoCham, Telephone, Fax, Adresse, IdReser, dateReser, dateDebut, dateFin, IdCliR, NomR
	 */
	public static Model SELECT_ARRIVE(){
		return SELECT_ARRIVE.execute();
	}
	
	public static boolean INSERT_ARRIVE(Object insertValue, Object insertValue2, Object insertValue3){
		return INSERT_ARRIVE.execute(insertValue, insertValue2, insertValue3);
	}
	
	/**
	 * @param IdReser
	 * @return les information suivante:
	 * NOCHAM, CODTYPCHA, PRIX, ATTRIBUEE
	 */
	public static Model SELECT_DE(String IdReser){
		return SELECT_DE.execute(IdReser);
	}
	
	public static Model SELECT_PK_ARRIVE(){
		return SELECT_PK_ARRIVE.execute();
	}
	
	/**
	 * @return IdCli, Nom, Adresse, Telephone, Fax
	 */
	public static Model SELECT_PK_CLIENT(){
		return SELECT_PK_CLIENT.execute();
	}
	
	/**
	 * @return Les information suivante:
	 * NoDepart, IdCli, Nom, Adresse, Telephone, Fax, TypeCarte, IdReser, dateReser, dateDebut, dateFin, ConfirmePar
	 */
	public static Model SELECT_DEPART(){
		return SELECT_DEPART.execute();
	}
	
	/**
	 * @param IdReser
	 * @return Les information suivante:
	 * IdReser, NoCham, IdCli, Nom, dateDepart
	 */
	public static Model SELECT_LISTEDEPART(String IdReser){
		return SELECT_LISTEDEPART.execute(IdReser);
	}
	
	/**
	 * @return Les info :
	 * IdReser, IdCli, Nom,  dateReser, dateDebut, dateFin
	 */
	public static Model SELECT_PK_RESERVATION(){
		return SELECT_PK_RESERVATION.execute();
	}
	
	/**
	 * @param IdReser
	 * @return les information suivante:
	 * NOCHAM, CODTYPCHA, PRIX, ATTRIBUEE
	 */
	public static Model SELECT_DE_MODE_AJOUT(String IdReser){
		return SELECT_DE_MODE_AJOUT.execute(IdReser);
	}
}

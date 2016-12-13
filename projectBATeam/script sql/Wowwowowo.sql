/*Create or replace procedure DELETE_ARRIVER (NoArrive integer, IdReser integer, IdCli integer) as
BEGIN
  UPDATE DE SET ATTRIBUEE = 0 WHERE de.NOCHAM = (Select Nocham from EQU03PRG01.arrive where NoArrive = DELETE_ARRIVER.NoArrive) and IDRESER = DELETE_ARRIVER.IDRESER;
  delete from EQU03PRG01.ARRIVE where NoArrive = DELETE_ARRIVER.NoArrive and (IDReser, IdCli) Not in (select IdReser,IdCli from EQU03PRG01.Trx where IdReser = DELETE_ARRIVER.IdReser and IdCli = DELETE_ARRIVER.IdCli) and (IDReser, IdCli) not in (Select IdReser, IdCli from EQU03PRG01.Depart where IdReser = DELETE_ARRIVER.IdReser and IdCli = DELETE_ARRIVER.IdCli group by (IdReser, IdCli)) ;
  
END DELETE_ARRIVER;*/

/*grant execute on DELETE_ARRIVER to  EQU03PRG02, EQU03PRG03;*/

/*create or replace view viewArriver as
  Select a.NoArrive, a.IdReser, a.IdCli, c.Nom, c.Adresse, c.Telephone, c.Fax, a.NoCham
  From CLIENT c, ARRIVE a
  Where c.IdCli = a.IdCli;

create or replace view viewArriverReservation as
  Select r.IdReser, r.IdCli, r.dateReser, r.dateDebut, r.dateFin, c.Nom
  From CLIENT c, RESERVATION r
  Where c.IdCli = r.IdCli;

create or replace view viewDe as
  Select d.IdReser, d.Nocham, d.Attribuee, c.Prix, c.CodTypCha
  From DE d, CHAMBRE c
  Where d.NoCham = c.NoCham;


Select viewArriver.NoArrive , viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nom, viewArriver.NoCham, viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser, viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin, viewArriverReservation.IdCli, viewArriverReservation.Nom FROM EQU03prg01.viewArriver, EQU03prg01.viewArriverReservation where viewArriverReservation.IdReser = viewArriver.IdReser;


  Select viewArriver.NoArrive , viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nom, viewArriver.NoCham,
  			 viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser,
         viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin,
         viewArriverReservation.IdCli, viewArriverReservation.Nom
  from viewArriver, viewArriverReservation
  where viewArriverReservation.IdReser = viewArriver.IdReser;

  Select VIEWDE.NOCHAM, VIEWDE.CODTYPCHA, VIEWDE.PRIX, VIEWDE.ATTRIBUEE
  From VIEWDE
  Where VIEWDE.IDRESER = 1;
*/
/*create or replace view viewDepart as
SELECT d.NoDepart, d.IdCli, c.Nom, c.Adresse, c.Telephone, c.Fax, c.TypeCarte, d.IdReser, r.dateReser, r.dateDebut, r.dateFin, d.ConfirmePar 
FROM EQU03prg01.CLIENT c, EQU03prg01.DEPART d, EQU03prg01.RESERVATION r
WHERE d.IdCli = c.IdCli and d.IdReser = r.IdReser;

create or replace view viewListeDepart as
SELECT d.NoCham, d.IdCli, c.Nom, d.DATEDEPART, d.IDRESER
FROM EQU03prg01.DEPART d, EQU03prg01.CLIENT c
WHERE d.IdCli = c.IdCli;

commit;

SELECT NoDepart, IdCli, Nom, Adresse, Telephone, Fax,TypeCarte, IdReser, dateReser, dateDebut, dateFin, ConfirmePar FROM EQU03prg01.viewDepart ;

SELECT v.NoCham, v.IdCli, v.Nom, v.DATEDEPART
FROM EQU03prg01.viewListeDepart v
WHERE v.IdReser = 10;*/


/*CREATE OR REPLACE PROCEDURE EQU03PRG01.INSERT_ARRIVER (IdReser integer, IdCli integer, NoCham varchar2) AS 
BEGIN
  INSERT INTO ARRIVE VALUES(SEQ_ARRIVE.nextval, INSERT_ARRIVER.IdReser, INSERT_ARRIVER.IDCLI, INSERT_ARRIVER.NOCHAM, sysDate);
  UPDATE DE SET ATTRIBUEE = 1 WHERE NOCHAM = INSERT_ARRIVER.NOCHAM;
END INSERT_ARRIVER;*/

/*GRANT EXECUTE on INSERT_ARRIVER to EQU03PRG02, EQU03PRG03;*/

/*CREATE OR REPLACE PROCEDURE UPDATE_ARRIVER (NOARRIVE integer, IDRESER1 integer, NOCHAM1 varchar2, IDRESER2 integer, NOCHAM2 varchar2, Mode_ integer) AS
BEGIN
  if UPDATE_ARRIVER.Mode_ = 1 then
    UPDATE DE SET ATTRIBUEE = 0 WHERE NOCHAM = UPDATE_ARRIVER.NOCHAM1 and IDRESER = UPDATE_ARRIVER.IDRESER1;
    UPDATE DE SET ATTRIBUEE = 1 WHERE NOCHAM = UPDATE_ARRIVER.NOCHAM2 and IDRESER = UPDATE_ARRIVER.IDRESER2;
    UPDATE ARRIVE SET NOCHAM = NOCHAM2 WHERE NOARRIVE = UPDATE_ARRIVER.NOARRIVE;
  else
    UPDATE DE SET NOCHAM = UPDATE_ARRIVER.NOCHAM2 where NOCHAM = UPDATE_ARRIVER.NOCHAM1 and IDRESER = UPDATE_ARRIVER.IDRESER1;
    UPDATE ARRIVE SET NOCHAM = NOCHAM2 WHERE NOARRIVE = UPDATE_ARRIVER.NOARRIVE;
  end if;
  
END UPDATE_ARRIVER;


/*GRANT EXECUTE on UPDATE_ARRIVER to EQU03PRG02, EQU03PRG03;


/*Select viewArriver.NoArrive , viewArriver.IdReser as IdR, viewArriver.IdCli , viewArriver.Nom, viewArriver.NoCham, viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser, viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin, viewArriverReservation.IdCli as IdCliR, viewArriverReservation.Nom as NomR FROM EQU03prg01.viewArriver, EQU03prg01.viewArriverReservation where viewArriverReservation.IdReser = viewArriver.IdReser and (viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nocham) not in (SELECT IdReser, IdCli, nocham from EQU03PRG01.depart);

*/

/*select NoCham, prix, etat, CodTypCha from EQU03PRG01.CHambre where etat = 1 and NoCham not in (Select Nocham from EQU03PRG01.de);*/

/*Grant delete on all to EQU03PRG02, EQU03PRG03;
grant execute on Update to EQU03PRG02, EQU03PRG03;*/


/*select * from equ03prg01.de;
*/


/*select r.Idreser, r.DATERESER, r.DATEDEBUT, r.DATEFIN, nc.NOCHAM, ch.CODTYPCHA, nc.IDCLI, nc.nom
from reservation r, chambre ch, (select d.IDRESER, d.NOCHAM, nb.nom, nb.IDCLI 
                                from  de d
                                full outer join ( select a.NOCHAM, a.IDCLI, a.IDRESER, c.nom  from ARRIVE a, client c
                                                  where a.IDCLI=c.IDCLI order by a.IDRESER
                                                ) nb
                                on d.IDRESER=nb.IDRESER and d.NOCHAM=nb.NOCHAM) nc
where r.IDRESER=nc.IDRESER and ch.NOCHAM=nc.NOCHAM order by r.idreser, nc.NOCHAM;*/
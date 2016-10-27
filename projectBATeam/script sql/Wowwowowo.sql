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


CREATE OR REPLACE PROCEDURE INSERT_ARRIVER (IdReser integer, IdCli integer, NoCham varchar2) AS 
BEGIN
  INSERT INTO ARRIVE VALUES(SEQ_ARRIVE.nextval, INSERT_ARRIVER.IdReser, INSERT_ARRIVER.IDCLI, INSERT_ARRIVER.NOCHAM, sysDate);
  UPDATE DE SET ATTRIBUEE = 1 WHERE NOCHAM = INSERT_ARRIVER.NOCHAM;
END INSERT_ARRIVER;












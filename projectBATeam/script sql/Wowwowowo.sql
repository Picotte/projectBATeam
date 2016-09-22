create or replace view viewArriver as
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


  Select viewArriver.NoArrive , viewArriver.IdReser, viewArriver.IdCli, viewArriver.Nom, viewArriver.NoCham,
  			 viewArriver.Telephone, viewArriver.Fax, viewArriver.Adresse, viewArriverReservation.IdReser,
         viewArriverReservation.dateReser, viewArriverReservation.dateDebut, viewArriverReservation.dateFin,
         viewArriverReservation.IdCli, viewArriverReservation.Nom
  from viewArriver, viewArriverReservation
  where viewArriverReservation.IdReser = viewArriver.IdReser;

  Select VIEWDE.NOCHAM, VIEWDE.CODTYPCHA, VIEWDE.PRIX, VIEWDE.ATTRIBUEE
  From VIEWDE
  Where VIEWDE.IDRESER = 1;

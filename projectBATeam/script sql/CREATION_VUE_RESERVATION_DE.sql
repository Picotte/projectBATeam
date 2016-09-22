--VUES
CREATE OR REPLACE VIEW 
          viewChambreTypeLocalisation 
          (
            NoCham,
            Etage,
            Prix,
            Etat,
            CodTypCha,
            DescType,
            CodLoc,
            DescLoc
          ) 
AS
SELECT    Chambre.NoCham, 
          Chambre.Etage,
          Chambre.Prix,
          Chambre.Etat,
          TypeCham.CodTypCha,
          TypeCham.DescType,
          Localisation.CodLoc,
          Localisation.DescLoc
FROM      chambre,
          typecham,
          Localisation 
WHERE     Chambre.CodTypCha = TypeCham.CodTypCha 
AND       Chambre.CodLoc = Localisation.CodLoc
order by  Chambre.nocham;
-------------------------------------------------------------------------------
CREATE OR REPLACE VIEW 
          viewClientReservation 
          (
            IDCLI,
            NOM,
            ADRESSE,
            TELEPHONE,
            FAX,
            TYPECARTE,
            DATEEXP,
            SOLDE_DU,
            IDRESER,
            DATERESER,
            DATEDEBUT,
            DATEFIN
          ) 
AS
SELECT    CLIENT.IDCLI, 
          CLIENT.NOM,
          CLIENT.ADRESSE,
          CLIENT.TELEPHONE,
          CLIENT.FAX,
          CLIENT.TYPECARTE,
          CLIENT.DATEEXP,
          CLIENT.SOLDE_DU,
          RESERVATION.IDRESER,
          RESERVATION.DATERESER,
          RESERVATION.DATEDEBUT,
          RESERVATION.DATEFIN
FROM      CLIENT,
          RESERVATION
WHERE     CLIENT.IDCLI = RESERVATION.IDCLI
order by  RESERVATION.IDRESER;
-------------------------------------------------------------------------------
CREATE OR REPLACE VIEW 
          viewDeChambre 
          (
            NOCHAM,
            CODTYP,
            PRIX,
            ATTRIBUEE
          ) 
AS
SELECT    CHAMBRE.NOCHAM, 
          CHAMBRE.CODTYPCHA,
          CHAMBRE.PRIX,
          DE.ATTRIBUEE
FROM      CHAMBRE,
          DE,
          RESERVATION
WHERE     DE.NOCHAM = CHAMBRE.NOCHAM
AND       DE.IDRESER = RESERVATION.IDRESER
order by  RESERVATION.IDRESER;
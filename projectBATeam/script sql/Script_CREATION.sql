drop table CLIENT cascade constraints;
drop table COMMODITE cascade constraints;
drop table LOCALISATION cascade constraints;
drop table RESERVATION cascade constraints;
drop table TYPECHAM cascade constraints;
drop table CHAMBRE cascade constraints;
drop table DEPART cascade constraints;
drop table DE cascade constraints;
drop table AYANT cascade constraints;
drop table TYPTRX cascade constraints;
drop table TRX cascade constraints;
drop table ARRIVE cascade constraints;

--------------------------------------------------------------
--CLIENT
--------------------------------------------------------------
--SEQUENCE RESET
DROP SEQUENCE SEQ_CLIENT;
CREATE SEQUENCE SEQ_CLIENT;
--CREATION
CREATE TABLE CLIENT(
    IDCLI NUMBER(5,0),
    NOM VARCHAR2(25 BYTE),
    ADRESSE VARCHAR2(50 BYTE),
    TELEPHONE VARCHAR2(10 BYTE),
    NOCARTE VARCHAR2(16 BYTE),
    TYPECARTE VARCHAR2(15 BYTE),
    DATEEXP DATE,
    FAX VARCHAR2(10 BYTE),
    SOLDE_DU NUMBER(12,2),
    constraint pk_CLIENT_IDCLI primary key (IDCLI));
--INSERTION

--------------------------------------------------------------
--COMMODITE
--------------------------------------------------------------
--CREATION
CREATE TABLE COMMODITE(
    "CODCOM" VARCHAR2(2 BYTE),
    "DESCCOM" VARCHAR2(25 BYTE),
    constraint pk_COMMODITE_CODCOM primary key (CODCOM));
--INSERTION

--------------------------------------------------------------
--LOCALISATION
--------------------------------------------------------------
--CREATION
CREATE TABLE LOCALISATION(
    "CODLOC" VARCHAR2(2 BYTE),
    "DESCLOC" VARCHAR2(25 BYTE),
    constraint pk_LOCALISATION_CODLOC primary key (CODLOC));
--INSERTION

--RESERVATION
--------------------------------------------------------------
--SEQUENCE RESET
DROP SEQUENCE SEQ_RESERVATION;
CREATE SEQUENCE SEQ_RESERVATION;
--CREATION
CREATE TABLE RESERVATION(
    "IDRESER" NUMBER(5,0),
    "IDCLI" NUMBER(5,0),
    "DATERESER" DATE,
    "DATEDEBUT" DATE,
    "DATEFIN" DATE,
    constraint fk_RESERVATION_IDCLI foreign key (IDCLI)
      references CLIENT (IDCLI),
    constraint pk_RESERVATION_IDRESER primary key (IDRESER));
--INSERTION
DELETE RESERVATION;

--TYPECHAM
--------------------------------------------------------------
--CREATION
CREATE TABLE TYPECHAM(
    "CODTYPCHA" VARCHAR2(2 BYTE),
    "DESCTYPE" VARCHAR2(25 BYTE),
    "NBDISPO" NUMBER(3,0),
    constraint pk_TYPECHAM_CODTYPCHA primary key (CODTYPCHA));
--INSERTION

--------------------------------------------------------------
--CHAMBRE
--------------------------------------------------------------
--CREATION
CREATE TABLE CHAMBRE(
    "NOCHAM" VARCHAR2(3 BYTE),
    "ETAGE" VARCHAR2(2 BYTE),
    "PRIX" NUMBER(12,2),
    "ETAT" NUMBER(*,0),
    "CODTYPCHA" VARCHAR2(2 BYTE),
    "CODLOC" VARCHAR2(2 BYTE),
    "MEMO" VARCHAR2(255 BYTE),
    constraint fk_CHAMBRE_CODTYPCHA foreign key (CODTYPCHA)
      references TYPECHAM (CODTYPCHA),
    constraint fk_CHAMBRE_CODLOC foreign key (CODLOC)
      references LOCALISATION (CODLOC),
    constraint pk_CHAMBRE_NOCHAM primary key (NOCHAM));

--------------------------------------------------------------
--DEPART
--------------------------------------------------------------
--SEQUENCE RESET
DROP SEQUENCE SEQ_DEPART;
CREATE SEQUENCE SEQ_DEPART;
--CREATION
CREATE TABLE DEPART(
    "NODEPART" NUMBER(5,0),
    "IDRESER" NUMBER(5,0),
    "IDCLI" NUMBER(5,0),
    "NOCHAM" VARCHAR2(3 BYTE),
    "DATEDEPART" DATE,
    "CONFIRMEPAR" VARCHAR2(2 BYTE),
    constraint fk_DEPART_IDRESER foreign key (IDRESER)
      references RESERVATION (IDRESER),
    constraint fk_DEPART_IDCLI foreign key (IDCLI)
      references CLIENT (IDCLI),
    constraint fk_DEPART_NOCHAM foreign key (NOCHAM)
      references CHAMBRE (NOCHAM),
    constraint pk_DEPART_NODEPART primary key (NODEPART));
--INSERTION
--------------------------------------------------------------
--DE
--------------------------------------------------------------
--CREATION
CREATE TABLE DE (
    "IDRESER" NUMBER,
    "NOCHAM" VARCHAR2(3 BYTE),
    "ATTRIBUEE" NUMBER(*,0),
    constraint fk_DE_IDRESER foreign key (IDRESER)
      references RESERVATION (IDRESER),
    constraint fk_DE_NOCHAM foreign key (NOCHAM)
      references CHAMBRE (NOCHAM),
    constraint pk_DE_IDRESER_NOCHAM primary key (IDRESER, NOCHAM));
--INSERTION

--------------------------------------------------------------
--AYANT
--------------------------------------------------------------
--CREATION
CREATE TABLE AYANT(
    NOCHAM VARCHAR2(3),
    CODCOM VARCHAR2(2),
    constraint fk_AYANT_NOCHAM foreign key (NOCHAM)
      references CHAMBRE (NOCHAM),
    constraint fk_AYANT_CODCOM foreign key (CODCOM)
      references COMMODITE (CODCOM),
    constraint pk_AYANT_NOCHAM_CODCOM primary key (NOCHAM, CODCOM));


--------------------------------------------------------------
--TYPTRX
--------------------------------------------------------------
--CREATION
CREATE TABLE TYPTRX(
    "CODTYPTRX" VARCHAR2(2 BYTE),
    "DESCTRX" VARCHAR2(25 BYTE),
    "NATURETRX" VARCHAR2(2 BYTE),
    constraint pk_TYPTRX_CODTYPTRX primary key (CODTYPTRX));
---------------------------------------------
--TRX
--------------------------------------------------------------
--SEQUENCE RESET
DROP SEQUENCE SEQ_TRX;
CREATE SEQUENCE SEQ_TRX;
--CREATION
CREATE TABLE TRX (
    "IDTRX" NUMBER,
    "IDRESER" NUMBER,
    "IDCLI" NUMBER,
    "DATETRX" DATE,
    "MONTANTTRX" NUMBER(10,2),
    "CODTYPTRX" VARCHAR2(2 BYTE),
    "REPORTE" NUMBER(*,0),
    "NOFACT" NUMBER,
    "DATEFACT" DATE,
    "NOCHAM" VARCHAR2(3 BYTE),
    constraint fk_TRX_IDRESER foreign key (IDRESER)
      references RESERVATION (IDRESER),
    constraint fk_TRX_IDCLI foreign key (IDCLI)
      references CLIENT (IDCLI),
    constraint fk_TRX_CODTYPTRX foreign key (CODTYPTRX)
      references TYPTRX (CODTYPTRX),
    constraint fk_TRX_NOCHAM foreign key (NOCHAM)
      references CHAMBRE (NOCHAM),
    constraint pk_TRX_IDTRX primary key (IDTRX));
--INSERTION
--------------------------------------------------------------
--ARRIVE
--------------------------------------------------------------
--SEQUENCE RESET
DROP SEQUENCE SEQ_ARRIVE;
CREATE SEQUENCE SEQ_ARRIVE;
--CREATION
create table ARRIVE(
    "NOARRIVE" NUMBER,
    "IDRESER" NUMBER,
    "IDCLI" NUMBER,
    "NOCHAM" VARCHAR2(3 BYTE),
    "DATEARRIVE" DATE,
    constraint fk_ARRIVE_IDRESER foreign key (IDRESER)
        references RESERVATION (IDRESER),
    constraint fk_ARRIVE_IDCLI foreign key (IDCLI)
        references CLIENT (IDCLI),
    constraint fk_ARRIVE_NOCHAM foreign key (NOCHAM)
        references CHAMBRE (NOCHAM),
    constraint pk_ARRIVE_NOARRIVE primary key (NOARRIVE));
--INSERTION
-------------------------------------------------------------
--ACCESS GRANTING
--------------------------------------------------------------
GRANT ALL on RESERVATION to EQU03PRG02, EQU03PRG03;
GRANT ALL on CLIENT to EQU03PRG02, EQU03PRG03;
GRANT ALL on ARRIVE to EQU03PRG02, EQU03PRG03;
GRANT ALL on DE to EQU03PRG02, EQU03PRG03;
GRANT ALL on TRX to EQU03PRG02, EQU03PRG03;
GRANT ALL on TYPTRX to EQU03PRG02, EQU03PRG03;
GRANT ALL on COMMODITE to EQU03PRG02, EQU03PRG03;
GRANT ALL on AYANT to EQU03PRG02, EQU03PRG03;
GRANT ALL on TYPECHAM to EQU03PRG02, EQU03PRG03;
GRANT ALL on CHAMBRE to EQU03PRG02, EQU03PRG03;
GRANT ALL on LOCALISATION to EQU03PRG02, EQU03PRG03;
GRANT ALL on DEPART to EQU03PRG02, EQU03PRG03;

--------------------------------------------------------------
--COMMIT
--------------------------------------------------------------
COMMIT;

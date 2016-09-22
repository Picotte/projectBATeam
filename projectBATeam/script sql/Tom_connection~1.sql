
--------------------------------------------------------
--  DDL for Index CHAMBRE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."CHAMBRE_PK" ON "EQU03PRG01"."CHAMBRE" ("NOCHAM") 
  
--------------------------------------------------------
--  DDL for Index CLIENT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."CLIENT_PK" ON "EQU03PRG01"."CLIENT" ("IDCLI") 
 
--------------------------------------------------------
--  DDL for Index COMMODITE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."COMMODITE_PK" ON "EQU03PRG01"."COMMODITE" ("CODCOM") 
  
--------------------------------------------------------
--  DDL for Index DEPART_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."DEPART_PK" ON "EQU03PRG01"."DEPART" ("NODEPART") 
 
--------------------------------------------------------
--  DDL for Index LOCALISATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."LOCALISATION_PK" ON "EQU03PRG01"."LOCALISATION" ("CODLOC") 
  
--------------------------------------------------------
--  DDL for Index RESERVATION_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."RESERVATION_PK" ON "EQU03PRG01"."RESERVATION" ("IDRESER") 
 
--------------------------------------------------------
--  DDL for Index TRX_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."TRX_PK" ON "EQU03PRG01"."TRX" ("IDTRX") 

--------------------------------------------------------
--  DDL for Index TYPECHAM_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."TYPECHAM_PK" ON "EQU03PRG01"."TYPECHAM" ("CODTYPCHA") 

--------------------------------------------------------
--  DDL for Index TYPTRX_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "EQU03PRG01"."TYPTRX_PK" ON "EQU03PRG01"."TYPTRX" ("CODTYPTRX") 

--------------------------------------------------------
--  Constraints for Table AYANT
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."AYANT" MODIFY ("NOCHAM" NOT NULL ENABLE);
 
  ALTER TABLE "EQU03PRG01"."AYANT" MODIFY ("CODCOM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CHAMBRE
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."CHAMBRE" ADD CONSTRAINT "CHAMBRE_PK_NOCHAM" PRIMARY KEY ("NOCHAM")
  ALTER TABLE "EQU03PRG01"."CHAMBRE" MODIFY ("NOCHAM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table CLIENT
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."CLIENT" ADD CONSTRAINT "CLIENT_PK_IDCLI" PRIMARY KEY ("IDCLI")
  ALTER TABLE "EQU03PRG01"."CLIENT" MODIFY ("IDCLI" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table COMMODITE
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."COMMODITE" ADD CONSTRAINT "COMMODITE_PK_CODCOM" PRIMARY KEY ("CODCOM")
  ALTER TABLE "EQU03PRG01"."COMMODITE" MODIFY ("CODCOM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DE
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."DE" MODIFY ("IDRESER" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."DE" MODIFY ("NOCHAM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table DEPART
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."DEPART" ADD CONSTRAINT "DEPART_PK_NODEPART" PRIMARY KEY ("NODEPART")
  ALTER TABLE "EQU03PRG01"."DEPART" MODIFY ("NODEPART" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table LOCALISATION
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."LOCALISATION" ADD CONSTRAINT "LOCALISATION_PK_CODLOC" PRIMARY KEY ("CODLOC")
  ALTER TABLE "EQU03PRG01"."LOCALISATION" MODIFY ("CODLOC" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESERVATION
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."RESERVATION" ADD CONSTRAINT "RESERVATION_PK_IDRESER" PRIMARY KEY ("IDRESER")
  ALTER TABLE "EQU03PRG01"."RESERVATION" MODIFY ("IDCLI" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."RESERVATION" MODIFY ("DATERESER" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."RESERVATION" MODIFY ("DATEDEBUT" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."RESERVATION" MODIFY ("DATEFIN" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."RESERVATION" MODIFY ("IDRESER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRX
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."TRX" MODIFY ("IDTRX" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."TRX" ADD CONSTRAINT "TRX_PK_IDTRX" PRIMARY KEY ("IDTRX")
--------------------------------------------------------
--  Constraints for Table TYPECHAM
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."TYPECHAM" MODIFY ("CODTYPCHA" NOT NULL ENABLE);
 
  ALTER TABLE "EQU03PRG01"."TYPECHAM" ADD CONSTRAINT "TYPECHAM_PK_CODTYPCHA" PRIMARY KEY ("CODTYPCHA")
--------------------------------------------------------
--  Constraints for Table TYPTRX
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."TYPTRX" MODIFY ("CODTYPTRX" NOT NULL ENABLE);
  ALTER TABLE "EQU03PRG01"."TYPTRX" ADD CONSTRAINT "TYPTRX_PK_CODTYPTRX" PRIMARY KEY ("CODTYPTRX")
--------------------------------------------------------
--  Ref Constraints for Table AYANT
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."AYANT" ADD CONSTRAINT "AYANT_FK_CODCOM" FOREIGN KEY ("CODCOM")
	  REFERENCES "EQU03PRG01"."COMMODITE" ("CODCOM");
 
  ALTER TABLE "EQU03PRG01"."AYANT" ADD CONSTRAINT "AYANT_FK_NOCHAM" FOREIGN KEY ("NOCHAM")
	  REFERENCES "EQU03PRG01"."CHAMBRE" ("NOCHAM");
--------------------------------------------------------
--  Ref Constraints for Table CHAMBRE
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."CHAMBRE" ADD CONSTRAINT "CHAMBRE_FK_CODLOC" FOREIGN KEY ("CODLOC")
	  REFERENCES "EQU03PRG01"."LOCALISATION" ("CODLOC");
 
  ALTER TABLE "EQU03PRG01"."CHAMBRE" ADD CONSTRAINT "CHAMBRE_FK_CODTYPCHA" FOREIGN KEY ("CODTYPCHA")
	  REFERENCES "EQU03PRG01"."TYPECHAM" ("CODTYPCHA");
--------------------------------------------------------
--  Ref Constraints for Table DE
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."DE" ADD CONSTRAINT "DE_FK_IDRESER" FOREIGN KEY ("IDRESER")
	  REFERENCES "EQU03PRG01"."RESERVATION" ("IDRESER");
 
  ALTER TABLE "EQU03PRG01"."DE" ADD CONSTRAINT "DE_FK_NOCHAM" FOREIGN KEY ("NOCHAM")
	  REFERENCES "EQU03PRG01"."CHAMBRE" ("NOCHAM");
--------------------------------------------------------
--  Ref Constraints for Table DEPART
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."DEPART" ADD CONSTRAINT "DEPART_FK_IDCLI" FOREIGN KEY ("IDCLI")
	  REFERENCES "EQU03PRG01"."CLIENT" ("IDCLI");
 
  ALTER TABLE "EQU03PRG01"."DEPART" ADD CONSTRAINT "DEPART_FK_IDRESER" FOREIGN KEY ("IDRESER")
	  REFERENCES "EQU03PRG01"."RESERVATION" ("IDRESER");
 
  ALTER TABLE "EQU03PRG01"."DEPART" ADD CONSTRAINT "DEPART_FK_NOCHAM" FOREIGN KEY ("NOCHAM")
	  REFERENCES "EQU03PRG01"."CHAMBRE" ("NOCHAM");
--------------------------------------------------------
--  Ref Constraints for Table RESERVATION
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."RESERVATION" ADD CONSTRAINT "RESERVATION_FK_IDCLI" FOREIGN KEY ("IDCLI")
	  REFERENCES "EQU03PRG01"."CLIENT" ("IDCLI");
--------------------------------------------------------
--  Ref Constraints for Table TRX
--------------------------------------------------------

  ALTER TABLE "EQU03PRG01"."TRX" ADD CONSTRAINT "TRX_FK_CODTYPTRX" FOREIGN KEY ("CODTYPTRX")
	  REFERENCES "EQU03PRG01"."TYPTRX" ("CODTYPTRX");
 
  ALTER TABLE "EQU03PRG01"."TRX" ADD CONSTRAINT "TRX_FK_IDCLI" FOREIGN KEY ("IDCLI")
	  REFERENCES "EQU03PRG01"."CLIENT" ("IDCLI");
 
  ALTER TABLE "EQU03PRG01"."TRX" ADD CONSTRAINT "TRX_FK_IDRESER" FOREIGN KEY ("IDRESER")
	  REFERENCES "EQU03PRG01"."RESERVATION" ("IDRESER");
--------------------------------------------------------
--  DDL for Trigger CLIENT_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EQU03PRG01"."CLIENT_TRG" 
BEFORE INSERT ON CLIENT 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDCLI IS NULL THEN
      SELECT CLIENT_SEQ.NEXTVAL INTO :NEW.IDCLI FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EQU03PRG01"."CLIENT_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger RESERVATION_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EQU03PRG01"."RESERVATION_TRG" 
BEFORE INSERT ON RESERVATION 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDRESER IS NULL THEN
      SELECT RESERVATION_SEQ.NEXTVAL INTO :NEW.IDRESER FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EQU03PRG01"."RESERVATION_TRG" ENABLE;
--------------------------------------------------------
--  DDL for Trigger TRX_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "EQU03PRG01"."TRX_TRG" 
BEFORE INSERT ON TRX 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.IDTRX IS NULL THEN
      SELECT TRX_SEQ.NEXTVAL INTO :NEW.IDTRX FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "EQU03PRG01"."TRX_TRG" ENABLE;

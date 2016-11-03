


DELETE EQU03PRG01.CLIENT;

INSERT INTO EQU03PRG01.CLIENT VALUES (SEQ_CLIENT.NEXTVAL, 'Benjamin Couvrette', '155 4e Ave Grand-Mère', '8198528484', '8888888888887777', 'Visa', '08/04/19', '8198528485', 149.95);
INSERT INTO EQU03PRG01.CLIENT VALUES (SEQ_CLIENT.NEXTVAL, 'Tommy Houle', '1557 6e Ave Grand-Mere', '8198524031', '8888888888888888', 'MasterCard', '08/03/19', '8198524032', 125.32);
INSERT INTO EQU03PRG01.CLIENT VALUES (SEQ_CLIENT.NEXTVAL, 'Alexandre Picotte', '57 2e Ave Grand-Mere', '8198529997', '8888888888886666', 'StudentCard', '06/08/21', '8198529998', 2.00);

DELETE EQU03PRG01.TYPTRX;

INSERT INTO EQU03PRG01.TYPTRX VALUES ('01', 'Prix De La Chambre', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('02', 'Lit Additionnel', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('10', 'Telephone Interrurbain', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('21', 'Photocopie', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('22', 'Internet', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('30', 'Restaurant', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('31', 'Bar Terrasse', 'DB');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('50', 'Depot Argent', 'CR');
INSERT INTO EQU03PRG01.TYPTRX VALUES ('60', 'Paiment', 'CR');

DELETE EQU03PRG01.COMMODITE;

INSERT INTO EQU03PRG01.COMMODITE VALUES ('AS', 'Standards rien de special');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('BA', 'Avec balcon');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('BT', 'Avec bain tourbillon');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('CC', 'Chambre communicante');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('IN', 'Internet');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('MB', 'Mini bar');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('HP', 'Handicape');
INSERT INTO EQU03PRG01.COMMODITE VALUES ('NF', 'Non fumeur');

DELETE EQU03PRG01.TYPECHAM;

INSERT INTO EQU03PRG01.TYPECHAM VALUES ('1J','1 lit jumeau', 80);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('2J','2 lits jumeaux', 60);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('1D','1 lit double', 45);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('2D','2 lits doubles', 40);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('LQ','Lit queen', 30);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('LK','Lit king', 35);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('ST','Suite', 20);
INSERT INTO EQU03PRG01.TYPECHAM VALUES ('SR','Sale reception', 5);

DELETE EQU03PRG01.LOCALISATION;

INSERT INTO EQU03PRG01.LOCALISATION VALUES ('AR', 'ARRIERE');
INSERT INTO EQU03PRG01.LOCALISATION VALUES ('AS', 'PRES DE L ASCENCEUR');
INSERT INTO EQU03PRG01.LOCALISATION VALUES ('AV', 'AVANT');
INSERT INTO EQU03PRG01.LOCALISATION VALUES ('VM', 'VUE SUR LA MERE');
INSERT INTO EQU03PRG01.LOCALISATION VALUES ('SM', 'PRES DE LA SALLE A MANGER');

DELETE EQU03PRG01.RESERVATION;

INSERT INTO EQU03PRG01.RESERVATION VALUES (SEQ_RESERVATION.NEXTVAL, 1, '01/01/17', '01/01/17', '14/01/17');
INSERT INTO EQU03PRG01.RESERVATION VALUES (SEQ_RESERVATION.NEXTVAL, 1, '01/01/17', '02/01/17', '14/02/17');
INSERT INTO EQU03PRG01.RESERVATION VALUES (SEQ_RESERVATION.NEXTVAL, 1, '01/01/17', '03/01/17', '14/03/17');

DELETE EQU03PRG01.CHAMBRE;

INSERT INTO EQU03PRG01.CHAMBRE VALUES ('001','00', 60.95, 0, 'SR', 'SM', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('002','00', 60.95, 0, '1J', 'AR', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('003','00', 60.95, 0, '1J', 'AS', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('004','00', 60.95, 0, '1J', 'AS', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('005','00', 60.95, 0, '1J', 'AR', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('006','00', 60.95, 0, '1J', 'AV', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('007','00', 60.95, 0, '1J', 'AV', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('008','00', 60.95, 0, '1J', 'AV', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('009','00', 60.95, 0, '1J', 'AV', 'mediocre');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('101','01', 90.95, 0, '2J', 'AR', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('102','01', 90.95, 0, '2J', 'AR', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('103','01', 90.95, 0, '2J', 'AS', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('104','01', 90.95, 0, '2J', 'AS', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('105','01', 90.95, 0, '2J', 'AR', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('106','01', 90.95, 0, '2J', 'AV', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('107','01', 90.95, 0, '2J', 'AV', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('108','01', 90.95, 0, '2J', 'AV', 'pas belle');
INSERT INTO EQU03PRG01.CHAMBRE VALUES ('109','01', 90.95, 0, '2J', 'AV', 'pas belle');

DELETE EQU03PRG01.DE;

INSERT INTO EQU03PRG01.DE VALUES (1, '001', 1);
INSERT INTO EQU03PRG01.DE VALUES (1, '002', 1);
INSERT INTO EQU03PRG01.DE VALUES (1, '003', 0);

INSERT INTO EQU03PRG01.DE VALUES (2, '004', 1);
INSERT INTO EQU03PRG01.DE VALUES (2, '005', 0);

INSERT INTO EQU03PRG01.DE VALUES (3, '006', 0);


DELETE EQU03PRG01.ARRIVE;

INSERT INTO EQU03PRG01.ARRIVE VALUES (SEQ_ARRIVE.NEXTVAL, 1, 1, '001', '01/01/17');
INSERT INTO EQU03PRG01.ARRIVE VALUES (SEQ_ARRIVE.NEXTVAL, 1, 2, '002', '01/01/17');
INSERT INTO EQU03PRG01.ARRIVE VALUES (SEQ_ARRIVE.NEXTVAL, 2, 3, '004', '01/01/17');

DELETE EQU03PRG01.AYANT;

INSERT INTO EQU03PRG01.AYANT VALUES ('001', 'MB');
INSERT INTO EQU03PRG01.AYANT VALUES ('001', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('002', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('003', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('004', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('005', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('006', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('007', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('008', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('009', 'AS');
INSERT INTO EQU03PRG01.AYANT VALUES ('101', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('102', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('103', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('104', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('105', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('106', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('107', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('108', 'BA');
INSERT INTO EQU03PRG01.AYANT VALUES ('109', 'BA');

DELETE EQU03PRG01.DEPART;

INSERT INTO EQU03PRG01.DEPART VALUES (SEQ_DEPART.NEXTVAL, 1, 1, '001', '2017/01/01', 'AS');


COMMIT;
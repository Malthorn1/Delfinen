DROP TABLE if exists DISCIPLIN;
DROP TABLE if exists MEDLEM_DISCIPLIN;
DROP TABLE if exists MEDLEMMER;
DROP TABLE if exists TRÆNER;


CREATE TABLE TRÆNER (
	træner_ID INTEGER not null,
	træner_navn VARCHAR(30),
    primary key (træner_ID)
);


insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10001);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10002);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10003);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10004);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10005);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10006);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10007);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10008);
insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10009);


CREATE TABLE MEDLEMMER (  
	NAVN VARCHAR(30),
    ALDER INTEGER not null,
    TELEFONNUMMER INTEGER not null,
    MEDLEMSNUMMER INTEGER not null AUTO_INCREMENT,
    DATOOPRETTET TIMESTAMP,
    RESTANCE TINYINT,
    KONKURRENCESVØMMER TINYINT,
    træner_ID INTEGER,
    PRIMARY KEY (MEDLEMSNUMMER),
    FOREIGN KEY (træner_ID) REFERENCES TRÆNER(træner_ID)
);

insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER)  values ("Robert", 57, 55555555, 1, now(), 1, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER)  values ("Rasmus", 17, 12151212, 0, now(), 1, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER)  values ("Kasper", 20, 18171981, 0, now(), 0, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER)  values ("Casper", 17, 30205145, 0, now(), 0, 1);



CREATE TABLE DISCIPLIN (
	disciplin_navn varchar(15),
    disciplinID INT NOT NULL
);

insert INTO DISCIPLIN (disciplin_navn, disciplinID) values ("Crawl", 1);
insert INTO DISCIPLIN (disciplin_navn, disciplinID) values ("Rygcrawl", 2);
insert INTO DISCIPLIN (disciplin_navn, disciplinID) values ("Brystsvømning", 3);
insert INTO DISCIPLIN (disciplin_navn, disciplinID) values ("Butterfly", 4);

CREATE TABLE MEDLEM_DISCIPLIN (
bedstetid int,
MEDLEMSNUMMER int,
DISCIPLIN VARCHAR(30),
disciplinID int,
FOREIGN KEY (MEDLEMSNUMMER) REFERENCES MEDLEMMER(MEDLEMSNUMMER)
);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (30, 1,"Butterfly", 4);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (50, 3,"Brystsvømning", 3);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (20, 2,"Brystsvømning", 3);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (30, 1,"Crawl", 1);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (25, 1,"Brystsvømning", 3);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (99, 1,"Brystsvømning", 3);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (26, 1,"Brystsvømning", 3);
insert INTO MEDLEM_DISCIPLIN (bedstetid, MEDLEMSNUMMER, DISCIPLIN, disciplinID) values (25, 1,"Brystsvømning", 3);





commit;

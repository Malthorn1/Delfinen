DROP TABLE if exists DISCIPLIN;
DROP TABLE if exists MEDLEM_DISCIPLIN;
DROP TABLE if exists MEDLEMMER;
DROP TABLE if exists TRÆNER;


CREATE TABLE TRÆNER (
	træner_ID INTEGER not null AUTO_INCREMENT,
	træner_navn VARCHAR(30),
    primary key (træner_ID)
);

ALTER TABLE TRÆNER AUTO_INCREMENT = 1000;
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");
insert into TRÆNER (træner_navn) values ("Robert Junor");


CREATE TABLE MEDLEMMER (  
	NAVN VARCHAR(30),
    ALDER INTEGER not null,
    TELEFONNUMMER INTEGER not null,
    MEDLEMSNUMMER INTEGER not null AUTO_INCREMENT,
    DATOOPRETTET TIMESTAMP,
    MEDLEMSKAB TINYINT,
    KONKURRENCESVØMMER TINYINT,
    træner_ID INTEGER,
    PRIMARY KEY (MEDLEMSNUMMER),
    FOREIGN KEY (træner_ID) REFERENCES TRÆNER(træner_ID)
);

insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, MEDLEMSKAB, KONKURRENCESVØMMER)  values ("Robert", 57, 55555555, 1, now(), 1, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, MEDLEMSKAB, KONKURRENCESVØMMER)  values ("Rasmus", 17, 12151212, 0, now(), 1, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, MEDLEMSKAB, KONKURRENCESVØMMER)  values ("Kasper", 20, 18171981, 0, now(), 0, 1);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, MEDLEMSKAB, KONKURRENCESVØMMER)  values ("Casper", 17, 30205145, 0, now(), 0, 1);



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

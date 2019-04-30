DROP TABLE if exists DISCIPLIN;
DROP TABLE if exists MEDLEM_DISCIPLIN;
DROP TABLE if exists TRÆNER;
DROP TABLE if exists MEDLEMMER;


CREATE TABLE MEDLEMMER (  
	NAVN VARCHAR(30),
    ALDER INTEGER not null,
    TELEFONNUMMER INTEGER not null,
    MEDLEMSNUMMER INTEGER not null AUTO_INCREMENT,
    DATOOPRETTET TIMESTAMP,
    MEDLEMSKAB TINYINT,
    KONKURRENCESVØMMER TINYINT,
    PRIMARY KEY (MEDLEMSNUMMER)
);

insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, MEDLEMSKAB, KONKURRENCESVØMMER)
values ("Robert", 57, 55555555, 1, now(), 1, 1);

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
DISCIPLIN int,
disciplinID int,
FOREIGN KEY (MEDLEMSNUMMER) REFERENCES MEDLEMMER(MEDLEMSNUMMER)
);



commit;

DROP TABLE if exists DISCIPLIN;
DROP TABLE if exists MEDLEM_DISCIPLIN;
DROP TABLE if exists MEDLEMMER;


CREATE TABLE MEDLEMMER (  
	NAVN VARCHAR(30),
    ALDER INTEGER not null,
    TELEFONNUMMER INTEGER not null,
    MEDLEMSNUMMER INTEGER not null AUTO_INCREMENT,
    DATOOPRETTET TIMESTAMP,
    BETALT TINYINT,
    KONKURRENCESVØMMER TINYINT,
    TRÆNER VARCHAR(30),
    PRIMARY KEY (MEDLEMSNUMMER)
);

insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, BETALT, KONKURRENCESVØMMER, TRÆNER)
values ("Robert", 57, 55555555, 1, now(), 1, 1, "Hans Erik");


CREATE TABLE DISCIPLIN (
	navn varchar(15),
    disciplinID INT NOT NULL
);

insert INTO DISCIPLIN (navn, disciplinID) values ("Crawl", 1);
insert INTO DISCIPLIN (navn, disciplinID) values ("Rygcrawl", 2);
insert INTO DISCIPLIN (navn, disciplinID) values ("Brystsvømning", 3);
insert INTO DISCIPLIN (navn, disciplinID) values ("Butterfly", 4);

CREATE TABLE MEDLEM_DISCIPLIN (
bedstetid int,
MEDLEMSNUMMER int,
DISCIPLIN int,
disciplinID int,
FOREIGN KEY (MEDLEMSNUMMER) REFERENCES MEDLEMMER(MEDLEMSNUMMER)
);



commit;

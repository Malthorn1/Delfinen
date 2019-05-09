insert into TRÆNER (træner_navn, træner_ID) values ("Robert Junor", 10001);
insert into TRÆNER (træner_navn, træner_ID) values ("Rasmus Larsen", 10002);
insert into TRÆNER (træner_navn, træner_ID) values ("Mads Christensen", 10003);
insert into TRÆNER (træner_navn, træner_ID) values ("Kasper Larsen", 10004);
insert into TRÆNER (træner_navn, træner_ID) values ("Ole Madsen", 10005);

insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Robert", 57, 55555555, 1, now(), 1, 1, 0, 10001);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Rasmus", 17, 12151212, 0, now(), 1, 1, 1, 10003);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Kasper", 20, 18171981, 0, now(), 0, 0, 0, null);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Casper", 17, 30205145, 0, now(), 0, 0, 1, null);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Jonathan", 17, 30205145, 0, now(), 0, 0, 1, null);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Tina", 25, 77664455, 0, now(), 0, 0, 0, null);
insert into MEDLEMMER (navn, alder, TELEFONNUMMER, MEDLEMSNUMMER, DATOOPRETTET, RESTANCE, KONKURRENCESVØMMER, passiv, træner_ID)  values ("Mikkel", 27, 34536543, 0, now(), 0, 0, 0, null);

insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (35, 1,"Butterfly");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (30, 2,"Butterfly");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (25, 3,"Butterfly");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (50, 4,"Butterfly");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (130, 5,"Butterfly");

insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (35, 1,"Crawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (32, 2,"Crawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (37, 3,"Crawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (15, 4,"Crawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (25, 5,"Crawl");

insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (35, 1,"Rygcrawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (45, 2,"Rygcrawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (50, 3,"Rygcrawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (24, 4,"Rygcrawl");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (52, 5,"Rygcrawl");

insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (33, 1,"Bryst");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (43, 2,"Bryst");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (45, 3,"Bryst");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (19, 4,"Bryst");
insert INTO MEDLEM_DISCIPLIN (tid, MEDLEMSNUMMER, DISCIPLIN) values (59, 5,"Bryst");

CREATE TABLE alapanyag_tipus (
    nev text,
    mertekegyseg text,
    CONSTRAINT alapanyag_tipus_pk PRIMARY KEY (nev)
);

CREATE TABLE recept (
    recept_id SERIAL,
    nev text,
    leiras text,
    CONSTRAINT recept_pk PRIMARY KEY (recept_id)
);

CREATE TABLE recept_alapanyag (
    recept_alapanyag_id SERIAL,
    recept_id integer NOT NULL REFERENCES recept (recept_id),
    alapanyag_tipus_nev text NOT NULL REFERENCES alapanyag_tipus (nev),
    alapanyag_mennyiseg integer not null,
    CONSTRAINT recept_alapanyag_pk PRIMARY KEY (recept_alapanyag_id)
);

/** Alapanyagok felvitele **/
INSERT INTO alapanyag_tipus VALUES ('tej','ml');
INSERT INTO alapanyag_tipus VALUES ('liszt','gram');
INSERT INTO alapanyag_tipus VALUES ('viz','ml');
INSERT INTO alapanyag_tipus VALUES ('cukor','gram');

/** Receptek felvitele - alapanyag nélkül**/
INSERT INTO recept (nev,leiras) VALUES ('Süti','Valami leiras');
INSERT INTO recept (nev,leiras) VALUES ('Főétel','Ez valami főétel lesz');

/** Alapanyagok hozzáadása a recepthez **/

INSERT INTO recept_alapanyag (recept_id,alapanyag_tipus_nev,alapanyag_mennyiseg) VALUES (1,'tej',250); /** Azaz az 1-es recepthez kell 250 ml tej **/
INSERT INTO recept_alapanyag (recept_id,alapanyag_tipus_nev,alapanyag_mennyiseg) VALUES (2,'viz',1000); /** Azaz az 2-es recepthez kell 1000 ml viz **/
INSERT INTO recept_alapanyag (recept_id,alapanyag_tipus_nev,alapanyag_mennyiseg) VALUES (2,'cukor',100); /** Azaz az 2-es recepthez kell 100 gramm cukor **/

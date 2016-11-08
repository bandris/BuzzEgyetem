drop table library_book;
drop table library;

CREATE TABLE library (
    library_id SERIAL,
    library_name text NOT NULL UNIQUE,
    library_postcode integer CHECK (library_postcode > 1000),
    CONSTRAINT library_pk PRIMARY KEY (library_id)
);

CREATE TABLE library_book (
    library_book_id SERIAL,
    ean text CHECK (ean LIKE '978%' AND length(ean) = 13),
    library_id integer NOT NULL REFERENCES library (library_id),
    title text NOT NULL,
    author text NOT NULL,
    page_number integer CHECK (page_number > 0),
    CONSTRAINT library_book_pk PRIMARY KEY (library_book_id)
);


INSERT INTO library(library_name,library_postcode) VALUES ('Széchenyi',7625);
INSERT INTO library(library_name,library_postcode) VALUES ('Petőfi',4513);

INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780751544749',1,'The Book Thief','Zusak',560);
INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780751544749',2,'The Book Thief','Zusak',560);
INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780575400160',1,'Billie Holiday','Nicholson',320);
INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780241023198',2,'In the country','Allsop',212);
INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780241023198',2,'Hideous Kinky','Freud',192);
INSERT INTO library_book(ean,library_id,title,author,page_number) VALUES ('9780747597704',1,'Mr Mac and Me','Freud',304);

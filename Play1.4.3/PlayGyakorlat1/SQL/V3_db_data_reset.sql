DELETE FROM library_book;
DELETE FROM library;

ALTER TABLE library_book DROP CONSTRAINT library_book_ean_check;
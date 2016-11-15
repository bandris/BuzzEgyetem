ALTER TABLE library_book ADD COLUMN is_raktaron BOOLEAN DEFAULT false;

/**
 * 1es és 5ös ID berakjuk true-ra
 */
update library_book SET is_raktaron = TRUE where library_book_id IN (1,5); 
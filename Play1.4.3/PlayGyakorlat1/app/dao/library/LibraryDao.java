package dao.library;

import models.Library;
import models.LibraryBook;

/**
 * Mivel már máshol is volt teljes könyvát törlés, ezért létrehoztam ezt az osztályt, így nem
 * duplikálódik a kódunk
 * @author janoszsolt
 *
 */
public class LibraryDao {

	public void deleteLibrary(Library library){
		if (library != null){
			for (LibraryBook book : library.books){
				book.delete();
			}
			library.delete();
		}
	}
}

package controllers.library;

import dao.library.LibraryDao;
import models.Library;
import play.mvc.Controller;

public class LibraryDeleteController extends Controller {

	public static void deleteLibrary(Long libraryId){
		String errorMessage = null;
		if (libraryId != null){
			Library library = Library.findById(libraryId);
			if (library != null){
				LibraryDao dao = new LibraryDao();
				dao.deleteLibrary(library);
			} else {
				errorMessage = "A törlendő könyvtár nem létezik!";
			}
		} else {
			errorMessage = "Üres könyvtárazonosító!";
		}
		
		if (errorMessage != null){
			flash.put("errorMessage", errorMessage);
		}
		
		LibraryController.libraryBooks(null);
	}
}

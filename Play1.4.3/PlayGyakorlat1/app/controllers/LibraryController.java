package controllers;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import models.Library;
import models.LibraryBook;
import play.mvc.Controller;

public class LibraryController extends Controller {
	
	/**
	 * Logolás - log4j frameworkkel
	 * Configban:
	 * 
	 * 
	 	application.log=DEBUG
		application.log.path=/log4j.properties
		application.log.system.out=off
		
	 */
	private static final Logger LOGGER = Logger.getLogger(LibraryController.class);

	public static void libraryBooks(Long libraryId){
		List<Library> libraries;
		
		if (libraryId == null){
			libraries = Library.findAll();
		} else {
			//libraries = Library.find(" libraryId = ? ", libraryId).fetch();
			
			/*
			 * Elsődleges kulcsra a findById alapján keresünk
			 */
						
			libraries = new ArrayList<Library>(); 
			
			Library library = Library.findById(libraryId);
			if (library != null){ //ha nem null, akkor megtalálta. Ha nincs ilyen rekord, akkor null
				libraries.add(library);
			}
		}
		
		for (Library library : libraries){ //erre nincs szükségünk most, de írjuk csak ki, hogy mi van itt.
			LOGGER.debug("Library processing: " + library.libraryId + " - " + library.libraryName);
			LOGGER.debug("Library has " + library.books.size() + " books");
			for (LibraryBook book : library.books){
				if (!book.isRaktaron){
					LOGGER.debug("Library has " + book.ean + " book out of stock");
				}
			}
		}
		
		renderArgs.put("libraries",libraries);
		render("@Application.libraryBooks");
	}
	
}

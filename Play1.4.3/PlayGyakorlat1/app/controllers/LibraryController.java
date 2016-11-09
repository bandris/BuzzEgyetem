package controllers;

import java.util.List;

import org.apache.log4j.Logger;

import models.Library;
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
			libraries = Library.find(" libraryId = ? ", libraryId).fetch();
		}
		
		for (Library library : libraries){ //erre nincs szükségünk most, de írjuk csak ki, hogy mi van itt.
			LOGGER.debug("Library processing: " + library.libraryId + " - " + library.libraryName);
			LOGGER.debug("Library has " + library.books.size() + " books");
		}
		
		renderArgs.put("libraries",libraries);
		render("@Application.libraryBooks");
	}
	
}

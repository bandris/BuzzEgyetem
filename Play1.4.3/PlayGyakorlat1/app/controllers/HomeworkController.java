package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import play.mvc.Controller;

public class HomeworkController extends Controller{
	
	/**
	 * Fontos 1: ha static final (azaz konstans a változó), akkor az elnevezési konvenció: csupa nagy betű
	 * 
	 * Fontos 2: https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
	 * 
	 * Javadoc sokszor segít és rengeteget lehet tanulni belőle :)
	 * 
	 */
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy HH:mm");

	public static void homework1(String s1, String s2){
		renderArgs.put("concatString", s1+s2);
		renderArgs.put("dateToOutput", DATE_FORMAT.format(new Date()));
		render("@Application.homework1");
	}

}

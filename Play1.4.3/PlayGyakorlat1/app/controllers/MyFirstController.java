package controllers;

import java.util.Random;

import play.mvc.Controller;

public class MyFirstController extends Controller{

	public static void controllerExercise(){
		Random random = new Random();
		renderArgs.put("randomValue", random.nextInt(100));
		render("@Application.myfirstview");
	}
	
	public static void controllerExerciseAddition(Integer a,Integer b){
		renderArgs.put("randomValue", a+b);
		render("@Application.myfirstview");
	}
}

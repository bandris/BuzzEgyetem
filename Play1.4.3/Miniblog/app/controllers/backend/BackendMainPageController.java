package controllers.backend;

import controllers.Secure;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class BackendMainPageController extends Controller{

	public static void index() {
		render("@Backend.index");
	}

}

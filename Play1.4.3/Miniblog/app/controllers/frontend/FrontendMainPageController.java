package controllers.frontend;

import play.mvc.Controller;

public class FrontendMainPageController extends Controller{

	public static void index() {
        render("@Frontend.index");
    }
}

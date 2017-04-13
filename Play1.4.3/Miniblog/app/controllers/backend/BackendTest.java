package controllers.backend;

import controllers.Secure;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class BackendTest extends Controller{

	public static void test() {
		renderText("asdasd");
	}

}

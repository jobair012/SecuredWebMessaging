package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LandingController {

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView showLandingPage() {

		ModelAndView model = new ModelAndView("landingPage");

		return model;
	}
}

package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.KeysServices;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private KeysServices keyService;

	/** * * * * SHOW USER KEYS * * * * **/
	@RequestMapping(value = "/keys", method = RequestMethod.GET)
	public ModelAndView showKeys(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("keysPage");

		model.addObject("keys", keyService.getKeys(request.getUserPrincipal().getName()));

		return model;
	}

}

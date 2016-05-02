package team.rj.swms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import team.rj.swms.cryptographicServices.KeyGeneration;
import team.rj.swms.dao.UserDAO;
import team.rj.swms.dao.UserKeysDAO;
import team.rj.swms.domain.User;
import team.rj.swms.domain.UserKeys;

@Controller
@RequestMapping(value = "/")
public class AccountController {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private UserKeysDAO userKeysDAO;

	/* * * * * * SHOW LANDING PAGE * * * * * */

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showLandingPage() {

		ModelAndView model = new ModelAndView("landingPage");

		return model;
	}

	/* * * * * * SHOW LOGIN PAGE * * * * * */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {

		ModelAndView model = new ModelAndView("landingPage");

		if (error != null) {

			model.addObject("error", "Invalid username and password!");
		}

		return model;
	}

	/* * * * * * SHOW SIGNUP PAGE * * * * * */

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView showSignupPage() {

		ModelAndView model = new ModelAndView("signupPage");

		User user = new User();

		model.addObject("user", user);

		return model;
	}

	/* * * * * * SHOW TERMS AND CONDITION PAGE * * * * * */

	@RequestMapping(value = "/tandc", method = RequestMethod.GET)
	public ModelAndView showTandC() {

		ModelAndView model = new ModelAndView("tandcPage");

		return model;
	}

	/* * * * * * REGISTER A NEW USER * * * * * */

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView saveUser(@ModelAttribute("user") User user) {

		userDAO.saveUser(user);

		KeyGeneration keys = new KeyGeneration();

		UserKeys userKeys = new UserKeys(keys.getN().toString(), keys.getE().toString(), keys.getD().toString(),
				user.getUsername());

		userKeysDAO.saveKeys(userKeys);

		return new ModelAndView("redirect:/");
	}

}

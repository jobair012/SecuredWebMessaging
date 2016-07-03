package controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.UserKeys;
import model.Users;
import service.AccountServices;
import service.cryptographic.KeyGeneration;

@Controller
public class AccountController {

	@Autowired
	private AccountServices accountService;

	/* * * * * * SHOW REGISTRATION PAGE * * * * * */

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView showSignupPage() {

		ModelAndView model = new ModelAndView("registrationPage");

		model.addObject("user", new Users());

		List<String> genderList = new ArrayList<String>();
		genderList.add("male");
		genderList.add("female");

		model.addObject("genders", genderList);

		return model;
	}

	/* * * * * * SHOW TERMS AND CONDITION PAGE * * * * * */

	@RequestMapping(value = "/tandc", method = RequestMethod.GET)
	public ModelAndView showTandC() {

		ModelAndView model = new ModelAndView("tandcPage");

		return model;
	}

	/* * * * * * DO REGISTER * * * * * */

	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public ModelAndView doRegister(@Valid @ModelAttribute("user") Users user, BindingResult result) {

		if (result.hasErrors()) {

			ModelAndView model = new ModelAndView("registrationPage");

			List<String> genderList = new ArrayList<String>();
			genderList.add("male");
			genderList.add("female");

			model.addObject("genders", genderList);

			return model;
		}

		KeyGeneration keys = new KeyGeneration();
		UserKeys userKeys = new UserKeys();

		userKeys.setUsername(user.getUsername());
		userKeys.setKey_N(keys.getN().toString());
		userKeys.setKey_E(keys.getE().toString());
		userKeys.setKey_D(keys.getD().toString());

		user.setEnabled(true);
		user.setRole("ROLE_USER");

		try {
			accountService.registerUser(user, userKeys);
		}

		catch (DuplicateKeyException exception) {

			result.rejectValue("username", "duplicateUsername", "Username already exists");

			ModelAndView model = new ModelAndView("registrationPage");

			List<String> genderList = new ArrayList<String>();
			genderList.add("male");
			genderList.add("female");

			model.addObject("genders", genderList);

			return model;
		}
		
		return new ModelAndView("landingPage");
	}
}

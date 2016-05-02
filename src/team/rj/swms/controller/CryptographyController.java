package team.rj.swms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.rj.swms.dao.UserKeysDAO;

@Controller
@RequestMapping(value = "home/keys")
public class CryptographyController {

	@Autowired
	private UserKeysDAO userKeysDAO;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView ShowKeyPage() {

		ModelAndView model = new ModelAndView("keysPage");

		return model;
	}

	/* * * * * * SHOW GENERATED KEYS FOR REGISTERED USER * * * * * */
	
	@RequestMapping(value = "showKeys", method = RequestMethod.GET)
	public ModelAndView showKeys(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("showKeysPage");

		String username = request.getUserPrincipal().getName();

		model.addObject("userKeys", userKeysDAO.getKeysOfParticularUser(username));

		return model;
	}

}

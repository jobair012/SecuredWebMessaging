package controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import service.MessageServices;

@Controller
@RequestMapping("home/sent")
public class SentItemController {

	@Autowired
	private MessageServices messageServices;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showSentItems(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("sentItemsPage");

		model.addObject("messages", messageServices.getAllSentMessages(request.getUserPrincipal().getName()));

		return model;
	};
	
	
	@RequestMapping(value = "/viewSentItemsDetails", method = RequestMethod.GET)
	public ModelAndView showDetailsOfParticularSentItems(HttpServletRequest request){
		
		ModelAndView model = new ModelAndView("detailOfSentItemsPage");
		
		int id = Integer.parseInt(request.getParameter("mid"));
		String receiver = request.getParameter("receiver");
		String sender = request.getUserPrincipal().getName();
		
		model.addObject("message", messageServices.getSentMessage(id, sender, receiver));
		
		return model;
	}
}

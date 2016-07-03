package controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Messages;
import model.UserKeys;
import service.KeysServices;
import service.MessageServices;
import service.cryptographic.Decryption;

@Controller
@RequestMapping("home/inbox")
public class InboxController {

	@Autowired
	private MessageServices messageServices;
	
	@Autowired
	private KeysServices keysServices;

	/** * * * * SHOW INBOX * * * * **/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showInbox(HttpServletRequest request, HttpServletResponse response) {

		response.setIntHeader("refresh", 10);

		ModelAndView model = new ModelAndView("inboxPage");

		String username = request.getUserPrincipal().getName();

		model.addObject("messages", messageServices.getAllMessages(username));

		return model;
	}

	/* * * * * * SHOW A PARTICULAR MESSAGE * * * * * */
	@RequestMapping(value = "/viewDetails", method = RequestMethod.GET)
	public ModelAndView showParticularMessage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("detailMessagePage");

		int id = Integer.parseInt(request.getParameter("mid"));
		String sender = request.getParameter("from");
		String receiver = request.getUserPrincipal().getName();

		model.addObject("message", messageServices.getMessage(id, sender, receiver));

		return model;
	}

	/* * * * * * VIEW DECRYPTED MESSAGE * * * * * */
	@RequestMapping(value = "/decryptMessage", method = RequestMethod.POST)
	public ModelAndView showDecryptedMessage(@ModelAttribute("message") Messages message, HttpServletRequest request) {

		ModelAndView model = new ModelAndView("decryptedMessagePage");

		UserKeys receiverKeys = keysServices.getKeys(request.getUserPrincipal().getName());
		UserKeys senderKeys = keysServices.getKeys(message.getSender());

		// Receiver's private key
		BigInteger receiver_d = new BigInteger(receiverKeys.getKey_D());
		BigInteger receiver_n = new BigInteger(receiverKeys.getKey_N());

		// Sender's public key
		BigInteger sender_e = new BigInteger(senderKeys.getKey_E());
		BigInteger sender_n = new BigInteger(senderKeys.getKey_N());

		Decryption decrypt = new Decryption(receiver_d, receiver_n, sender_e, sender_n);

		String[] plaintext = decrypt.getPlaintext(message.getMessage());

		if (plaintext[0].hashCode() == Integer.parseInt(plaintext[1])) {

			model.addObject("intigrityCheckMessage", true);
		} else {

			model.addObject("intigrityCheckMessage", false);
		}

		model.addObject("plaintext", plaintext[0]);

		return model;
	}
}

package controller;

import java.math.BigInteger;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

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
import service.cryptographic.Encryption;

@Controller
@RequestMapping("home/compose")
public class ComposeController {

	@Autowired
	private KeysServices keysServices;

	@Autowired
	private MessageServices messageServices;

	/** * * * * SHOW COMPOSE PAGE * * * * **/
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ModelAndView showCompose() {

		ModelAndView model = new ModelAndView("composePage");

		model.addObject("message", new Messages());

		return model;
	}

	/** * * * * SAVING A NEW MESSAGE * * * * **/
	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public ModelAndView pushMessage(@ModelAttribute("message") Messages message, HttpServletRequest request) {

		UserKeys senderKeys = keysServices.getKeys(request.getUserPrincipal().getName());
		UserKeys receiverKeys = keysServices.getKeys(message.getReceiver());

		// Sender's private key
		BigInteger sender_d = new BigInteger(senderKeys.getKey_D());
		BigInteger sender_n = new BigInteger(senderKeys.getKey_N());

		// Receiver's public key
		BigInteger receiver_e = new BigInteger(receiverKeys.getKey_E());
		BigInteger receiver_n = new BigInteger(receiverKeys.getKey_N());

		Messages plainMessage = new Messages(0, message.getSubject(), message.getMessage(), new Date().toString(),
				false, request.getUserPrincipal().getName(), message.getReceiver());

		Encryption encrypt = new Encryption(sender_d, sender_n, receiver_e, receiver_n);

		String ciphertext = encrypt.getCiphertext(message.getMessage());

		message.settime(new Date().toString());
		message.setMessage(ciphertext);

		if (request.getParameter("submission").equals("Encrypt")) {

			ModelAndView model = new ModelAndView("encryptedMessagePage");

			model.addObject("message", message);
			model.addObject("plainMessage", plainMessage.getMessage());

			return model;
		}

		else {

			messageServices.saveMessage(plainMessage, message);

			return new ModelAndView("redirect:/home/inbox");
		}

	}

	/* * * * * * SEND ENCRYPTED MESSAGE * * * * * */
	@RequestMapping(value = "/push/send", method = RequestMethod.POST)
	public ModelAndView sendEncryptedMessage(@ModelAttribute("message") Messages message, HttpServletRequest request) {

		Messages originalMessage = new Messages(0, message.getSubject(), request.getParameter("plainMessage"),
				new Date().toString(), false, message.getSender(), message.getReceiver());

		messageServices.saveMessage(originalMessage, message);

		return new ModelAndView("redirect:/home");
	}

}

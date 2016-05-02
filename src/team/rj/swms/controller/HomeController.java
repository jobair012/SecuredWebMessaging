package team.rj.swms.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import team.rj.swms.cryptographicServices.Decryption;
import team.rj.swms.cryptographicServices.Encryption;
import team.rj.swms.dao.MessageDAO;
import team.rj.swms.dao.UserKeysDAO;
import team.rj.swms.domain.Message;
import team.rj.swms.domain.UserKeys;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private MessageDAO messageDAO;

	@Autowired
	private UserKeysDAO userKeysDAO;

	/* * * * * * SHOW HOMEPAGE AFTER LOGGED IN * * * * * */

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView showHome() {

		ModelAndView model = new ModelAndView("homePage");

		return model;
	}

	/* * * * * * SHOW COMPOSE PAGE * * * * * */

	@RequestMapping(value = "/compose", method = RequestMethod.GET)
	public ModelAndView showCompose() {

		ModelAndView model = new ModelAndView("composePage");

		Message message = new Message();

		model.addObject("message", message);
		model.addObject("date", new java.util.Date());

		return model;
	}

	/* * * * * * SAVING A NEW MESSAGE * * * * * */

	@RequestMapping(value = "/push", method = RequestMethod.POST)
	public ModelAndView pushMessage(@ModelAttribute("message") Message message, HttpServletRequest request) {

		UserKeys senderKeys = userKeysDAO.getKeysOfParticularUser(request.getUserPrincipal().getName());
		UserKeys receiverKeys = userKeysDAO.getKeysOfParticularUser(message.getReceiver());

		// Sender's private key
		BigInteger sender_d = new BigInteger(senderKeys.getKey_D());
		BigInteger sender_n = new BigInteger(senderKeys.getKey_N());

		// Receiver's public key
		BigInteger receiver_e = new BigInteger(receiverKeys.getKey_E());
		BigInteger receiver_n = new BigInteger(receiverKeys.getKey_N());

		Encryption encrypt = new Encryption(sender_d, sender_n, receiver_e, receiver_n);

		String ciphertext = encrypt.getCiphertext(message.getMessage());
		
		message.setMessage(ciphertext);

		if (request.getParameter("submission").equals("Encrypt")) {

			ModelAndView model = new ModelAndView("encryptedMessagePage");

			model.addObject("message", message);

			return model;
		}

		else {

			messageDAO.saveMessage(message);

			return new ModelAndView("redirect:/home");
		}

	}

	/* * * * * * SEND ENCRYPTED MESSAGE * * * * * */

	@RequestMapping(value = "/push/send", method = RequestMethod.POST)
	public ModelAndView sendEncryptedMessage(@ModelAttribute("message") Message message) {

		messageDAO.saveMessage(message);

		return new ModelAndView("redirect:/home");
	}

	/* * * * * * VIEW INBOX * * * * * */

	@RequestMapping(value = "/inbox", method = RequestMethod.GET)
	public ModelAndView showInbox(HttpServletRequest request, HttpServletResponse response) {

		response.setIntHeader("refresh", 6);

		ModelAndView model = new ModelAndView("inboxPage");

		String username = request.getUserPrincipal().getName();

		model.addObject("messages", messageDAO.getAllMessages(username));

		return model;
	}

	/* * * * * * VIEW A PARTICULAR MESSAGE * * * * * */

	@RequestMapping(value = "/inbox/viewDetails", method = RequestMethod.GET)
	public ModelAndView showParticularMessage(HttpServletRequest request) {

		ModelAndView model = new ModelAndView("detailMessagePage");

		int id = Integer.parseInt(request.getParameter("mid"));
		String sender = request.getParameter("from");
		String receiver = request.getUserPrincipal().getName();

		Message message = messageDAO.getDetailsOfParticularMessage(id, sender, receiver);

		model.addObject("message", message);

		return model;
	}

	/* * * * * * VIEW DECRYPTED MESSAGE * * * * * */

	@RequestMapping(value = "/inbox/decryptMessage", method = RequestMethod.POST)
	public ModelAndView showDecryptedMessage(@ModelAttribute("message") Message message, HttpServletRequest request) {

		ModelAndView model = new ModelAndView("decryptedMessagePage");

		UserKeys receiverKeys = userKeysDAO.getKeysOfParticularUser(request.getUserPrincipal().getName());
		UserKeys senderKeys = userKeysDAO.getKeysOfParticularUser(message.getSender());

		// Receiver's private key
		BigInteger receiver_d = new BigInteger(receiverKeys.getKey_D());
		BigInteger receiver_n = new BigInteger(receiverKeys.getKey_N());

		// Sender's public key
		BigInteger sender_e = new BigInteger(senderKeys.getKey_E());
		BigInteger sender_n = new BigInteger(senderKeys.getKey_N());

		Decryption decrypt = new Decryption(receiver_d, receiver_n, sender_e, sender_n);

		String[] plaintext = decrypt.getPlaintext(message.getMessage());

		if (plaintext[0].hashCode() == Integer.parseInt(plaintext[1])) {

			model.addObject("intigrityCheckMessage", "Message is not altered !");
		} else {

			model.addObject("intigrityCheckMessage", "Message is altered !");
		}

		model.addObject("plaintext", plaintext[0]);

		return model;
	}

}

package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MessagesDao;
import model.Messages;

@Service
public class MessageServices {

	@Autowired
	private MessagesDao messagesDao;
	
	@Transactional
	public void saveMessage(Messages plainMessage, Messages cipherMessage){
		
		messagesDao.saveMessageOnReceived(cipherMessage);
		messagesDao.saveMessageOnSent(plainMessage);
	}
	
	public List<Messages> getAllMessages(String username) {
		
		return messagesDao.getAllMessages(username);
	}

	public Messages getMessage(int id, String sender, String receiver) {
		
		return messagesDao.getMessage(id, sender, receiver);
	}

	public List<Messages> getAllSentMessages(String username) {
		
		return messagesDao.getAllSentMessages(username);
	}

	public Messages getSentMessage(int id, String sender, String receiver) {
		
		return messagesDao.getSentMessages(id, sender, receiver);
	}
}

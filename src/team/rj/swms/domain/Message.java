package team.rj.swms.domain;

import org.springframework.stereotype.Component;

@Component
public class Message {

	private int messageId;
	private String subject;
	private String message;
	private String date;
	private boolean trash;
	private String sender;
	private String receiver;

	public Message() {
	}

	public Message(int messageId, String subject, String message, String date, boolean trash, String sender,
			String receiver) {
		this.messageId = messageId;
		this.subject = subject;
		this.message = message;
		this.date = date;
		this.trash = trash;
		this.sender = sender;
		this.receiver = receiver;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isTrash() {
		return trash;
	}

	public void setTrash(boolean trash) {
		this.trash = trash;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

}

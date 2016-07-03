package model;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

public class Messages {

	private int messageId;

	@NotBlank(message = "Subject can not be blank")
	private String subject;
	
	@NotBlank(message = "Message can not be blank")
	private String message;
	private String time;
	private boolean trashed;
	private String sender;

	@NotEmpty(message = "Enter the receiver username")
	private String receiver;

	public Messages() {
	}

	public Messages(int messageId, String subject, String message, String time, boolean trashed, String sender,
			String receiver) {
		this.messageId = messageId;
		this.subject = subject;
		this.message = message;
		this.time = time;
		this.trashed = trashed;
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

	public String getTime() {
		return time;
	}

	public void settime(String time) {
		this.time = time;
	}

	public boolean isTrashed() {
		return trashed;
	}

	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
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

package com.java.message;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component("messageInfo")
public class MessageInfo implements MessageDetails{

	private Message message;
	//to get data from message.property file 
	private MessageSource messageSouce;

	public MessageSource getMessageSouce() {
		return messageSouce;
	}
	@Autowired
	@Qualifier("messageSource")
	public void setMessageSouce(MessageSource messageSouce) {
		this.messageSouce = messageSouce;
	}
	public Message getMessage() {
		return message;
	}
	@Resource
	public void setMessage(Message message) {
		this.message = message;
	}

	public void getMessageDetails() {
		// TODO Auto-generated method stub
		//calling getMessage to read message from
		//message.properties file
		System.out.println(messageSouce.getMessage("message.name", new Object[] {message.getName()}, "default message", null));
	}
	
}

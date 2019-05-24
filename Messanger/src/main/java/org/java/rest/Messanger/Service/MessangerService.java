package org.java.rest.Messanger.Service;

import java.util.ArrayList;
import java.util.List;

import org.java.rest.Messanger.DAO.MessageDAO;
import org.java.rest.Messanger.pojo.Messages;

public class MessangerService {

	MessageDAO messsageDao = new MessageDAO();
	public void saveMessageService(Messages message) {
		messsageDao.saveMessages(message);
	}
	public List<Messages> getMessageService() {
		return messsageDao.getMessages();
	}
	public Messages getMessageServiceById(int id) {
		return messsageDao.getMessageFromId(id);
	}
	public Messages deleteMessageService(int id) {
		return messsageDao.deleteMessage(id);
	}
	public void updateMessageService(Messages message) {
		messsageDao.updateMessage(message);
	}
	public List<Messages> getMessagesFromFilter(String authorName) {
		return messsageDao.getMessageFromFilter(authorName);
	}
	public List<Messages> getmessagesFromStartAndSize(int start,int size){
		List<Messages> list = messsageDao.getMessages();
		List<Messages> defineList = new ArrayList<>();
		if(size > 0 && size < list.size() ) {
			while(start<=size) {
				defineList.add(list.get(start));
				start++;
			}
		}
		return defineList;
	}
}

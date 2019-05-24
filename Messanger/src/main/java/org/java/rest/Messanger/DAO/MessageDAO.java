package org.java.rest.Messanger.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.internal.compile.CriteriaQueryTypeQueryAdapter;
import org.java.rest.Messanger.FactoryUtil;
import org.java.rest.Messanger.exception.NoDataFoundException;
import org.java.rest.Messanger.pojo.Messages;

import net.sf.ehcache.search.parser.CustomParseException.Message;

//import org.hibernate.sql.ordering.antlr.Factory;

public class MessageDAO {
	
	
	public void saveMessages(Messages message) {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		session.close();
		
	}
	public List<Messages> getMessages() {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		CriteriaBuilder criteria = session.getCriteriaBuilder();
		CriteriaQuery<Messages> query = criteria.createQuery(Messages.class);
		query.from(Messages.class);
		List<Messages> list = session.createQuery(query).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public Messages getMessageFromId(int id) {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		Messages message = session.get(Messages.class, id);
		session.getTransaction().commit();
		session.close();
		if(message == null) {
			//needs to map the response
			throw new NoDataFoundException("message object not found with id:"+id);
		}
		else {
		   return message;
		}
	}
	public void updateMessage(Messages message) {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		System.out.println(message.getAuthor()+" "+message.getMessage()+" "+message.getMessageId());
		session.update(message);
		session.getTransaction().commit();
		session.close();
		System.out.println("update done");
	}
	public Messages deleteMessage(int id) {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		String hql = "delete from Messages where messageId = :id";
		Messages message = session.get(Messages.class, id);
		//deletion query using execute update
		if(message == null) {
			throw new NoDataFoundException("no data to delete with the id:"+id);
		}
		session.createQuery(hql).setParameter("messageId", id).executeUpdate();
		session.getTransaction().commit();
		session.close();
		System.out.println("message object deleted with id "+id);
		return message;
	}
	public List<Messages> getMessageFromFilter(String authorName){
		Session session = FactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Messages> criteria = builder.createQuery(Messages.class);
		Root<Messages> root = criteria.from(Messages.class);
		criteria.where(builder.equal(root.get("author"), authorName));
		List<Messages> list = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
		
	}

	
	
	
}

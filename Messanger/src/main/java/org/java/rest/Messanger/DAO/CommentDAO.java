/*package org.java.rest.Messanger.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.java.rest.Messanger.FactoryUtil;
import org.java.rest.Messanger.pojo.Comments;

public class CommentDAO {

	public void saveComments(Comments comment) {
		Session session = FactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(comment);
		System.out.println("save done");
		session.getTransaction().commit();
		session.close();
	}
}*/

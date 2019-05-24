package org.java.rest.Messanger.DAO;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.java.rest.Messanger.FactoryUtil;
import org.java.rest.Messanger.pojo.Messages;
import org.java.rest.Messanger.pojo.Profile;

import net.sf.ehcache.search.parser.CustomParseException.Message;

public class ProfileDAO {

	public void saveProfile(Profile profile) {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		session.save(profile);
		session.getTransaction().commit();
		session.close();
		
	}
	public List<Profile> getAllProfile() {
		Session session = FactoryUtil.getSessionFactory().openSession();	
		session.beginTransaction();
		CriteriaBuilder criteria = session.getCriteriaBuilder();
		CriteriaQuery<Profile> query = criteria.createQuery(Profile.class);
		query.from(Profile.class);
		List<Profile> list = session.createQuery(query).getResultList();
		session.getTransaction().commit();
		session.close();
		return list;
	}
	public Profile getProfileByName(String profileName) {
		Session session = FactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Profile> criteria = builder.createQuery(Profile.class);
		Root<Profile> root = criteria.from(Profile.class);
		criteria.where(builder.equal(root.get("profileName"), profileName));
		List<Profile> list = session.createQuery(criteria).getResultList();
		session.getTransaction().commit();
		session.close();
		return list.get(0);
	}
	public Profile updateProfile(Profile profile) {
		Session session = FactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		int id = profile.getId();
		//Profile profiles = session.get(Profile.class, id);
		//System.out.println("name before: "+profiles.getFirstName());
		session.update(profile);
		System.out.println("name after: "+profile.getFirstName());
		session.getTransaction().commit();
		session.close();
		return profile;
	}
	public Profile deleteProfile(int id) {
		Session session = FactoryUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "delete from Profile where id = :id";
		Profile profile = session.get(Profile.class, id);
		session.createQuery(hql).setParameter("id", id).executeUpdate();
		session.getTransaction().commit();
		session.close();
		return profile;
	}
	
	
}

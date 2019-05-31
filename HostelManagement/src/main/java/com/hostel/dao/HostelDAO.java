package com.hostel.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hostel.SessionFactoryUtil;
import com.hostel.aspects.HostelAspect;
import com.hostel.pojo.Hostel;

//one more approach is there we can use JPARepository interface or 
//crud repository whoch contains direct method to implement the 
//get or save or update no need to get the sessionfactory and all 
//other things.
@Repository
public class HostelDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public void saveHostel(Hostel hostel) {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		session.save(hostel);
		session.getTransaction().commit();
		session.close();
		
	}
	
	public List<Hostel> getAllHostels() {
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Hostel> query = builder.createQuery(Hostel.class);
		query.from(Hostel.class);
		List<Hostel> list = session.createQuery(query).getResultList();
		if(list.isEmpty())
		{
			throw new RuntimeException();
		}
		session.getTransaction().commit();
		session.close();
		return list;
	}
	//static content
	public void getLogsForTargetObjects() {
		System.out.println("getting logs for target objects");
	}
	public Hostel getHostelById(int hostelId) {
		
		Session session = this.sessionFactory.openSession();
		session.beginTransaction();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Hostel> query = builder.createQuery(Hostel.class);
		Root<Hostel> root = query.from(Hostel.class);
		query.where(builder.equal(root.get("hostelId"), hostelId));
		Hostel hostel;
		try  {
		hostel = session.createQuery(query).getSingleResult();
		} catch (NoResultException re) {
			hostel = null;
			// TODO: handle exception
		}
		return hostel;
	}
	
}

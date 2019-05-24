package com.java.app;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.java.query.Teams;

public class TeamApp {

	public static void main(String args[]) {
		//transient state
		Teams team = new Teams();
		team.setName("RealMadrid");
		team.setPlayers(11);
		int userId = 7;
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		//session.save(team);
		//positional parameter
		//need to implement query level cache separately
		Query query = session.createQuery("from Teams where id = :userId");
		query.setParameter("userId", userId);
		//this will look for the above query data in L2 cache.
		query.setCacheable(true);
		List<Teams> list = query.list();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		//if changes to other type than it will require multi select.
		CriteriaQuery<Teams> cri = builder.createQuery(Teams.class);
		//It always refer to the entities
		Root<Teams> root = cri.from(Teams.class);
		//has primitive types of values.
		Path<Integer> idPath = root.get("id"); 
		Path<String> namePath = root.get("name");
		//cri.multiselect(idPath,namePath);
		//cri.where(builder.equal(root.get("name"),"RealMadrid" ));
		//List<Teams> list = session.createQuery(cri).getResultList();
		//It doesn't fire the select query as object is 
		//there in hibernate cache.(This is called first level cache)
		//this depends on the session.if session gets close and new 
		//session gets called than it will call select statement.
		//Teams team_session = session.get(Teams.class, 5);
		session.getTransaction().commit();
		session.close();
		//if we open second session than the above get Session()
		//will call the select query from database as new cache will 
		//form.
		//To stop this we will implement second level cache(eh-cache).
		Session session2 = factory.openSession();
		session2.beginTransaction();
		//second level cache is enabled than we will not see select
		//query for the below line as it is fetched from cache
		//Teams team_session = session2.get(Teams.class, 5);
		Query query2 = session2.createQuery("from Teams where id = :userId");
		query2.setParameter("userId", userId);
		//this will look for the above query data in L2 cache
		//so we have to set Cacheable for both the query.
		query2.setCacheable(true);
		List<Teams> list2 = query2.list();
		session2.getTransaction().commit();
		session2.close();
		System.out.println(list.size());
		System.out.println(list.get(0).toString());
		//System.out.println(team_session.getName());
		System.out.println(list2.size());
		System.out.println(list2.get(0).toString());
	}
	
}
/*
 * Output: when we haven't implemented the second level cache and have two
 * sessions: Hibernate: select teams0_.TEAM_ID as TEAM_ID1_0_, teams0_.name as
 * name2_0_, teams0_.players as players3_0_ from TEAM teams0_ where
 * teams0_.name=? Hibernate: select teams0_.TEAM_ID as TEAM_ID1_0_0_,
 * teams0_.name as name2_0_0_, teams0_.players as players3_0_0_ from TEAM
 * teams0_ where teams0_.TEAM_ID=? Output: when we don't have two sessions that
 * is firts level cache. Hibernate: select teams0_.TEAM_ID as TEAM_ID1_0_,
 * teams0_.name as name2_0_, teams0_.players as players3_0_ from TEAM teams0_
 * where teams0_.name=? Output: when l2 cache is on using eh-cache than output
 * is: 
 * Hibernate: select teams0_.TEAM_ID as TEAM_ID1_0_, teams0_.name as
 * name2_0_, teams0_.players as players3_0_ from TEAM teams0_ where
 * teams0_.name=?
 */
/*
 * when using query level cache we need to enable the second level cache for
 * query object separately as it doesn't depend on entity. using setCacheable =
 * true. output: 
 * Hibernate: select teams0_.TEAM_ID as TEAM_ID1_0_, teams0_.name
 * as name2_0_, teams0_.players as players3_0_ from TEAM teams0_ where
 * teams0_.TEAM_ID=? 
 * 1 
 * Teams [id=7, name=RealMadrid, players=11]
 *  1 
 *  Teams [id=7,name=RealMadrid, players=11]
 */

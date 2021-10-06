package com.flyaway.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.entities.Airlines;

public class AirlinesDao {

	private SessionFactory factory;

	public AirlinesDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	//save the airline to db
	public int saveAirline(Airlines airlines)
	{
		int id=0;
		try {
			Session s = this.factory.openSession();
			Transaction tx = s.beginTransaction();
			
			id=(int) s.save(airlines);
			
			tx.commit();
//			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
	
	//getting all airlines from db
	public List<Airlines> getAllAirlines()
	{
		Session s = this.factory.openSession();
		Query q = s.createQuery("from Airlines");
		List<Airlines> airlinesList = q.list();
		return airlinesList;	
	}
	
	//get airlines by id
	public Airlines getAirlineById(int aid)
	{
		Airlines airlines=null;
		try {
			Session s = this.factory.openSession();
			airlines = s.get(Airlines.class, aid);
//			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return airlines;
	}
}

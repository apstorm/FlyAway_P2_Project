package com.flyaway.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.entities.Passengers;

public class PassengerDao {

	private SessionFactory factory;

	public PassengerDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	//saving passenger details
	public boolean savePassngers(Passengers p)
	{
		
		boolean f=false;
		try {
			Session s = this.factory.openSession();
			Transaction tx = s.beginTransaction();
			 s.save(p);
			 
			tx.commit();
			
			f=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	
	//get Last passenger
	public List<Passengers> getPassenger()
	{
		List<Passengers> list=null;
		try {
			Session s = this.factory.openSession();
			Query q = s.createQuery("from Passengers where pid="
					+ "(select max(pid) from Passengers)");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}

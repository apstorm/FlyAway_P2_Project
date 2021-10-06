package com.flyaway.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.flyaway.entities.Users;

public class UserDao {

	private SessionFactory factory;

	public UserDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	public Users getUserByEmailAndPasword(String email,String password)
	{
		Users u=null;
		try {
			String q="from Users where email=:e and userPassword=:p";
			Session s = this.factory.openSession();
			Query query = s.createQuery(q);
			query.setParameter("e", email);
			query.setParameter("p", password);
			
			u=(Users) query.uniqueResult();
			
//			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
	
}

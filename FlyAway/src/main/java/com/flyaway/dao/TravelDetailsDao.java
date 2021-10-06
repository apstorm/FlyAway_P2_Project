package com.flyaway.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.flyaway.entities.TravelDetails;

public class TravelDetailsDao {

	private SessionFactory factory;

	public TravelDetailsDao(SessionFactory factory) {
		super();
		this.factory = factory;
	}
	
	//fetching travel details
	public List<TravelDetails> getTravelDetails()
	{
		List<TravelDetails> list=new ArrayList<TravelDetails>();
		Session s = this.factory.openSession();
		/*
		SELECT * FROM TableName WHERE id=(SELECT max(id) FROM TableName);
		*/
		try {
			Query q = s.createQuery("from TravelDetails where travelId="
					+ "(select max(travelId) from TravelDetails)");
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}

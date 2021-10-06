package com.flyaway.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.flyaway.entities.AirFlights;
import com.flyaway.entities.Cart;

public class AirFlightDao {

	private SessionFactory factory;

	public AirFlightDao(SessionFactory factory) {
		this.factory = factory;
	}
	
	//save flights
	public boolean saveFlight(AirFlights af)
	{
		boolean f=false;
		try {
			Session session = this.factory.openSession();
			Transaction tx = session.beginTransaction();
			
			session.save(af);
			
			tx.commit();
//			session.close();
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
			f=false;
		}
		return f;
	}
	
	//get all flights
	public List<AirFlights>  getAllFlights()
	{
		List<AirFlights> flightList=null;
		try {
			Session s = this.factory.openSession();
			Query q = s.createQuery("from AirFlights");
			flightList = q.list();
//			s.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flightList;
	}
	
	//get all flights of given airline category
	public List<AirFlights> getAllFlightsByAirLinesId(int aid)
	{
		List<AirFlights> flights=null;
		try {
			Session s = this.factory.openSession();
			Query q = s.createQuery("from AirFlights as a "
					+ "where a.flightAirlines.id=: aid");
			q.setParameter("aid", aid);
			flights = q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	//getting all available flights from specific source to specific destination
	public List<AirFlights> getAllFlightsByOriginAndDestination(String origin, String destination)
	{
		List<AirFlights> flights=null;
		try {
			Session s = this.factory.openSession();
			Query q = s.createQuery("from AirFlights as af"
					+ "	where af.flightOrigin =: or "
					+ " and af.flightDestination =: destn");
			
			q.setParameter("or", origin);
			q.setParameter("destn", destination);
			
			flights=q.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flights;
	}
	
	//getting a fight to boared
	public List<Cart> getFlight(List<Cart> cartList)
	{
		List<Cart> a=new ArrayList<>();
		try {
			Session s = this.factory.openSession();
			if(cartList.size()>0)
			{
				for(Cart item:cartList)
				{
					int id=item.getFlightId();
					
					Query q = s.createQuery("from AirFlights where flightId =: fid");
					q.setParameter("fid", id);
					a = q.list();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
}

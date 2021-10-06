package com.flyaway.helper;

import java.util.Hashtable;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class Helper {
	
	public static String get10Words(String desc)
	{
		String[] strs = desc.split(" ");
		if(strs.length>10)
		{
			String res="";
			for(int i=0;i<10;i++)
			{
//				res=res+strs[i].concat(" ");
				res=res+strs[i]+" ";
			}
			return (res+"...");
		}else
		{
			return (desc+"....");
		}
	}
	
	public static Map<String, Long> getCounts(SessionFactory factory)
	{
		Session s = factory.openSession();
		Query qUser = s.createQuery("select count(*) from Users");
		Query qAirlines = s.createQuery("select count(*) from Airlines");
		Query qFlights = s.createQuery("select count(*) from AirFlights");
		
		long userCount = (long) qUser.list().get(0);
		long airlinesCount = (long) qAirlines.list().get(0);
		long flightsCount = (long) qFlights.list().get(0);
		
		Map<String, Long> map=new Hashtable<>();
		map.put("userCount", userCount);
		map.put("airlinesCount", airlinesCount);
		map.put("flightsCount", flightsCount);
	
		s.close();
		return map;
		
	}
	
}

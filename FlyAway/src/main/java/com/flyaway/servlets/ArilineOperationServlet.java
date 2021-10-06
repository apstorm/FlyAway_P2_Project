package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.AirFlightDao;
import com.flyaway.dao.AirlinesDao;
import com.flyaway.entities.AirFlights;
import com.flyaway.entities.Airlines;
import com.flyaway.helper.FactoryProvider;

@WebServlet(name = "ArilineOperationServlet",urlPatterns = {"/ArilineOperationServlet"})
public class ArilineOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ArilineOperationServlet() {
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
			
			String operation=request.getParameter("operation");
			if(operation.trim().equals("addairline"))
			{
				//add airline name
				//fetching airline data
				String airlinesName = request.getParameter("airlinesName");
				String description = request.getParameter("description");
				
				Airlines al=new Airlines(airlinesName, description);
				
				//airlines to be saved in db here
				AirlinesDao airDao=new AirlinesDao(FactoryProvider.getFactory());
				airDao.saveAirline(al);
				
				HttpSession s=request.getSession();
				s.setAttribute("message", "Airlines added successfully");
				response.sendRedirect("admin.jsp");
				return;
			}
			else if(operation.trim().equals("addflights"))
			{
				//adding a flight here
				String flightName = request.getParameter("flightName");
				String flightOrigin = request.getParameter("flightOrigin");
				int ticketPrice = Integer.parseInt(request.getParameter("ticketPrice"));
				String flightDestination = request.getParameter("flightDestination");
				int fid = Integer.parseInt(request.getParameter("id"));
				
				//get airline id
				AirlinesDao airDao=new AirlinesDao(FactoryProvider.getFactory());
				Airlines airlineById = airDao.getAirlineById(fid);
				
				AirFlights airFlights=new AirFlights(flightName, airlineById, flightOrigin, flightDestination, ticketPrice);
						
				//saving flight details
				AirFlightDao airFlightDao=new AirFlightDao(FactoryProvider.getFactory());
				airFlightDao.saveFlight(airFlights);
				
				HttpSession s=request.getSession();
				s.setAttribute("message", "flight added successfully !!");
				response.sendRedirect("admin.jsp");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

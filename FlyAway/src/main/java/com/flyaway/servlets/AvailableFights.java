package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.dao.AirFlightDao;
import com.flyaway.dao.TravelDetailsDao;
import com.flyaway.entities.AirFlights;
import com.flyaway.entities.TravelDetails;
import com.flyaway.helper.FactoryProvider;

@WebServlet(name = "AvailableFights",urlPatterns = {"/availableFlights"})
public class AvailableFights extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AvailableFights() {
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
				String tdate=request.getParameter("tdate");
				String from = request.getParameter("from");
				String to = request.getParameter("to");
//				int totalPassengers = Integer.parseInt(request.getParameter("totalPassengers"));
					
//				request.setAttribute("tdate", tdate);
//				request.setAttribute("from", from);
//				request.setAttribute("to", to);
//				request.setAttribute("totalPassengers", totalPassengers);
				
				//creating travelDetails object to store travel details in it
				TravelDetails td= new TravelDetails(tdate, to, from);
				Session session = FactoryProvider.getFactory().openSession();
				
				Transaction tx = session.beginTransaction();
				
				int save = (int) session.save(td);
				
				tx.commit();
				
				AirFlightDao afdao=new AirFlightDao(FactoryProvider.getFactory());
				List<AirFlights> availableFlights = afdao.getAllFlightsByOriginAndDestination(from, to);
				
				TravelDetailsDao tdao=new TravelDetailsDao(FactoryProvider.getFactory());
				List<TravelDetails> travelDetails = tdao.getTravelDetails();
				HttpSession s=request.getSession();
				s.setAttribute("availableFlights", availableFlights);
				s.setAttribute("tdate", tdate);
				s.setAttribute("from", from);
				s.setAttribute("to", to);
//				s.setAttribute("totalPassengers", totalPassengers);
				
				s.setAttribute("travelDetails", travelDetails);
				RequestDispatcher rd = request.getRequestDispatcher("/availableFlights.jsp");
//				response.sendRedirect("availableFlights.jsp");
				rd.forward(request, response);
				
//				session.close();
				
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

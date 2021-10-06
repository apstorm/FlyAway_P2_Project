package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.PassengerDao;
import com.flyaway.entities.Passengers;
import com.flyaway.helper.FactoryProvider;

@WebServlet(name = "PassengerServlet",urlPatterns = {"/PassengerServlet"})
public class PassengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public PassengerServlet() {
    
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
			String pName = request.getParameter("pName");
			String pEmail = request.getParameter("pEmail");
			String pPhone = request.getParameter("pPhone");
			int pAge = Integer.parseInt(request.getParameter("pAge"));
			
			if(pName.isEmpty())
			{
				out.println("name is blank..");
				return;
			}
			
			Passengers p=new Passengers(pName, pEmail, pPhone, pAge);
			PassengerDao pdao=new PassengerDao(FactoryProvider.getFactory());
			pdao.savePassngers(p);
			
			
			List<Passengers> ps = pdao.getPassenger();
			
			if((pEmail.isEmpty() || pEmail.isBlank()) || 
					 (pPhone.isEmpty() || pPhone.isBlank()) || 
					 ((pAge<=0) && (pAge>=120)))
			{
				HttpSession session=request.getSession();
				session.setAttribute("message", "invalid details !! please fill again..");
				response.sendRedirect("passengerDetails.jsp");
				return;
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("ps", ps);
			session.setAttribute("message", "Details added Successfully !! ");
		
			response.sendRedirect("checkout.jsp");
			return;
			
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

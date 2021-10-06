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

import com.flyaway.entities.AirFlights;
import com.flyaway.entities.Cart;

@WebServlet(name = "AddToCart",urlPatterns = {"/AddToCart"})
public class AddToCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddToCart() {
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
			List<Cart> cartList=new ArrayList<>();
			
			int id=Integer.parseInt(request.getParameter("id"));
			Cart c=new Cart();
			c.setFlightId(id);
			c.setQuantity(1);
			
			HttpSession session = request.getSession();
			List<Cart> flightList = (List<Cart>) session.getAttribute("cart-list");
			
			if(flightList==null)
			{
				cartList.add(c);
				session.setAttribute("cart-list", cartList);
				HttpSession s=request.getSession();
				s.setAttribute("message","flight added !!");
				response.sendRedirect("availableFlights.jsp");
			}
			else
			{
				cartList= flightList;
				boolean exist=false;
				
				
				for(Cart cart:cartList)
				{
					if(cart.getFlightId()==id)
					{
						exist=true;
						HttpSession s=request.getSession();
						s.setAttribute("message","Already chosen flight !!");
						response.sendRedirect("availableFlights.jsp");
					}
				}
				if(!exist)
				{
					cartList.add(c);
					response.sendRedirect("checkout.jsp");
				}
			}
			
//			response.sendRedirect("checkout.jsp");
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

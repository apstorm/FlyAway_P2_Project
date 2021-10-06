package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.flyaway.entities.Users;
import com.flyaway.helper.FactoryProvider;

@WebServlet(name = "RegisterServlet",urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public RegisterServlet() {
      
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String userPassword = request.getParameter("userPassword");
			String phone = request.getParameter("phone");
			int age = Integer.parseInt(request.getParameter("age"));
			
			
			
			if(name.isEmpty())
			{
				out.println("name is blank..");
				return;
			}
			
			//user object creation and registered user is getting saved in database
			Users users=new Users(name, email, userPassword, phone, age, "normal");
			
			Session s = FactoryProvider.getFactory().openSession();
			Transaction tx = s.beginTransaction();
			
			int id = (int) s.save(users);
			
			tx.commit();
//			s.close();
			
			if((email.isEmpty() || email.isBlank()) || 
					(userPassword.isEmpty() || 
					 userPassword.isBlank()) || 
					 (phone.isEmpty() || phone.isBlank()) || ((age<=0) && (age>=120)))
			{
				HttpSession session=request.getSession();
				session.setAttribute("message", "invalid details !! please fill again..");
				response.sendRedirect("register.jsp");
				return;
			}
			
			HttpSession session=request.getSession();
			session.setAttribute("message", "Registeration Successfull !!  UserId is "+id);
		
			response.sendRedirect("register.jsp");
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

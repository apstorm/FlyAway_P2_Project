package com.flyaway.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flyaway.dao.UserDao;
import com.flyaway.entities.Users;
import com.flyaway.helper.FactoryProvider;

@WebServlet(name = "LoginServlet",urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public LoginServlet() {
       
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out=response.getWriter()) {
			
			String email = request.getParameter("email");
			String userPassword = request.getParameter("userPassword");
			
//			here we will authenticate whether the user is valid or not
			UserDao ud=new UserDao(FactoryProvider.getFactory());
			Users user = ud.getUserByEmailAndPasword(email, userPassword);
			HttpSession session=request.getSession();
			
			if(user==null)
			{
				out.println("<h1>Invalid Details</h1>");
				session.setAttribute("message", "Invalid Details!!, try with another one.");
				response.sendRedirect("login.jsp");
				return;
			}
			else
			{
				out.println("<h1>Welcome "+user.getName()+"</h1>");
				
				//we will use loginsession first
				session.setAttribute("current_user", user);
				
				if(user.getUserType().equals("normal"))
				{
					response.sendRedirect("normal.jsp");
				}
				else if(user.getUserType().equals("admin"))
				{
					response.sendRedirect("admin.jsp");
				}
				else
				{
					out.println("We have not identified user type");
				}
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

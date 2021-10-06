<%@page import="com.flyaway.entities.Users"%>
<%
	Users u1=(Users)session.getAttribute("current_user");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light navbar-bg">
		<div class="container">
			<a class="navbar-brand" href="index.jsp">FlyAway</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="Flights.jsp">Home</a>
					</li>
					
					<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false">
							Categories 
						</a>
						<div class="dropdown-menu" aria-labelledby="navbarDropdown">
							<a class="dropdown-item" href="about.jsp">About</a> <a
								class="dropdown-item" href="Flights.jsp">Airlines</a>
							<div class="dropdown-divider"></div>
							<a class="dropdown-item" href="contact.jsp">Contact Us</a>
						</div>
					</li>	
				</ul>
				<div>
					<%
						if(u1==null)
						{
					%>
					<!-- login link -->
					<a href="login.jsp" style="color: white;">Login</a>&nbsp;
					<a href="register.jsp" style="color: white;">Register</a>
					<%
						}
						else
						{
					%>
					<a href="<%= u1.getUserType().equals("admin")? "admin.jsp":"normal.jsp" %>" style="color: white;">
						<%= u1.getName() %>
					</a> &nbsp;
					<a href="LogoutServlet" style="color: white;">
						Logout
					</a>
					<%
						}
					%>
				</div>
			</div>
		</div>
	</nav>

</body>
</html>
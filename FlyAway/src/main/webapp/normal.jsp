<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome to FlyAway</title>
<%@ include file="components/common_css_js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	<div class="container">
		<div class="container-fluid mt-3">
			 <%@ include file="components/message.jsp" %>
			 <%
			 	HttpSession s=request.getSession();
			 	s.setAttribute("message", "Succesfully Logged in !!");
			 	response.sendRedirect("index.jsp");
			 %>
		</div>
	</div>
</body>
</html>
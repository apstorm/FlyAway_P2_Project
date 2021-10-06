<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
</head>
<body>
	<%
		String msg=(String)session.getAttribute("message");
		if(msg!=null)
		{
	%>
	<div class="alert alert-success alert-dismissible fade show"
			role="alert">
		<strong><%= msg %></strong>
		<button type="button" class="close" 
				data-dismiss="alert"
				aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>
	
	<%
			session.removeAttribute("message");
		}
	%>
	
</body>
</html>
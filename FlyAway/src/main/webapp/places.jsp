
<%@page import="com.flyaway.entities.AirFlights"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.helper.FactoryProvider"%>
<%@page import="com.flyaway.dao.AirFlightDao"%>
<%
	AirFlightDao adao=new AirFlightDao(FactoryProvider.getFactory());
	List<AirFlights> flights=adao.getAllFlights();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Places</title>
<%@ include file="components/common_css_js.jsp" %>

</head>
<body style="background-image: url('image/places.jpg');background-size: cover;">
	<%@include file="components/navbar.jsp" %>
	<div class="container">
	<h1 class="text-center" style="color: #ac2e34">Places</h1>
		<table id="places" class="table table-lights" style="border-style: solid; border-color: #4ba8f0">
			<thead>
				<tr>
					<th scope="col">origin</th>
					<th scope="col">destination</th>
					
				</tr>
			</thead>
			<tbody>
			<%
				if(flights != null)
				{
					for(AirFlights af: flights)
					{
			%>
				<tr>
					<td><%= af.getFlightOrigin() %></td>
					<td><%= af.getFlightDestination() %></td>
				</tr>
			<%
			
					}
				}
			%>	
			</tbody>
		</table>
	</div>
</body>
</html>
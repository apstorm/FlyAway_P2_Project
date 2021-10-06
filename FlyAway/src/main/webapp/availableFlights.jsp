<%@page import="com.flyaway.entities.TravelDetails"%>
<%@page import="com.flyaway.helper.FactoryProvider"%>
<%@page import="com.flyaway.dao.AirFlightDao"%>
<%@page import="com.flyaway.helper.Helper"%>
<%@page import="com.flyaway.entities.AirFlights"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway Flights</title>
<%@ include file="components/common_css_js.jsp" %>
</head>
<body style="background-image: url('image/flights.jpg');background-size: cover;">
	<%@include file="components/navbar.jsp" %>
	<%
	
		List<AirFlights> allfts=(List<AirFlights>)session.getAttribute("availableFlights");
		/* AirFlightDao adao=new AirFlightDao(FactoryProvider.getFactory()); */
		
		
	%>
	
	<div class="container-fluid">
		<div class="row mt-3 mx-2">
			<div class="col-md-12">
				<div class="row mt-4">
					<div class="col-md-12">
						<div class="card-columns">
						<%	
							for(AirFlights af:allfts)
							{
							
						%>
							<!-- available flights card -->
							<div class="card flights-card" style="border-color: #ffff66;">
								<div class="card-body">
									<h5 class="card-title"><%= af.getFlightName() %></h5>
									<p class="card-text"><%= Helper.get10Words(af.getFlightAirlines().getDescription()) %></p>
								</div>
							
									<!-- <a href="passengerDetails.jsp"> -->
									<a href="BoardingFlight?fid=<%= af.getFlightId() %>">
								<!-- <a href="register.jsp"> -->
									<button class="btn btn-outline-success m-1">
										&#8377;<%= af.getTicketPrice() %>
									</button>
								</a>
							</div>
		<%
		}
		%>
						</div>
					</div>
				</div>
			</div>
			<%
				if(allfts.isEmpty())
				{
			%>		
					<div class="container mt-6" style="background-color: #c3d5eb;">
						<br> <br>
						<h1>
							No such Flights available to and from place !!
							We Sincerely apologize for the inconvenience.
							please check after some time from now.
						</h1>
					</div>
			<%		
				}
			%>
		</div>
	</div>
</body>
</html>
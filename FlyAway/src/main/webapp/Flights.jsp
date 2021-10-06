<%@page import="com.flyaway.helper.Helper"%>
<%@page import="com.flyaway.entities.Airlines"%>
<%@page import="com.flyaway.dao.AirlinesDao"%>
<%@page import="com.flyaway.entities.AirFlights"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.helper.FactoryProvider"%>
<%@page import="com.flyaway.dao.AirFlightDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ include file="components/common_css_js.jsp" %>
</head>
<body style="background-image: url('image/airplane-flight.jpg');background-size: cover;">
	<%@include file="components/navbar.jsp" %>
		<div class="container-fluid">
			<div class="row mt-3 mx-2">
				<%
				String airline=request.getParameter("airline");
				
				AirFlightDao fligtDao=new AirFlightDao(FactoryProvider.getFactory());
				List<AirFlights> flights=null;
					if(airline==null || airline.trim().equals("all"))
					{
						flights=fligtDao.getAllFlights();
					}
					else
					{
						int fid=Integer.parseInt(airline.trim());
						flights=fligtDao.getAllFlightsByAirLinesId(fid);
					}
				
					AirlinesDao airDao=new AirlinesDao(FactoryProvider.getFactory());
					List<Airlines> airlines=airDao.getAllAirlines();
				%>
				
				<!-- displaying airlines -->
				<div class="col-md-2">
					<div class="list-group mt-4">
						<a href="Flights.jsp?airline=<%= "all" %>" class="list-group-item list-group-item-action active">
						All Flights
						</a>
					<%
						for(Airlines al:airlines)
						{
							
					%>
						<a href="Flights.jsp?airline=<%= al.getId() %>" class="list-group-item list-group-item-action">
							<%= al.getAirlinesName() %>
						</a>
					<%		
							
						}
					%>
					</div>
				</div>
				
				<!-- displaying flights -->
				<div class="col-md-10">
					<div class="row mt-4">
						<!-- column 12 grid -->
						<div class="col-md-12">
							<div class="card-columns">
								<!-- traversing via flights -->
								<%
								for(AirFlights af:flights)
								{
								%>
								<!-- flights card boxes -->
								<div class="card flights-card" style="border-color: #ffff66;">
									<div class="card-body">
										<h5 class="card-title"><%= af.getFlightName() %></h5>
									</div>
									<div class="card-footer text-center">
										<h3 class="flights"><%= af.getFlightAirlines().getAirlinesName() %></h3>
										<h3 class="flights"><%= af.getFlightOrigin() %> To <%= af.getFlightDestination() %></h3>
										
										<button class="btn btn-outline-success m-1">&#8377;
											<%= af.getTicketPrice() %>
										</button>
									</div>
								</div>	
								<%	
								}
								%>
								
								<%
									if(flights.size()==0)
									{
										out.println("No Flights such available for now !!");
									}
								%>
							</div>
						</div>
					</div>
				</div>
				
			</div>
		</div>
</body>
</html>
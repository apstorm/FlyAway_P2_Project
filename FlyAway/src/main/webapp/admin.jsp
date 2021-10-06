
<%@page import="com.flyaway.helper.Helper"%>
<%@page import="java.util.Map"%>
<%@page import="com.flyaway.entities.AirFlights"%>
<%@page import="com.flyaway.dao.AirFlightDao"%>
<%@page import="com.flyaway.entities.Airlines"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.helper.FactoryProvider"%>
<%@page import="com.flyaway.dao.AirlinesDao"%>
<%@page import="com.flyaway.entities.Users"%>
	<%
		Users u=(Users)session.getAttribute("current_user");
		if(u==null)
		{
			session.setAttribute("message", "you have not logged in !! Login first");
			response.sendRedirect("login.jsp");
			return;
		}
		else
		{
			if(u.getUserType().equals("normal"))
			{
				session.setAttribute("message", "you aren't admin !! Do not access this page");
				response.sendRedirect("login.jsp");
				return;
			}
		}
	%>

	<!-- airlines category -->
	<%
		AirlinesDao airDao=new AirlinesDao(FactoryProvider.getFactory());
		List<Airlines> airlines=airDao.getAllAirlines();
		
		AirFlightDao flightDao=new AirFlightDao(FactoryProvider.getFactory());
		List<AirFlights> flights =flightDao.getAllFlights();
		
		Map<String, Long> m=Helper.getCounts(FactoryProvider.getFactory());
		
		
	%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Panel</title>
<%@ include file="components/common_css_js.jsp"%>
</head>
<body>
	<%@include file="components/navbar.jsp"%>

	<div class="container admin">
		<div class="container-fluid mt-3">
			<%@ include file="components/message.jsp"%>
		</div>
		<!-- first row -->
		<div class="row mt-3">
			<div class="col-md-4 text-center">
				<!-- 1st box of categories-->
				<div class="card flights-card">
					<div class="card-body text-center">
						<div class="container text-center">
							<img class="img-fluid rounded" style="max-width: 265px; border-style: solid;" 
								alt="Places" src="image/Travel-Places.png">
						</div>
						<h3>23456</h3>
						<h3><a href="places.jsp">Places</a></h3>
					</div>
				</div>
			</div>

			<!-- 2nd col -->
			<div class="col-md-4">
				<div class="card flights-card">
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 265px; border-style: solid;" class="img-fluid rounded"
								alt="Airlines" src="image/bg.jpg">
						</div>
						<h3><%= m.get("airlinesCount") %></h3>
						<h3><a href="Flights.jsp">Airlines</a></h3>
					</div>
				</div>
			</div>
			
			<div class="col-md-4">
				<div class="card flights-card">
					<div class="card-body text-center">
					   <div class="container">
							<img style="max-width: 265px; border-style: solid;" class="img-fluid rounded" 
							alt="Flights" src="image/flights.jpg">
					   </div>
						<h3><%= m.get("flightsCount") %></h3>
						<h3 class="text-uppercase text-muted"><a href="Flights.jsp">Flights</a></h3>
					</div>
				</div>
			</div>
		</div>
		<!-- 1st row ends -->

		<!-- 2nd row -->
		<div class="row mt-3">
			<!-- 1st column -->
			<div class="col-md-6">
				<!-- 1st box -->
				<div class="card flights-card" data-toggle="modal" data-target="#add-airlines" >
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 265px; border-style: solid;" class="img-fluid rounded" 
								 alt="add-airlines" src="image/key.png">
						</div>
						<p class="mt-2">Click here to add new airlines</p>
						<h3 class="text-uppercase text-muted">Add Airlines</h3>
					</div>
				</div>
			</div>	
			
			<!-- 2nd column -->
			<div class="col-md-6">
				<!-- 2nd box -->
				<div class="card flights-card" data-toggle="modal" data-target="#add-flights" >
					<div class="card-body text-center">
						<div class="container">
							<img style="max-width: 265px; border-style: solid;" class="img-fluid rounded"
								 alt="add-flights" src="image/plus.png">
						</div>
						<p class="mt-2">Click here to add new flight</p>
						<h3 class="text-uppercase text-muted">Add Flight</h3>
					</div>
				</div>
			</div>		
		</div>
		<!-- 2nd row ends -->

	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="add-airlines" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Fill Airline Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="background-color: #99c2ff">
					<form action="ArilineOperationServlet" method="post">
						<input type="hidden" name="operation" value="addairline">
						
						<div class="form-group">
							<input type="text" class="form-control" 
							name="airlinesName" 
							placeholder="enter airline name">
						</div>
						<div class="form-group">
							<textarea  
							style="height: 250px;"
							class="form-control"
							name="description" 
							placeholder="enter airline description" 
							required="required"></textarea>
						</div>
						<div class="container text-center">
							<button class="btn btn-outline-darks">Add Airline</button>
							<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	<!-- End add airline modal -->

	<!-- 2. add flight modal -->

	<!-- Modal -->
	<div class="modal fade" id="add-flights" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header custom-bg text-white">
					<h5 class="modal-title" id="exampleModalLabel">Fill flight Details</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body" style="background-color: #99c2ff">
																				
					<form action="ArilineOperationServlet" method="post">
					
					  <input type="hidden" name="operation" value="addflights">
					
						<div class="form-group">
							<label>Flight Name</label>
							<input type="text" class="form-control" 
							name="flightName" 
							placeholder="enter flight name">
						</div>
						
						<div class="form-group">	
							<label for="flightOrigin">
									Source
							</label>	<br>			
							<input type="text" id="flightOrigin"
								   name="flightOrigin" required="required"
								   placeholder="enter source place"/> 
						</div>
						
						<div class="form-group mt-3">
							<label>ticket Price</label>
							<input type="number" class="form-control" 
							name="ticketPrice" required="required"
							placeholder="enter ticket price">
						</div>
						
						<div class="form-group">
							<label for="flightDestination">Destination</label>
							<input type="text" class="form-control" 
							name="flightDestination" id="flightDestination"
							placeholder="enter Destination place"
							required="required">
						</div>
						
						<!-- flight airline -->
						<div class="form-group">
							<label>Airline Name</label>
							<select class="form-control" name="id" >
						<%
							for(Airlines al:airlines)
							{
						%>
								<option value="<%= al.getId() %>" ><%=al.getAirlinesName() %></option>
						<%
							}
						%>
							</select>
						</div>
					
						<div class="container text-center mt-3">
							<button class="btn btn-outline-darks">Add Flight</button>
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
				
			</div>
		</div>
	</div>
	<!-- End add category modal -->	

</body>
</html>
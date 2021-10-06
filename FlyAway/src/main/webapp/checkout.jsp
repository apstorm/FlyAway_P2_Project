
<%@page import="com.flyaway.entities.AirFlights"%>
<%@page import="com.flyaway.entities.Passengers"%>
<%@page import="com.flyaway.entities.TravelDetails"%>
<%@page import="com.flyaway.entities.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.flyaway.helper.FactoryProvider"%>
<%@page import="com.flyaway.dao.AirFlightDao"%>
<%@page import="com.flyaway.entities.Users"%>
<%

	Users u=(Users)session.getAttribute("current_user");
	if(u==null)
	{
		session.setAttribute("message", "you are not logged in !! please login first..");
		response.sendRedirect("login.jsp");
		return;
	}
	
	/* List<Cart> cart_list=(List<Cart>)session.getAttribute("cart-list");
	List<Cart> flightList=null;
	if(cart_list != null)
	{
		AirFlightDao afdao=new AirFlightDao(FactoryProvider.getFactory());	
		flightList=afdao.getFlight(cart_list);
		request.setAttribute("cart_List", cart_list);
	}	 */
%>

<%
	/* out.println(session.getAttribute("travelDetails")); */
			String tdate=(String)session.getAttribute("tdate");
			String from=(String)session.getAttribute("from");
			String to=(String)session.getAttribute("to");
			/* int totalPassengers=(Integer)session.getAttribute("totalPassengers"); */
			int totalPassengers=1;
			int fid=(Integer)session.getAttribute("fid");
			
			List<Passengers> pList=(List<Passengers>)session.getAttribute("ps");
			List<AirFlights> allfts=(List<AirFlights>)session.getAttribute("availableFlights");
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CheckOut</title>
<%@ include file="components/common_css_js.jsp" %>
</head>
<body>
	<%@include file="components/navbar.jsp" %>
	
	<div class="container">			
			<table class="table table-lights">
				<thead>
					<tr>
						<th scope="col">Flight Name</th>
						<th scope="col">Travel Date</th>
						<th scope="col">origin</th>
						<th scope="col">destination</th>
						<th scope="col">Fare</th>
						<th scope="col">Total Passengers</th>
						<!-- <th scope="col">cancel</th> -->
					</tr>
				</thead>
				<tbody>
				<%
					/* if(cart_list !=null)
					{
						for(Cart c:flightList)
						{ */
							if(pList != null)
							{
								for(Passengers p: pList)
								{
				%>
					<tr>
						
						<%
							for(AirFlights airf: allfts)
							{
								if(airf.getFlightId()==fid)
								{
						%>
						<td><%= airf.getFlightName() %></td>
						<td><%= tdate %></td>
						<td><%= from %></td>
						<td><%= to %></td>
						<td>&#8377; <%= airf.getTicketPrice() %> </td>
						
						<td><%= totalPassengers %></td>
						<!-- <td>
							<a href="">
								<button class="btn btn-danger">Remove</button>
							</a>
						</td> -->
					</tr>
					<%-- <%
								}
							}
					/* }
					} */
					%> --%>
				</tbody>
			</table>
			<div class="d-flex py-3">
				<h3>Total Price: &#8377; <%= airf.getTicketPrice() * totalPassengers %></h3>
				<!-- <a class="mx-3 btn btn-primary" href="PaymentServlet">Checkout</a> -->
				<a class="mx-3 btn btn-primary" href="payment.jsp">Checkout</a>
			</div>
						<%		
								}
							}
						%>
						<%		
								}
							}
						%>
	</div>
	
</body>
</html>
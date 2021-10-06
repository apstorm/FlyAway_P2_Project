<%
	Users u=(Users)session.getAttribute("current_user");
	if(u==null)
	{
		response.sendRedirect("login.jsp");
		return;
	}
%>

<!DOCTYPE htlm>
<html>
<head>
	<title>FlyAway</title>
	<%@ include file="components/common_css_js.jsp" %>
</head>
<body style="background-image: url('image/booking.jpg');background-size: cover;">
<%@include file="components/navbar.jsp" %>
<div class="continer">
		<div class="row" style="margin-top: 5px;">
			<div class="col-md-6 offset-md-3">
				<div class="card mt-3" style="background-image: url('');">
					<div class="card-header text-white custom-bg">
						<h3>Fill Travel details</h3>
					</div>
					<div class="card-body" style="background-image: url(''); background-size: cover;">
						<form action="availableFlights" method="post" style="border-color: black;">
							<div class="form-group">
								<label for="exampleInputEmail1">Date of Travel</label> 
								<input	name="tdate"
										type="date" class="form-control"
										id="exampleInputEmail1"
										aria-describedby="emailHelp" 
										placeholder="select date">
							</div>
							<div class="form-group">
								<label for="from">Origin station or city</label> 
								<input	name="from"
										type="text" class="form-control" 
										id="from"
										placeholder="enter place from where you want to travel">
							</div>
							<div class="form-group">
								<label for="to">Destination station or city</label> 
								<input	name="to"
										type="text" class="form-control" 
										id="to"
										placeholder="enter place from where you want to travel">
							</div>
								<div class="form-group">
								<label for="totalPassengers">Number of Persons</label> 
								<input	name="totalPassengers" value="1"
										type="text" class="form-control" 
										id="to" disabled="disabled"
										placeholder="enter total no of Passengers">
							</div>
							<!-- <div class="form-check">
								<input type="checkbox" class="form-check-input" id="exampleCheck1">
								<label class="form-check-label" for="exampleCheck1">Check
									me out</label>
							</div> -->
							
							<div class="container text-center">
										<button type="submit" class="btn btn-primary custom-bg border-0">Submit</button>
										<button type="reset" class="btn btn-primary custom-bg border-0">Reset</button>
							</div>
						</form>
					</div>
				</div>
				
			</div>
		</div>
	</div>
</body>
</html>

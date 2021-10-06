<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User</title>
<%@ include file="components/common_css_js.jsp" %>
<style>
.reg-img-center {
	display: block;
	margin-left: auto;
	margin-right: auto;
	width: 50%;
}
</style>
</head>
<body style="background-image: url('image/airplane-flight.jpg');background-size: cover;">
	<%@include file="components/navbar.jsp" %>
		<div class="container-fluid">
			<div class="row mt-5">
				<div class="col-md-4 offset-md-4">
					<div class="card" style="border-color: black; background-color: gray;">
					   <%@ include file="components/message.jsp" %>
						<img class="reg-img-center" alt="register here" src="image/clipboard.png">
						<div class="card-body px-5">
							<h3 class="text-center">Fill Passenger Details here</h3>
							
							<form action="PassengerServlet" method="post">
								<div class="form-group">
									<label for="name">Passenger Name</label> <input type="text"
										class="form-control" id="name" name="pName"
										placeholder="Enter name">
								</div>
								<div class="form-group">
									<label for="name">Passenger Email</label> <input type="email"
										class="form-control" id="email" name="pEmail"
										aria-describedby="emailHelp" placeholder="Enter email">
								</div>
								
								<div class="form-group">
									<label for="phone">Contact Number</label> <input type="number"
										class="form-control" id="number" name="pPhone"
										placeholder="Enter number">
								</div>
								<div class="form-group">
									<label for="address">Passenger Age</label>
									<input type="number" class="form-control"
										name="pAge" placeholder="enter your age here" />
								</div>
								
								<!-- ________________________________________ -->
								<div class="container text-center">
									<button type="submit" class="btn btn btn-dark"
										style="color: green; background-color: #C7CCCD">Submit</button>
									<button type="reset" class="btn btn btn-dark"
										style="color: #000066; background-color: #C7CCCD">Reset</button>
								</div>
								
							</form>
							
						</div>
					</div>
				</div>
			</div>
		</div>
</body>
</html>
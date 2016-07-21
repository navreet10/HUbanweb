<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="javascripts/home.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script src="http://mymaplist.com/js/vendor/TweenLite.min.js"></script>
<link rel="stylesheet" href="css/style.css" />
</head>
<body class ="loginBody">
	

		<div class="container">
			<c:set var="mesL" scope="session" value="${message}" />
			<c:if test="${mesL != null}">
				<div class="alert alert-success">
					<strong>${message}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>

			<div class="row vertical-offset-100">
				<div class="col-md-4 col-md-offset-4">
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: white;">
							<div class="row-fluid user-row" style="background-color: white;" align="center">
								 <img alt="Harrison university" src="images/logo.png" width="80px" class="responsive">
									
							</div>
						</div>
						<div class="panel-body">
							<div role="form" class="form-signin">
								<fieldset>
									<label class="panel-login">
										<div class="login_result"></div>
									</label> 
										<form action="StudentHome" method="post">
										<input class="form-control" placeholder="Username" id="name"
										name="name" type="text"> 
										
										<input class="form-control"
										placeholder="Password" id="password" name="password"
										type="password"> 
										<select id="type" name="type" style="width: 320px;">
										<option value="Student">Student</option>
										<option value="Faculty">Faculty</option>
										</select>
										
										<br></br> 								
			
										
										<input
										class="btn btn-lg btn-success btn-block" type="submit"
										id="login" value="Login »">
										</form>
									<div class="login-help">
										<a href="#">Register</a> - <a href="registration.jsp">Are
											you a new user? Click here</a>
									</div>
								</fieldset>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

</body>
</html>
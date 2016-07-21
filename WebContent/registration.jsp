<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

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
<link rel="stylesheet" href="css/style.css" />
<title>Registration</title>
</head>
<body class="body">
	<form action="Registration" method="post">
		<div class="container">
			<br> <br>
			<jsp:include page="navbar.jsp" />
			<div style="background-color: white;" class="panel-body">
				<div class="row">
					<div class="col-sm-2">
						<img src="${gBigUrl}" alt="${user.name}" />
					</div>
					<div class="col-sm-10"></div>

				</div>
				<c:set var="mes" scope="session" value="${message}" />
				<c:if test="${mes != null}">
					<div class="alert alert-success">
						<strong>${message}</strong> <span id="showSearchTerm"></span>
					</div>
				</c:if>

				<div class="row">
					<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div align="left">Add Below details</div>

							</div>
							<div class="panel-body">



								<table>

									<tr>
										<th>Name:</th>
										<th><input type="text" id="name" name="name" value=""
											placeholder="add name"></input></th>
									</tr>

									<tr>
										<th>Email:</th>
										<th><input type="text" id="email" name="email" value=""
											placeholder="add email"></input></th>
									</tr>

									<tr>
										<th>Password:</th>
										<th><input type="password" id="password" name="password"
											value="" placeholder="add password"></input></th>
									</tr>

									<tr>
										<th>Zip:</th>
										<th><input type="text" id="zip" name="zip" value=""
											placeholder="add zip"></input></th>
									</tr>

								</table>
							</div>
							<div class="panel-footer">
								<div id="text"></div>
								<div align="right">
									<input type="submit" name="submit" id="submit" value="Register"></input>
								</div>
							</div>
						</div>



					</div>
					<div class="col-sm-3"></div>
				</div>

			</div>

		</div>




	</form>

</body>
</html>
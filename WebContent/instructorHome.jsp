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

<script src="javascripts/filter.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/styleC.css" />

<link rel="stylesheet"
	href="https://code.jquery.com/ui/1.12.0/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://jqueryui.com/resources/demos/style.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.0/jquery-ui.js"></script>
<style>
#draggable {
	width: 0px;
	height: 0px;
	padding: 0em;
}

#resizable {
	width: 150px;
	height: 150px;
	padding: 0.5em;
}

#resizable h3 {
	text-align: center;
	margin: 0;
}

#red, #green, #blue {
	float: left;
	clear: left;
	width: 300px;
	margin: 15px;
}

#swatch {
	width: 120px;
	height: 100px;
	margin-top: 18px;
	margin-left: 350px;
	background-image: none;
}

#red .ui-slider-range {
	background: #ef2929;
}

#red .ui-slider-handle {
	border-color: #ef2929;
}

#green .ui-slider-range {
	background: #8ae234;
}

#green .ui-slider-handle {
	border-color: #8ae234;
}

#blue .ui-slider-range {
	background: #729fcf;
}

#blue .ui-slider-handle {
	border-color: #729fcf;
}
</style>
<title>Welcome</title>
</head>
<body id="body" class="ui-widget-content" style="border: 0;">
	<div class="container">

		<br> <br>
		<jsp:include page="navbar.jsp" />

		<div style="background-color: white;" class="panel-body">



			<c:set var="mes" scope="session" value="${message}" />
			<c:if test="${mes != null}">
				<div class="alert alert-success">
					<strong>${message}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>


			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-8">
					<h3>Welcome ${user.username}!!</h3>
					<br> <br>
					<%-- <c:set var="res" scope="session" value="${result}" />
						<c:if test="${res != null}"> --%>
					<div id="accordion">
						<h3>View Your Classes</h3>
						<div> 
								<table class="table table-striped">
									<thead>
										<tr>
											<th>CRN</th>
											<th>Course</th>
											<th>Days</th>
											<th>Instructor</th>
											<th>Time</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="result" items="${classesInst}">
											<tr>
												<td>${result.crnid}</td>
												<td>${result.course.name}</td>
												<td>${result.days}</td>
												<td>Prof ${result.instructor.huuser.firstname}
													${result.instructor.huuser.lastname}</td>
												<td>${result.timeofclass}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							
						</div>
						<h3>Student Details</h3>
						<div>
							<c:forEach var="result1" items="${studentDetails}">
								<table class="table table-striped">
									<thead>
										<tr>
											<th>CRN</th>
											<th>Course</th>
											<th>Days</th>
											<th>Instructor</th>
											<th>Time</th>
										</tr>
									</thead>

									<tbody>
										
											<tr>
												<td>${result1.key.crnid}</td>
												<td>${result1.key.course.name}</td>
												<td>${result1.key.days}</td>
												<td>Prof ${result1.key.instructor.huuser.firstname}
													${result1.key.instructor.huuser.lastname}</td>
												<td>${result1.key.timeofclass}</td>
											</tr>
										
									</tbody>
								</table>
								<table class="table table-striped">
									<thead>
										<tr>
											<th>ID</th>
											<th>First Name</th>
											<th>last Name</th>
											<th>Email</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="student" items="${result1.value}">
											<tr>
												<td>${student.studentid}</td>
												<td>${student.huuser.firstname}</td>
												<td>${student.huuser.lastname}</td>
												<td>${student.huuser.email}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								</c:forEach>
						</div>
						
						<h3>View All Courses</h3>
						<div>
							Days: 1- Mon, 2-Tue, 3- Wed, 4-Thu, 5-Fri, 6-Sat
							<table class="table table-striped">
								<thead>
									<tr>
										<th>CRN</th>
										<th>Course</th>
										<th>Days</th>
										<th>Instructor</th>
										<th>Time</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach var="result" items="${classes}">
										<tr>
											<td>${result.crnid}</td>
											<td>${result.course.name}</td>
											<td>${result.days}</td>
											<td>Prof ${result.instructor.huuser.firstname}
												${result.instructor.huuser.lastname}</td>
											<td>${result.timeofclass}</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						
					</div>

				</div>
				<div class="col-sm-2"></div>
			</div>

		</div>

	</div>




</body>
</html>
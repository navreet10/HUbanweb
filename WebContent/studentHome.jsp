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
						<h3>Enroll Classes</h3>
						<div> 
							<form id="enroll" action="EnrollClass" method="post">
								Days: 1- Mon, 2-Tue, 3- Wed, 4-Thu, 5-Fri, 6-Sat
								<table class="table table-striped">
									<thead>
										<tr>
											<th></th>
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
												<td><input type="checkbox" name="enrollChecks" value="enroll${result.crnid}"></td>
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
								<input type="submit" id="register" name="register"
									value="Register">
							</form>
						</div>
						<h3>Drop Class</h3>
						<div>
							<form id="drop" action="DropClass" method="post">
								<table class="table table-striped">
									<thead>
										<tr>
											<th></th>
											<th>CRN</th>
											<th>Course</th>
											<th>Days</th>
											<th>Instructor</th>
											<th>Time</th>
										</tr>
									</thead>

									<tbody>
										<c:forEach var="result1" items="${classesRegistered}">
											<tr>
												<td><input type="checkbox" id="drop${result1.crnid }" name ="dropChecks" 
												value="drop${result1.crnid}"></td>
												<td>${result1.crnid}</td>
												<td>${result1.course.name}</td>
												<td>${result1.days}</td>
												<td>Prof ${result1.instructor.huuser.firstname}
													${result1.instructor.huuser.lastname}</td>
												<td>${result1.timeofclass}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<input type="submit" id="drop" name="drop" value="Drop">
							</form>
						</div>
						<h3>View Schedule</h3>
						<div>
							<table class="table table-striped">
								<tbody>
									<c:forEach var="result2" items="${classeSchedule}">
										<tr>
											<td>${result2.key}</td>
											<td><table width="100%">
													<c:forEach var="subs" items="${result2.value}">
														<tr>
															<td>${subs.crnid}</td>
															<td>${subs.course.name}</td>
															<td>Prof ${subs.instructor.huuser.firstname}
																${subs.instructor.huuser.lastname}</td>
															<td>${subs.timeofclass}:00</td>
														</tr>
													</c:forEach>
												</table></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
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
						<h3>Ask Queries</h3>
						<div>
							<form id="ask" action="SendQuery" method="post">
								<div class="form-group">
									<label for="typeAssgn">Faculty Username:</label> <input
										type="text" id="insEmail" name="insEmail" value=""
										class="form-control">
								</div>
								<div class="form-group">
									<label for="typeAssgn">Ask your Question:</label>
									<textarea id="content" name="content" rows="10" cols="10"
										class="form-control"></textarea>
								</div>
								<input type="submit" id="email" name="email" value="Send">
							</form>
						</div>
					</div>

				</div>
				<div class="col-sm-2"></div>
			</div>



		</div>

	</div>




</body>
</html>
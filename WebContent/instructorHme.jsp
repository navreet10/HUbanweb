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
<body id ="body" class="ui-widget-content" style="border: 0;">

	<div class="container">

		<br> <br>
		<jsp:include page="navbar.jsp" />

		<div style="background-color: white;" class="panel-body">
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<p class="ui-state-default ui-corner-all ui-helper-clearfix"
						style="padding: 4px;">
						<span class="ui-icon ui-icon-pencil"
							style="float: left; margin: -2px 5px 0 0;"></span> Pick
						Background
					</p>

					<div id="red"></div>
					<div id="green"></div>
					<div id="blue"></div>

					<div id="swatch" class="ui-widget-content ui-corner-all"></div>
				</div>
				<div class="col-sm-4"><div id="draggable" class="ui-widget-content">
							<img src="images/shin.jpeg" alt="Drag Me" />
						</div></div>
			</div>



			<c:set var="mes" scope="session" value="${message}" />
			<c:if test="${mes != null}">
				<div class="alert alert-success">
					<strong>${message}</strong> <span id="showSearchTerm"></span>
				</div>
			</c:if>
			<form id="target" action="Insert" method="post">

				<div class="row">
					<div class="col-sm-2">
						
					</div>
					<div class="col-sm-8">
						<h2>Welcome Professor!!</h2>
						<br> <br>
						<c:set var="res" scope="session" value="${result}" />
						<c:if test="${res != null}">
							<div id="accordion">
								<h3>Results:</h3>
								<div>

									<table class="table table-striped">
										<thead>
											<tr>
												<th>Student ID</th>
												<th>Assignment Name</th>
												<th>Assignment Type</th>
												<th>Assignment date</th>
												<th>Grade</th>
											</tr>
										</thead>

										<tbody>
											<c:forEach var="result" items="${result}">
												<tr>
													<td>${result.studentId}</td>
													<td>${result.assignmentName}</td>
													<td>${result.typeassignment.type}</td>
													<td>${result.assdate}</td>
													<td>${result.grade}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<h3>Random:</h3>
								<div>
									<p>Mauris mauris ante, blandit et, ultrices a, suscipit
										eget, quam. Integer ut neque. Vivamus nisi metus, molestie
										vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec
										suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur
										malesuada. Vestibulum a velit eu ante scelerisque vulputate.</p>
								</div>
							</div>
						</c:if>
						<c:set var="avg" scope="session" value="${average}" />
						<c:if test="${avg != null}">
							<h2>Results:</h2>
							Average is: <c:out value="${average}"></c:out>
						</c:if>

						<c:set var="high" scope="session" value="${high}" />
						<c:if test="${high != null}">
							<h2>Results:</h2>
							Highest Score is: <c:out value="${high}"></c:out>
							Minimum Score is: <c:out value="${low}"></c:out>
						</c:if>
						<br> <br>
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div align="left">Insert New user</div>

							</div>
							<div class="panel-body">
								<div class="form-gr$('#date').datepicker(oup">
									<label for="studentId">Student ID:</label> <input type="text"
										class="form-control" id="studentId" name="studentId" value="">
								</div>
								<div class="form-group">
									<label for="typeAssgn">Assignment type:</label> <input
										type="text" id="typeAssgn" name="typeAssgn" value=""
										class="form-control">
								</div>
								<div class="form-group">
									<label for="assgnName">Assignment Name:</label> <input
										type="text" id="assgnName" name="assgnName" value=""
										class="form-control">
								</div>
								<div class="form-group">
									<label for="date">Date of Assignment(MM/dd/yyyy):</label>
									<div>
										<p>
											<input type="text" id="datepicker" name="datepicker" value=""
												class="form-control">
										</p>
									</div>
									<!-- <script>
										jQuery(function() {
											jQuery("#datepicker").datepicker();
										});
									</script> -->
								</div>
								<div class="form-group">
									<label for="grade">Grade:</label> <input type="text" id="grade"
										name="grade" value="" class="form-control">
								</div>
							</div>
							<div class="panel-footer">
								<div id="text"></div>
								<div align="right">
									<input type="submit" id="submit" value="Insert">
								</div>
							</div>
						</div>

						<div class="panel panel-primary">
							<div class="panel-heading">
								<div align="left">Report Filters</div>

							</div>
							<div class="panel-body">
								<div class="form-group">
									<label for="student">Student ID:</label> <input type="text"
										id="student" name="student" value="" class="form-control">
								</div>
								<div class="form-group">
									<label for="type">Assignment Type:</label> <input type="text"
										id="type" name="type" value="" class="form-control">
								</div>
							</div>
							<div class="panel-footer">
								<div id="text"></div>
								<div align="right">
									<input type="button" id="average" name="average"
										value="Average"> <input type="button" id="assignments"
										name="assignments" value="Assignments"> <input
										type="button" id="highLow" name="highLow"
										value="High Low Score">
								</div>
							</div>
						</div>
						<br> <br>

					</div>
					<div class="col-sm-2"></div>
				</div>
			</form>


		</div>

	</div>


	<%-- <form id="target" action="Insert" method="post">
		<a href="<%=request.getContextPath()%>/Logout"><span
			class="glyphicon glyphicon-log-in"></span> LogOut</a> <input type="text"
			id="studentId" name="studentId" value=""
			placeholder="Enter Student ID"> <input type="text"
			id="typeAssgn" name="typeAssgn" value=""
			placeholder="Enter Type of Assignment"> <input type="text"
			id="assgnName" name="assgnName" value=""
			placeholder="Enter Assignment Name"> <input type="text"
			id="date" name="date" value=""
			placeholder="Enter Date of Assignment in MM/dd/yyyy format">
		<input type="text" id="grade" name="grade" value=""
			placeholder="Enter Grade"> <input type="submit" id="submit"
			value="Insert">

		
		<h4>Filters:</h4>
		<input type="text" id="student" name="student" value=""
			placeholder="Enter Student ID"> <input type="text" id="type"
			name="type" value="" placeholder="Enter Type of Assignment">
		<input type="button" id="average" name="average" value="Average">
		<input type="button" id="assignments" name="assignments"
			value="Assignments"> <input type="button" id="highLow"
			name="highLow" value="High Low Score">

		
	</form>
	
	<c:set var="avg" scope="session" value="${average}" />
	<c:if test="${avg != null}">
		Average is: <c:out value="${average}"></c:out>
	</c:if>

	<c:set var="high" scope="session" value="${high}" />
	<c:if test="${high != null}">
		Highest Score is: <c:out value="${high}"></c:out>
		Minimum Score is: <c:out value="${low}"></c:out>
	</c:if> --%>

</body>
</html>
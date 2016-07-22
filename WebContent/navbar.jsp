<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><img alt="" src="images/huLogo.png" width="50px"> </a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="<%=request.getContextPath()%>/login.jsp">Home</a></li>
      
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <c:set var="user" scope="session" value="${user}"/>
    <c:if test="${user == null}">
      <li><a href="registration.jsp"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login.jsp"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
     
      </c:if>
      <c:if test="${user != null}"> 
      <li><span class="glyphicon glyphicon-user"></span> Welcome ${user.username}</li>
      <li><a href="<%=request.getContextPath()%>/Logout"><span class="glyphicon glyphicon-log-in"></span> LogOut</a></li>
     
      </c:if>
    </ul>
  </div>
</nav>
  


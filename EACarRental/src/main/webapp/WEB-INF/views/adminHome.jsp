<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %><%-- 
<%@ page session="false" %> --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<div>
 <a href="${pageContext.request.contextPath}/welcome">Home</a>
 
  | &nbsp;
   <a href="/EACarRental/admin/addUser">Add User</a>
  
  | &nbsp;
  
   <a href="/EACarRental/admin/userList">List User</a>
  
  | &nbsp;
  
  <a href="/EACarRental/car/addCar">Add Car</a>
   | &nbsp;
   
  <a href="/EACarRental/car/carList">List Car</a>
  <c:if test="${pageContext.request.userPrincipal.name != null}">
  
     | &nbsp;
     <a href="${pageContext.request.contextPath}/logout">Logout</a>
     
  </c:if>


</div>

<h3>Welcome Admin @ ${pageContext.request.userPrincipal.name}</h3>
<%-- <h1>${Iuser}</h1>
<h1>${email}</h1> --%>

<P>  The time on the server is ${serverTime}. </P>
<!-- <h1><a href="/EACarRental/admin/addUser">Employee register</a></h1>
<h1><a href="/EACarRental/admin/userList">All Users</a></h1>
<h1><a href="/EACarRental/user/signUp">User Signup</a></h1>
<h1><a href="/EACarRental/car/carList">List Car</a></h1>
<h1><a href="/EACarRental/car/addCar">Add Car</a></h1> -->
</body>
</html>

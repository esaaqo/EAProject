<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Users List</title>
</head>
<body>
<h1>${message }</h1>
<div>
<table border="2" bordercolor="red">
<thead>
    <tr>
      <th>Name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>UserName</th>
      <th>Address</th>
      <th>Edit</th>
      <th> Delete</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${users }" var="user">
  <tr>
 <td>${user.firstName}</td>
 <td>${user.lastName}</td>
 <td>${user.email}</td>
 <td>${user.userName }</td>
 <td>${user.address.address  } ${user.address.city} ${user.address.state } ${user.address.zip }</td>
 <td><a href="edit/${user.id }"><button action="/edit" >Edit</button></a></td>
 <td><a href="delete/${user.id }"><button action="/delete" >Delete</button></a></td>
 
  
  </tr>
  
  </c:forEach>
  </tbody>

</table>


</div>
<a href="addUser"><input type="button" value="Add User"></a>

</body>
</html>
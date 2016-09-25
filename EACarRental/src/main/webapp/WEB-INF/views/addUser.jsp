<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
</head>
<body>
<form:form modelAttribute="user" action="addUser" method="post">
FirstName:<form:input path="firstName" type="text"/><br>
LastName:<form:input path="lastName" type="text"/><br>
Email:<form:input path="email" type="text" /><br>
Password:<form:input path="password" type="password" /><br>
UserName: <form:input path="userName" type="text" /><br>
City:<form:input path="address.city" type="text" /><br>
State:<form:input path="address.state" type="text" /><br>
ZIP:<form:input path="address.zip" type="text" /><br>
Address:<form:input path="address.address" type="text" />	<br>		
<form:button value="Add User" name="submit" >Add User</form:button>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<form action="UpdateUserServlet" method="post">
		Name: <input type="text" name="name" value="${Userbean.name}" />
		<Br>
		Email :<input type="text" name="email" value="${Userbean.email}" /><Br>
		Password: <input type="text" name="password" value="${Userbean.password }" /><Br> <input type="hidden"
			name="User_id" value="${Userbean.userId}"> <input
			type="submit" value="Update User">
	</form>

	<br>
	<a href="homeadmin.jsp">Go back to home page</a>
</body>
</html>
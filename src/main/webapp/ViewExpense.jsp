<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Expense</title>
<style>
.center {
	margin: auto;
	width: 40%;
	/* border: 0px solid #000000; */
	padding: 10px;
	align-content: center;
	
}
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
	<%
	ResultSet rs = (ResultSet) request.getAttribute("rs");
	rs.next();
	%>
	<div class="center">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Date</th>
					<th scope="col">Category_ID</th>
					<th scope="col">SubCategory_ID</th>
					<th scope="col">Expense_ID</th>
					<th scope="col">Expense_Name</th>
					<th scope="col">Amount</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td scope="col"><%=rs.getString(1)%></td>
					<td><%=rs.getInt(3)%></td>
					<th scope="row"><%=rs.getInt(4)%></th>
					<th scope="row"><%=rs.getInt(5)%></th>
					<td><%=rs.getString(6)%></td>
					<td><%=rs.getFloat(7)%></td>
				</tr>
				</tbody>
				</table>
				</div>
</body>
</html>
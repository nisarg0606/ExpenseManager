<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>


<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Bitter:400,700">
<link rel="stylesheet" href="assets/css/homestyle.css">
</head>

<body>
	<div>
		<div class="header-dark">
			<nav
				class="navbar navbar-dark navbar-expand-md navigation-clean-search">
				<div class="container">
					<a class="navbar navbar-light bg-dark navbar-brand" href="#">Expense
						Manager App</a>
					<button class="navbar-toggler" data-toggle="collapse"
						data-target="#navcol-1">
						<span class="sr-only">Toggle navigation</span><span
							class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navcol-1">
						<ul class="nav navbar-nav">
							<li class="nav-item" role="presentation"><a class="nav-link"
								href="#">Link</a></li>
							<li class="dropdown"><a
								class="dropdown-toggle nav-link dropdown-toggle"
								data-toggle="dropdown" aria-expanded="false" href="#">Dropdown
							</a>
								<div class="dropdown-menu" role="menu">
									<a class="dropdown-item" role="presentation" href="#">First
										Item</a><a class="dropdown-item" role="presentation" href="#">Second
										Item</a><a class="dropdown-item" role="presentation" href="#">Third
										Item</a>
								</div></li>
						</ul>
						<form class="form-inline mr-auto" target="_self">
							<div class="form-group">
								<label for="search-field"><i class="fa fa-search"></i></label><input
									class="form-control search-field" type="search" name="search"
									id="search-field">
							</div>
						</form>
						<span class="navbar-text"> <!-- <a href="#" class="login">Log In</a> -->
						</span><a class="btn btn-light action-button" role="button"
							href="LogoutServlet">Log Out</a>
					</div>
				</div>
			</nav>
			<div class="container hero">
				<div class="row">
					<div class="col-md-10 offset-md-2">
						<h1 class="text-center bg-info text-white">Welcome , User
							${username}, ${id}</h1>
						<h2 class="p-3 mb-2 bg-light text-dark">Expense's Table</h2>
						<div class="text-center">
							<table border="1" class="table table-striped table-dark">
								<thead>
									<tr>
										<th>Date</th>
										<th>Category Name</th>
										<th>SubCategory Name</th>
										<th>Expense Name</th>
										<th>Amount</th>
										<th>Delete/View/Edit</th>
									</tr>
								</thead>
								<tbody>
									<%
									ResultSet rs = (ResultSet) request.getAttribute("expenseTable");
									%>
									<%
									if (rs != null) {

										while (rs.next()) {
											String date = rs.getString(1);
											String categoryname = rs.getString(2);
											String subcategoryname = rs.getString(3);
											String expensename = rs.getString(5);
											float amount = rs.getFloat(6);
											int expenseid = rs.getInt(4);
									%>

									<tr>
										<td><%=date%></td>
										<td><%=categoryname%></td>
										<td><%=subcategoryname%></td>
										<td><%=expensename%></td>
										<td><%=amount%></td>
										<td><a
											href="DeleteExpenseServlet?Expense_ID=<%=expenseid%>">Delete</a>
											| <a href="ViewExpenseServlet?Expense_ID=<%=expenseid%>">View</a>
											| <a href="EditExpenseServlet?Expense_ID=<%=expenseid%>">Edit</a></td>
									</tr>
									<%
									}
									} else {

									}
									%>
									<tr>
										<td colspan="6"><a href="AddExpense.jsp">Add New
												Expense</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>


		</div>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/js/bootstrap.bundle.min.js"></script>
</body>

</html>
<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.util.DBConnection"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
						<h1 class="text-center bg-info text-white">Welcome , Admin
							${username}</h1>
						<h2 class="p-3 mb-2 bg-light text-dark">User's Table</h2>
						<div class="text-center">
							<table border="1" class="table table-striped table-dark">
								<thead>
									<tr>
										<th>UserID</th>
										<th>Name</th>
										<th>Email</th>
										<th>User_type</th>
										<th>Delete/View/Edit</th>
									</tr>
								</thead>
								<tbody>
									<%
									Connection con = DBConnection.getConnection();
									Statement statement = con.createStatement();
									ResultSet rs = statement.executeQuery("select * from users");
									%>
									<%
									while (rs.next()) {
										int userid = rs.getInt(1);
										String name = rs.getString(2);
										String email = rs.getString(3);
										String usertype = rs.getString(5);
									%>
									<tr>
										<td><%=userid%></td>
										<td><%=name%></td>
										<td><%=email%></td>
										<td><%=usertype%></td>
										<td><a href="DeleteUserServlet?User_id=<%=userid%>">Delete</a>
											| <a href="ViewUserServlet?User_id=<%=userid%>">View</a> | <a
											href="EditUserServlet?User_id=<%=userid%>">Edit</a></td>
									</tr>
									<%
									}
									%>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="container hero">
				<div class="row">
					<div class="col-md-10 offset-md-2">
						<h2 class="p-3 mb-2 bg-light text-dark">Category's Table</h2>
						<div class="text-center">
							<table border="1" class="table table-striped table-dark">
								<thead>
									<tr>
										<th>Category_Id</th>
										<th>Category_Name</th>
										<th>Delete/View/Edit</th>
									</tr>
								</thead>
								<tbody>
									<%
									rs = statement.executeQuery("select * from category order by 1");
									%>
									<%
									while (rs.next()) {
										int categoryid = rs.getInt(1);
										String categoryname = rs.getString(2);
									%>
									<tr>
										<td><%=categoryid%></td>
										<td><%=categoryname%></td>
										<td><a
											href="DeleteCategoryServlet?Category_ID=<%=categoryid%>">Delete</a>
											| <a href="ViewCategoryServlet?Category_ID=<%=categoryid%>">View</a>
											| <a href="EditCategoryServlet?Category_ID=<%=categoryid%>">Edit</a></td>
									</tr>
									<%
									}
									%>
									<tr>
										<td colspan="3"><a href="AddCategory.jsp">Add New
												Category</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
			
			
			<div class="container hero">
				<div class="row">
					<div class="col-md-10 offset-md-2">
						<h2 class="p-3 mb-2 bg-light text-dark">Sub-Category's Table</h2>
						<div class="text-center">
							<table border="1" class="table table-striped table-dark">
								<thead>
									<tr>
										<th>SubCategory_ID</th>
										<th>Category_ID</th>
										<th>SubCategory_Name</th>
										<th>Delete/View/Edit</th>
									</tr>
								</thead>
								<tbody>
									<%
									rs = statement.executeQuery("select * from sub_category order by 1");
									%>
									<%
									while (rs.next()) {
										int subcategoryid = rs.getInt(1);
										int categoryid = rs.getInt(2);
										String subcategoryname = rs.getString(3);
									%>
									<tr>
										<td><%=subcategoryid%></td>
										<td><%=categoryid%></td>
										<td><%=subcategoryname%></td>
										<td><a
											href="DeleteSubCategoryServlet?SubCategory_ID=<%=subcategoryid%>">Delete</a>
											| <a href="ViewSubCategoryServlet?SubCategory_ID=<%=subcategoryid%>">View</a>
											| <a href="EditSubCategoryServlet?SubCategory_ID=<%=subcategoryid%>">Edit</a></td>
									</tr>
									<%
									}
									%>
									<tr>
										<td colspan="4"><a href="AddSubCategory.jsp">Add New
												SubCategory</a></td>
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
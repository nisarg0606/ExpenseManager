package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;
@WebServlet("/ListAllUsers")
public class ListAllUsers extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from users");
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("rs", rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("homeadmin.jsp");
		rd.forward(request, response);
	}
}

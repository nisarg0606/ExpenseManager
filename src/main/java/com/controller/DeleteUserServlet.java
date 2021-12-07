package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int User_id = Integer.parseInt(request.getParameter("User_id"));
		int i = -1;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from users where User_id=?");
			pstmt.setInt(1, User_id);
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RequestDispatcher rd = null;
		
		if(i == 1)
		{
			rd =request.getRequestDispatcher("homeadmin.jsp");
		}
		else {
			request.setAttribute("error", "Invalid User Id");
			rd = request.getRequestDispatcher("fail.jsp");
		}
		
		rd.forward(request, response);
	}
}


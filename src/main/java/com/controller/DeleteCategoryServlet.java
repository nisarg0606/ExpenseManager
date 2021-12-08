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
@WebServlet("/DeleteCategoryServlet")
public class DeleteCategoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int CategoryId = Integer.parseInt(request.getParameter("Category_ID"));
		int i = -1;
		try {
			Connection con = DBConnection.getConnection();
			PreparedStatement pstmt = con.prepareStatement("delete from category where Category_ID=?");
			pstmt.setInt(1, CategoryId);
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
			request.setAttribute("error", "Invalid Category Id");
			rd = request.getRequestDispatcher("fail.jsp");
		}
		
		rd.forward(request, response);
	}
}


package com.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.DBConnection;

@WebServlet("/ViewSubCategoryServlet")
public class ViewSubCategoryServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int SubCategoryID = Integer.parseInt(request.getParameter("SubCategory_ID"));
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("Select * from sub_category where SubCategory_ID=?");
			pstmt.setInt(1, SubCategoryID);
			
			ResultSet rs = pstmt.executeQuery();
			request.setAttribute("rs", rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("ViewSubCategory.jsp").forward(request, response);
	}
}

package com.controller;

import java.io.IOException;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;
// import com.util.DBConnection;

@WebServlet("/EditSubCategoryServlet")
public class EditSubCategoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int subcategoryId = Integer.parseInt(request.getParameter("SubCategory_ID"));
		SubCategoryDao dao = new SubCategoryDao();
		SubCategoryBean SubCategorybean = dao.getSubCategoryById(subcategoryId);
		request.setAttribute("SubCategorybean", SubCategorybean);
		request.getRequestDispatcher("EditSubCategory.jsp").forward(request, response);
	}
}

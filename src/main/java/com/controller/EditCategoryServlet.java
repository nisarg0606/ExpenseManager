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

import com.bean.CategoryBean;
import com.bean.UserBean;
import com.dao.CategoryDao;
import com.dao.UserDao;
// import com.util.DBConnection;

@WebServlet("/EditCategoryServlet")
public class EditCategoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("Category_ID"));
		CategoryDao dao = new CategoryDao();
		CategoryBean Categorybean = dao.getCategoryById(categoryId);
		request.setAttribute("Categorybean", Categorybean);
		request.getRequestDispatcher("EditCategory.jsp").forward(request, response);
	}
}

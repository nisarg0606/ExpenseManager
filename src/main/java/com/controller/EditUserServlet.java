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

import com.bean.UserBean;
import com.dao.UserDao;
// import com.util.DBConnection;

@WebServlet("/EditUserServlet")
public class EditUserServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("User_id"));
		UserDao dao = new UserDao();
		UserBean Userbean = dao.getUserById(userId);
		request.setAttribute("Userbean", Userbean);
		request.getRequestDispatcher("EditUser.jsp").forward(request, response);
	}
}

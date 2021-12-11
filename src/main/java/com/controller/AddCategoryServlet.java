package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.dao.CategoryDao;
@WebServlet("/AddCategoryServlet")
public class AddCategoryServlet extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String categoryName = request.getParameter("categoryName");
		
		CategoryBean categoryBean  = new CategoryBean();
		categoryBean.setCategoryName(categoryName);
		
		int i = 0;
		
		CategoryDao categoryDao = new CategoryDao();
		i = categoryDao.insertCategoryByName(categoryBean);
		
		RequestDispatcher rd = null;
		if(i == 1)
		{
			rd = request.getRequestDispatcher("homeadmin.jsp");
		}
		else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		rd.forward(request, response);
	}
}

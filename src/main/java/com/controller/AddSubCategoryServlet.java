package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.CategoryBean;
import com.bean.SubCategoryBean;
import com.dao.CategoryDao;
import com.dao.SubCategoryDao;

@WebServlet("/AddSubCategoryServlet")
public class AddSubCategoryServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String subcategoryName = request.getParameter("subcategoryName");
		
		int i = -1;
		SubCategoryBean subcategoryBean  = new SubCategoryBean();
		subcategoryBean.setCategoryId(categoryId);
		subcategoryBean.setSubcategoryName(subcategoryName);
		
		SubCategoryDao subcategoryDao = new SubCategoryDao();
		i = subcategoryDao.insertSubCategory(subcategoryBean);
		
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

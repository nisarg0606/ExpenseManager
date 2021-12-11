package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.SubCategoryBean;
import com.dao.SubCategoryDao;

@WebServlet("/UpdateSubCategoryServlet")
public class UpdateSubCategoryServlet extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("SubCategory_Name");
		int categoryId = Integer.parseInt(request.getParameter("Category_ID"));
		int userId = Integer.parseInt(request.getParameter("SubCategory_ID"));

		SubCategoryBean subcategoryBean = new SubCategoryBean();
		subcategoryBean.setSubcategoryName(Name);
		subcategoryBean.setCategoryId(categoryId);
		subcategoryBean.setSubcategoryId(userId);

		int i = 0;

		 SubCategoryDao subcategoryDao = new SubCategoryDao();
		i = subcategoryDao.UpdateSubCategory(subcategoryBean);

		RequestDispatcher rd = null;
		if (i == 1) {
			rd = request.getRequestDispatcher("homeadmin.jsp");
		} else {
			rd = request.getRequestDispatcher("fail.jsp");
		}
		rd.forward(request, response);
	}
}
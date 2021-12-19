package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bean.ExpenseBean;
import com.util.DBConnection;

public class ExpenseDao {
	public ExpenseBean getExpenseById(int ExpenseId) {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select *from expense where Expense_ID=?");
			pstmt.setInt(1, ExpenseId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			ExpenseBean eb = new ExpenseBean();
			eb.setExpenseId(rs.getInt("Expense_ID"));
			eb.setCategoryId(rs.getInt("Category_ID"));
			eb.setUserId(rs.getInt("Uset_id"));
			eb.setSubcategoryId(rs.getInt("SubCategory_ID"));
			eb.setExpenseName(rs.getString("Expense_Name"));
			eb.setAmount(rs.getFloat("Amount"));
			return eb;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

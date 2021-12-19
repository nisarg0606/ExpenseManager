package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.CategoryBean;
import com.util.DBConnection;

public class CategoryDao {
	public int insertCategory(CategoryBean CategoryBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into category (Category_ID) values (?)");
			pstmt.setInt(1, CategoryBean.getCategoryId());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ResultSet getAllCategory() {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from category");
			ResultSet rsd = pstmt.executeQuery();
			return rsd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public int insertCategoryByName(CategoryBean CategoryBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into category (Category_Name) values (?)");
			pstmt.setString(1, CategoryBean.getCategoryName());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public CategoryBean getCategoryById(int CategoryId) {
		Connection conn = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from category where Category_ID=?");
			pstmt.setInt(1, CategoryId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(CategoryId);
			CategoryBean cb = new CategoryBean();
			cb.setCategoryId(rs.getInt(1));
			cb.setCategoryName(rs.getString(2));
			System.out.println(cb.getCategoryName());
			return cb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int UpdateCategory(CategoryBean categoryBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("update category set Category_Name=? where Category_ID=?");
			pstmt.setString(1, categoryBean.getCategoryName());
			pstmt.setInt(2, categoryBean.getCategoryId());
			i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public ArrayList<CategoryBean> getAllCategories(){
		ArrayList<CategoryBean> categories = new ArrayList<CategoryBean>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from category");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				CategoryBean cb = new CategoryBean();
				cb.setCategoryId(rs.getInt("Category_ID"));
				cb.setCategoryName(rs.getString("Category_Name"));
				categories.add(cb);	
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categories;
	}
}
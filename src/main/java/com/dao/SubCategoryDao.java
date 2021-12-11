package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.bean.SubCategoryBean;
import com.util.DBConnection;

public class SubCategoryDao {
	public int insertSubCategory(SubCategoryBean SubCategoryBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("insert into sub_category (Category_ID, SubCategory_Name) values (?, ?)");
			pstmt.setInt(1, SubCategoryBean.getCategoryId());
			pstmt.setString(2, SubCategoryBean.getSubcategoryName());
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public ResultSet getAllSubCategory() {
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select * from sub_category");
			ResultSet rsd = pstmt.executeQuery();
			return rsd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

//	public int insertCategoryByName(CategoryBean CategoryBean) {
//		int i = -1;
//		try {
//			Connection conn = DBConnection.getConnection();
//			PreparedStatement pstmt = conn.prepareStatement("insert into category (Category_Name) values (?)");
//			pstmt.setString(1, CategoryBean.getCategoryName());
//			i = pstmt.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return i;
//	}

	public SubCategoryBean getSubCategoryById(int SubCategoryId) {
		Connection conn = DBConnection.getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from sub_category where SubCategory_ID=?");
			pstmt.setInt(1, SubCategoryId);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			System.out.println(SubCategoryId);
			SubCategoryBean scb = new SubCategoryBean();
			scb.setSubcategoryId(rs.getInt(1));
			scb.setCategoryId(rs.getInt(2));
			scb.setSubcategoryName(rs.getString(3));
			System.out.println(scb.getSubcategoryName());
			return scb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public int UpdateSubCategory(SubCategoryBean subcategoryBean) {
		int i = -1;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pstmt = conn
					.prepareStatement("update sub_category set SubCategory_Name=?, Category_ID=? where SubCategory_ID=?");
			pstmt.setString(1, subcategoryBean.getSubcategoryName());
			pstmt.setInt(2, subcategoryBean.getCategoryId());
			pstmt.setInt(3, subcategoryBean.getSubcategoryId());
			i = pstmt.executeUpdate();
			System.out.println(i);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
}
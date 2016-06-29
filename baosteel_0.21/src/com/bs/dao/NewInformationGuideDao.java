package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.system.DBUtils;

public class NewInformationGuideDao {
	private String guide_editor;
	private String guide_editor_name;
	private String guide_title;
	private String guide_category;
	private String guide_text;
	

	 public NewInformationGuideDao(String guide_editor,String guide_editor_name,String guide_title,String guide_category,String guide_text){
		this.guide_editor = guide_editor;
		this.guide_editor_name = guide_editor_name;
		this.guide_title = guide_title;
		this.guide_category = guide_category;
		this.guide_text = guide_text;
	}
	 
	 public void NewInformationGuide(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("INSERT INTO `baosteel_db`.`informationguiderecord`(`guide_editor`, `guide_name`,`guide_title`,`guide_category`,`guide_text`)");
         sb.append(" VALUES (?,?,?,?,?)");
	     PreparedStatement pstmt = null;
	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,guide_editor);
			pstmt.setObject(2,guide_editor_name);
			pstmt.setObject(3,guide_title);
			pstmt.setObject(4,guide_category);
			pstmt.setObject(5,guide_text);
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return;
		}
         
	 }
}

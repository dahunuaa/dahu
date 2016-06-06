package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.system.DBUtils;

public class NewinformationgatheringDao {
	private String gather_editor;
	private String gather_editor_name;
	private String gather_title;
	private String gather_category;
	private String gather_text;
	

	 public NewInformationGuideDao(String gather_editor,String gather_editor_name,String gather_title,String gather_category,String gather_text){
		this.gather_editor = gather_editor;
		this.gather_editor_name = gather_editor_name;
		this.gather_title = gather_title;
		this.gather_category = gather_category;
		this.gather_text = gather_text;
	}
	 
	 public void Newinformationgathering(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("INSERT INTO `baosteel_db`.`informationgatheringrecord`(`gather_editor`, `gather_editor_name`,`gather_title`,`gather_category`,`gather_text`)");
         sb.append(" VALUES (?,?,?,?,?)");
	     PreparedStatement pstmt = null;
	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,gather_editor);
			pstmt.setObject(2,gather_editor_name);
			pstmt.setObject(3,gather_title);
			pstmt.setObject(4,gather_category);
			pstmt.setObject(5,gather_text);
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

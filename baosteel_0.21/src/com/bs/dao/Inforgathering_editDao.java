package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.system.DBUtils;

public class Inforgathering_editDao {
	private String gather_id;
	private String gather_editor;
	private String gather_editor_name;
	private String gather_title;
	private String gather_address;
	private String gather_area;
	private String gather_text;
	

	 public Inforgathering_editDao(String gather_id,String gather_editor,String gather_editor_name,String gather_title,String gather_address,String gather_area,String gather_text){
		this.gather_id=gather_id;
		this.gather_editor = gather_editor;
		this.gather_editor_name = gather_editor_name;
		this.gather_title = gather_title;
		this.gather_address = gather_address;
		this.gather_area = gather_area;
		this.gather_text = gather_text;
	
	}
	 
	 public void Inforgathering_edit(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("UPDATE informationgatheringrecord SET gather_editor=?,gather_editor_name=?,gather_title=?,address=?,area=?,gathering_text=?");
         sb.append(" WHERE informationgatheringrecord.`gather_id`=?");
	     PreparedStatement pstmt = null;

	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,gather_editor);
			pstmt.setObject(2,gather_editor_name);
			pstmt.setObject(3,gather_title);
			pstmt.setObject(4,gather_address);
			pstmt.setObject(5,gather_area);
			pstmt.setObject(6,gather_text);
			pstmt.setObject(7,gather_id);
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

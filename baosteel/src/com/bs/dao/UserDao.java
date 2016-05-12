package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.system.DBUtils;

public class UserDao {
	private String name = null;
	
	
	public UserDao(String name) {
		super();
		this.name = name;
	}
   

	public String getPassWord(){
	      Connection conn = DBUtils.getConnection();
	      if(conn == null)return null;
	      String sql ="SELECT psw FROM usersinfor WHERE id ="+"'"+this.name+"'";
	      String psw = "";
	//第四步 执行查询 使用Statement类中的executeQuery方法执行查询
	      try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()){
					psw=rs.getString(1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DBUtils.close(conn);
				return psw;
			
			}
	
	   }
	
	

}


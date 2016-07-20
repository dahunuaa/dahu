package com.bs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.system.DBUtils;

public class MyInformationGuidingDao {
	private String guide_editor;
	
	 public MyInformationGuidingDao(String guide_editor){
		this.guide_editor = guide_editor;
		
	}
	 public List MyInformationGuiding(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT informationguiderecord.`guide_id`, informationguiderecord.`guide_editor`,`guide_name`,`guide_title`,`guide_category`,`guide_text`,`time`");
			 sb.append(" FROM informationguiderecord");
			 sb.append(" WHERE informationguiderecord.`guide_editor`=?");
			 sb.append(" ORDER BY guide_id DESC");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, this.guide_editor);
//			 System.out.println(this.buss_editor);
			 ResultSet rs = pstmt.executeQuery();
	         //int sc =Integer.parseInt(rs.getString(7));
			 infos = new ArrayList<Map<String,Object>>();
			 ResultSetMetaData rsmd = rs.getMetaData();//得到表的结构信息，比如字段名，字段数
			 while(rs.next()){//遍历列数
				 Map<String,Object> item = new HashMap<String, Object>();
				 int nCount = rsmd.getColumnCount();//得到列的数量  getrowcount是获取行的数量
				 for(int i = 0; i <nCount;++i){
					 item.put(rsmd.getColumnLabel(i+1), rs.getString(i+1));//将获取的信息存入到map中
				 }
				 		 
				 infos.add(item);
				
			 }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return infos;
		}
	     
	}	
}

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

public class Buss_searchDao {
	private String buss_search;
	private int count;
	
	 public Buss_searchDao(String buss_search,int count){
		this.buss_search = buss_search;
		this.count = 5*count;
		
	}
	 public List Buss_searchRecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT bussinessrecords.`buss_id`,bussinessrecords.`editor`,`editor_name`,`bussmen_name`,`accounts`,`buss_place`,`buss_reason`,`buss_begintime`,`buss_endtime`,`time`");
			 sb.append(" FROM bussinessrecords");
			 sb.append(" WHERE CONCAT(bussmen_name,accounts,buss_id,editor,editor_name,buss_place,buss_reason,buss_begintime,buss_endtime,time) LIKE ?");
			 sb.append(" ORDER BY buss_id DESC LIMIT ?,5");
//			 sb.append(" WHERE bussinessrecords.`editor`=?");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, "%"+this.buss_search+"%");
			 pstmt.setObject(2, this.count);
//			 System.out.println(count);
//			 System.out.println(this.buss_search);
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
//				System.out.println(infos);
			 }
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return infos;
		}
	     
	}	
}

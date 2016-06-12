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

public class InformationGuidingDao {
	private String guide_editor;
	
	 public InformationGuidingDao(String guide_editor){
		this.guide_editor = guide_editor;
		
	}
	 public List InformationGuidingRecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT informationguiderecord.`guide_id`, informationguiderecord.`guide_editor`,`guide_name`,`guide_title`,`guide_category`,`guide_text`");
			 sb.append(" FROM informationguiderecord");
			 sb.append(" ORDER BY guide_id DESC");
			 pstmt = conn.prepareStatement(sb.toString());
			 ResultSet rs = pstmt.executeQuery();
	       
			 infos = new ArrayList<Map<String,Object>>();
			 ResultSetMetaData rsmd = rs.getMetaData();//锟矫碉拷锟斤拷慕峁癸拷锟较拷锟斤拷锟斤拷锟斤拷侄锟斤拷锟斤拷侄锟斤拷锟�
			 while(rs.next()){//锟斤拷锟斤拷锟斤拷锟斤拷
				 Map<String,Object> item = new HashMap<String, Object>();
				 int nCount = rsmd.getColumnCount();//锟矫碉拷锟叫碉拷锟斤拷锟斤拷  getrowcount锟角伙拷取锟叫碉拷锟斤拷锟斤拷
				 for(int i = 0; i <nCount;++i){
					 item.put(rsmd.getColumnLabel(i+1), rs.getString(i+1));//锟斤拷锟斤拷取锟斤拷锟斤拷息锟斤拷锟诫到map锟斤拷
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

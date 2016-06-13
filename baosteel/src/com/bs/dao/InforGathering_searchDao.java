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

public class InforGathering_searchDao {
	private String inforgathering_search;
	
	 public InforGathering_searchDao(String inforgathering_search){
		this.inforgathering_search = inforgathering_search;
		
	}
	 public List inforgathering_searchrecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT informationgatheringrecord.`gather_id`, informationgatheringrecord.`gather_editor`,`gather_editor_name`,`gather_title`,`area`,`address`,`gathering_text`");
			 sb.append(" FROM informationgatheringrecord");
			 sb.append(" WHERE CONCAT(gather_id,gather_editor,gather_editor_name,gather_title,area,address,gathering_text) LIKE ?");

			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, "%"+this.inforgathering_search+"%");

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

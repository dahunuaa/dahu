package bs.inforguide.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.system.DBUtils;

public class Inforguide_searchDao {
	private String inforguide_search;
	
	 public Inforguide_searchDao(String inforguide_search){
		this.inforguide_search = inforguide_search;
		
	}
	 public List Inforguide_searchrecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT informationguiderecord.`guide_id`, informationguiderecord.`guide_editor`,`guide_name`,`guide_title`,`guide_category`,`guide_text`,`time`");
			 sb.append(" FROM informationguiderecord");
			 sb.append(" WHERE CONCAT(guide_id,guide_editor,guide_name,guide_title,guide_category,guide_text,time) LIKE ?");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, "%"+this.inforguide_search+"%");
			 ResultSet rs = pstmt.executeQuery();
			 infos = new ArrayList<Map<String,Object>>();
			 ResultSetMetaData rsmd = rs.getMetaData();	 
			  while(rs.next()){
				 Map<String,Object> item = new HashMap<String, Object>();
				 int nCount = rsmd.getColumnCount();
				 for(int i = 0; i <nCount;++i){
					 item.put(rsmd.getColumnLabel(i+1), rs.getString(i+1));
				 }
			 		 
				 infos.add(item);	         
		        } 
         }catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return infos;
		}
	     
	}	
}

package bs.inforgather.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.system.DBUtils;

public class MyInformationgatheringDao {
	private String gather_editor;
	
	 public MyInformationgatheringDao(String gather_editor){
		this.gather_editor = gather_editor;
		
	}
	 public List MyInformationgathering(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT informationgatheringrecord.`gather_id`, informationgatheringrecord.`gather_editor`,`gather_editor_name`,`gather_title`,`area`,`address`,`gathering_text`,`gather_oil_field`,`time`");
			 sb.append(" FROM informationgatheringrecord");
			 sb.append(" WHERE informationgatheringrecord.`gather_editor`=?");
			 sb.append(" ORDER BY gather_id DESC");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, this.gather_editor);
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
	         
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtils.close(conn);
			return infos;
		}
	     
	}	
}

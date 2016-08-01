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

public class InforGathering_searchDao {
	private String title;
	private String area;
	private String address;
	private String field;
	private String textarea;
	private int  count;
	
	 public InforGathering_searchDao(String title,String area,String address,String field,String textarea,int count){
		this.title = title;
		this.area = area;
		this.address = address;
		this.field = field;
		this.textarea = textarea;
		this.count = 5*count;
		
	}
	 public List inforgathering_searchrecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT *");
			 sb.append(" FROM informationgatheringrecord");
			 sb.append(" WHERE CONCAT(gather_title) LIKE ? AND CONCAT(area) LIKE ? AND CONCAT(address) LIKE ? AND CONCAT(gather_oil_field) LIKE ? AND CONCAT(gathering_text) LIKE ?");
			 sb.append(" ORDER BY gather_id DESC LIMIT ?,5");

			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, "%"+this.title+"%");
			 pstmt.setObject(2, "%"+this.area+"%");
			 pstmt.setObject(3, "%"+this.address+"%");
			 pstmt.setObject(4, "%"+this.field+"%");
			 pstmt.setObject(5, "%"+this.textarea+"%");
			 pstmt.setObject(6, this.count);

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

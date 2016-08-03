package bs.inforguide.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bs.system.DBUtils;

public class Inforguide_editDao {
	private String guide_id;
	private String guide_title;
	private String guide_category;
	private String guide_text;
	private String time;
	

	 public Inforguide_editDao(String guide_id,String guide_title,String guide_category,String guide_text,String time){
		this.guide_id=guide_id;
		this.guide_title = guide_title;
		this.guide_category = guide_category;
		this.guide_text = guide_text;
		this.time = time;
	
	}
	 
	 public void Inforguide_edit(){
		 int i =0;
		 Connection conn = DBUtils.getConnection();
		 if(conn == null)return;
		 StringBuffer sb = new StringBuffer();
         sb.append("UPDATE informationguiderecord SET guide_title=?,guide_category=?,guide_text=?,time=?");
         sb.append(" WHERE informationguiderecord.`guide_id`=?");
	     PreparedStatement pstmt = null;

	     try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setObject(1,guide_title);
			pstmt.setObject(2,guide_category);
			pstmt.setObject(3,guide_text);
			pstmt.setObject(4,time);
			pstmt.setObject(5,guide_id);
//			System.out.println(guide_id);
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

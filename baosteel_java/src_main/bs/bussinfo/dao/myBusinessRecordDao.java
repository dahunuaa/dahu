package bs.bussinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bs.system.DBUtils;

public class myBusinessRecordDao {
	private String buss_editor;
	
	 public myBusinessRecordDao(String buss_editor){
		this.buss_editor = buss_editor;
		
	}
	 public List myBusinessRecord(){
         Connection conn =null;
         PreparedStatement pstmt =null;
         List infos = null;
         try {
        	
			 conn=DBUtils.getConnection();
			 if(conn==null) return null;
			 StringBuffer sb = new StringBuffer();
			 sb.append("SELECT bussinessrecords.`buss_id`, bussinessrecords.`editor`,`editor_name`,`bussmen_name`,`accounts`,`buss_place`,`buss_reason`,`buss_begintime`,`buss_endtime`,`time`");
			 sb.append(" FROM bussinessrecords");
			 sb.append(" WHERE bussinessrecords.`editor`=?");
			 sb.append(" ORDER BY buss_id DESC");
			 pstmt = conn.prepareStatement(sb.toString());
			 pstmt.setObject(1, this.buss_editor);
//			 System.out.println(this.buss_editor);
			 ResultSet rs = pstmt.executeQuery();
	         //int sc =Integer.parseInt(rs.getString(7));
			 infos = new ArrayList<Map<String,Object>>();
			 ResultSetMetaData rsmd = rs.getMetaData();//�õ���Ľṹ��Ϣ�������ֶ������ֶ���
			 while(rs.next()){//��������
				 Map<String,Object> item = new HashMap<String, Object>();
				 int nCount = rsmd.getColumnCount();//�õ��е�����  getrowcount�ǻ�ȡ�е�����
				 for(int i = 0; i <nCount;++i){
					 item.put(rsmd.getColumnLabel(i+1), rs.getString(i+1));//����ȡ����Ϣ���뵽map��
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

package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import com.bs.dao.MyInformationgatheringDao;
import com.bs.dao.UserDao;
import com.bs.system.Constant;
public class MyInformationgathering extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    HttpSession session = req.getSession();
		//System.out.println(session.getAttribute(Constant.IS_LOGIN));
			req.setCharacterEncoding("utf-8");// �Ƚ������������utf-8���б���
			resp.setCharacterEncoding("utf-8");//���÷��͵�ǰ�˵���ݸ�ʽ��utf-8��ʽ
			String id = (String) session.getAttribute("id");
//			System.out.println(id);
			MyInformationgatheringDao Dao = new MyInformationgatheringDao(id);
		    List<Map<String,Object>> infos = Dao.MyInformationgathering();

		    JSONArray infoslist = JSONArray.fromObject(infos);
            
		    

			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(infoslist);//����д��println
				 pw.flush();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				if(pw!=null){
					pw.close();
				}
			}

	}
}

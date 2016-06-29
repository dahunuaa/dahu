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

import com.bs.dao.myBusinessRecordDao;
import com.bs.dao.UserDao;
import com.bs.dao.InforGathering_searchDao;
import com.bs.system.Constant;
public class InforGathering_search extends HttpServlet {
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
			String inforgathering_search = req.getParameter("inforgathering_search");
			
//			System.out.println(inforgathering_search);
            InforGathering_searchDao searchDao = new InforGathering_searchDao(inforgathering_search);
            List<Map<String,Object>> infos = searchDao.inforgathering_searchrecord();

		    JSONArray busslist = JSONArray.fromObject(infos);
//            System.out.println(busslist);
			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(busslist);//����д��println
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

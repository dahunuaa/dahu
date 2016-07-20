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
import com.bs.dao.Inforguide_searchDao;
import com.bs.system.Constant;
public class Inforguide_search extends HttpServlet {
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
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String inforguide_search = req.getParameter("inforguide_search");
			
//			System.out.println(inforguide_search);
            Inforguide_searchDao searchDao = new Inforguide_searchDao(inforguide_search);
            List<Map<String,Object>> infos = searchDao.Inforguide_searchrecord();

		    JSONArray busslist = JSONArray.fromObject(infos);
			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(busslist);
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

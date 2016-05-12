package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.bs.system.Constant;
public class myBusinessRecord extends HttpServlet {
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
			req.setCharacterEncoding("utf-8");// 先将请求的名字用utf-8进行编码
			resp.setCharacterEncoding("utf-8");//设置发送到前端的数据格式是utf-8格式
			String id = (String) session.getAttribute("id");
			System.out.println(id);
			myBusinessRecordDao userDao = new myBusinessRecordDao(id);
		    List<Map<String,Object>> infos = userDao.myBusinessRecord();
		    
		    JSONArray infoslist = JSONArray.fromObject(infos);
		    System.out.println(infoslist);
		    
//			req.setAttribute("infos", infoslist);
			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(infoslist);//不能写成println
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

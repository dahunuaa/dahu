package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.dao.Buss_editDao;

public class Buss_edit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String editor = req.getParameter("buss_editor");
		String editor_name = req.getParameter("buss_editor_name");
		String bussmen = req.getParameter("bussmen_name");
		String accounts = req.getParameter("buss_accounts");
		String place = req.getParameter("buss_place");
		String reason = req.getParameter("buss_reason");
		String begintime = req.getParameter("buss_begintime");
		String endtime = req.getParameter("buss_endtime");
		String buss_id = req.getParameter("buss_id");
        
		Buss_editDao dao = new Buss_editDao(buss_id,editor,editor_name,bussmen,accounts,place,reason,begintime,endtime);
		dao.buss_edit();
		 String str = "ok";
		 PrintWriter pw = null;
		
		 try {
			pw = resp.getWriter(); 
			 pw.print(str);//²»ÄÜÐ´³Éprintln
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

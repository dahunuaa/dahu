package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.dao.CreatNewTaskDao;

public class CreateNewTask extends HttpServlet{

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
        
		CreatNewTaskDao dao = new CreatNewTaskDao(editor,editor_name,bussmen,accounts,place,reason,begintime,endtime);
		dao.creatNewTask();
//		System.out.println(editor);
//		System.out.println(accounts);
//		System.out.println(reason);
//		System.out.println(endtime);
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

package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.dao.New_noticeDao;
import com.bs.dao.UserNameDao;

public class New_notice extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		req.setCharacterEncoding("utf-8");
		String publisher = (String) session.getAttribute("id");
		String notice = req.getParameter("notice");
		String notice_title = req.getParameter("notice_title");
//		System.out.println(notice);
		UserNameDao namedao = new UserNameDao(publisher);
		String name = namedao.getName();
//	      System.out.println(name);
		New_noticeDao dao = new New_noticeDao(publisher,notice,notice_title,name);
		dao.new_notice();

		 String str = "ok";
		 PrintWriter pw = null;
		
		 try {
			pw = resp.getWriter(); 
			 pw.print(str);
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

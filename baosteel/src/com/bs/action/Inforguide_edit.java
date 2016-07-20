package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.dao.Inforguide_editDao;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Inforguide_edit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String guide_id = req.getParameter("guide_id");
		String guide_title = req.getParameter("guide_title");
		String guide_category = req.getParameter("guide_category");
		String guide_text = req.getParameter("guide_text");
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sm.format(new Date());
		
        
		Inforguide_editDao dao = new Inforguide_editDao(guide_id,guide_title,guide_category,guide_text,time);
		dao.Inforguide_edit();

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

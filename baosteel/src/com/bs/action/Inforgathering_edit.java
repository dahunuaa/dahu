package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bs.dao.Inforgathering_editDao;

public class Inforgathering_edit extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String gather_id = req.getParameter("gather_id");
		String gather_editor = req.getParameter("gather_editor");
		String gather_editor_name = req.getParameter("gather_editor_name");
		String gather_title = req.getParameter("gather_title");
		String gather_category = req.getParameter("gather_category");
		String gather_text = req.getParameter("gather_text");
		
        
		Inforgathering_editDao dao = new Inforgathering_editDao(gather_id,gather_editor,gather_editor_name,gather_title,gather_category,gather_text);
		dao.Inforgathering_edit();

		 String str = "ok";
		 PrintWriter pw = null;
		
		 try {
			pw = resp.getWriter(); 
			 pw.print(str);//����д��println
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

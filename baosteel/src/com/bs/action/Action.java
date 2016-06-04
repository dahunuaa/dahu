package com.bs.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bs.dao.UserDao;

public class Action extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String id = req.getParameter("name");
		String password = req.getParameter("pswd");

		UserDao dao = new UserDao(id);
         String psw = dao.getPassWord();
         HttpSession session=req.getSession();
         session.setAttribute("psw", psw);
         session.setAttribute("id", id);
         String str = "";
         
         PrintWriter pw = null;
         if(psw.equals(password)){
        	str = "ok";
         }else{
        	 str = "sorry";
         } try {
				pw = resp.getWriter(); 
				 pw.print(str);//²»ÄÜÐ´³Éprintln
				 pw.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(pw!=null){
					pw.close();
				}
			}
//         System.out.println(str);

	}

	
}

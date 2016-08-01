package bs.inforgather.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bs.inforgather.dao.Inforgathering_editDao;

import java.text.SimpleDateFormat;
import java.util.Date;

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
		String gather_title = req.getParameter("gather_title");
		String gather_address = req.getParameter("gather_address");
		String gather_area = req.getParameter("gather_area");
		String gather_text = req.getParameter("gather_text");
		String gather_oil_field = req.getParameter("gather_oil_field");
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sm.format(new Date());
//		System.out.println(gather_text);
        
		Inforgathering_editDao dao = new Inforgathering_editDao(gather_id,gather_title,gather_address,gather_area,gather_text,gather_oil_field,time);
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

package bs.notice.action;

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
import bs.notice.dao.MynoticeDao;

import com.bs.system.Constant;
public class Mynotice extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    HttpSession session = req.getSession();

			req.setCharacterEncoding("utf-8");// �Ƚ������������utf-8���б���
			resp.setCharacterEncoding("utf-8");//���÷��͵�ǰ�˵���ݸ�ʽ��utf-8��ʽ
			String id = (String) session.getAttribute("id");

			MynoticeDao mynoticeDao = new MynoticeDao(id);
		    List<Map<String,Object>> infos = mynoticeDao.mynotice();

		    JSONArray infoslist = JSONArray.fromObject(infos);
//		    System.out.println(infoslist);
            
		    

			PrintWriter pw = null;
			try {
				pw = resp.getWriter(); 
				 pw.print(infoslist);//����д��println
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

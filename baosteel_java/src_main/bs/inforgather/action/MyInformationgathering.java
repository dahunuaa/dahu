package bs.inforgather.action;

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
import bs.inforgather.dao.MyInformationgatheringDao;

import com.bs.dao.UserDao;
import com.bs.system.Constant;
public class MyInformationgathering extends HttpServlet {
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
			resp.setCharacterEncoding("utf-8");
			String id = (String) session.getAttribute("id");

			MyInformationgatheringDao Dao = new MyInformationgatheringDao(id);
		    List<Map<String,Object>> infos = Dao.MyInformationgathering();

		    JSONArray infoslist = JSONArray.fromObject(infos);
            
		    

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

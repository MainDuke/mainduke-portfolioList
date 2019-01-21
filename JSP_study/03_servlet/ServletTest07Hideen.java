import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //////
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest07Hideen
 */
//@WebServlet("/ServletTest07Hideen") //이놈이 web.xml 코딩 부분을 대신 해주는 역할을 한다.
@WebServlet("/aaa") 
public class ServletTest07Hideen extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out= res.getWriter();
		
		String name = req.getParameter("name");
		String addr= req.getParameter("addr");
		String tel = req.getParameter("tel");
		
		out.println("<html><body>");
		out.println("이름:"+name+"<br>");
		out.println("주소:"+addr+"<br>");
		out.println("전화번호:"+tel+"<br>");
		out.println("</body></html>");
		out.close();
		
	}//end method

}//end class

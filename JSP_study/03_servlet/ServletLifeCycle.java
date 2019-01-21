

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet; //
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet("/ServletLifeCycle")
public class ServletLifeCycle extends HttpServlet {

	public int cnt=0; //전역변수
	
	public void init(ServletConfig conf) throws ServletException
	{
				System.out.println("ini() call.....");
	}//init end
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		System.out.println("service() call");
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
			
		out.println("<html><body>");
		out.println("<h2>Service call cnt : "+cnt+"</h2>");
		cnt++;
		
		out.println("</body></html>");
		out.close();
		
	}//service end
	
	public void destroy(){
		System.out.println("destryoy call");
	}
	
}//class end

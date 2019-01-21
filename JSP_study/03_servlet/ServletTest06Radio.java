import java.io.*;
import java.rmi.ServerException;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest06Radio extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out= res.getWriter(); //웹으로 응답하기 위한, 아웃 객체 생성
		
		out.println("<html>");
		out.println("<head><title>라디오버튼</title></head>");
    	
		out.println("<body bgcolor=pink>");
		out.println("<center><h2>라디오버튼 테스트</h2></center>");
		out.println("당신 선택한 자료 입니다.<br>");
		

		Enumeration en = req.getParameterNames(); //순서 없이 처리된다.
		//html 의 form 안에 여러개의 이름을 받는다.
		
		while(en.hasMoreElements()){
			out.println("<li>");
			String name=(String)en.nextElement();
			out.println(name);
		
			out.println(":");
			String v=(String)req.getParameter(name);
			
			out.println(v);
			out.println();
		}
		out.println("</body></html>");
		out.close();
	}//doPost() end
	
}//class end

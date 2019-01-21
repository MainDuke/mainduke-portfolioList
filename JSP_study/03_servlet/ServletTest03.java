import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletTest03 extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html; charset=utf-8"); //MINE 타입과 인코딩문자 지정.
		PrintWriter out = res.getWriter(); //클라이언트로 응답 하기위해, out 객체 생성
		//클라이언트가 요청하면서 보내준 데이터를 받기.
		
		String name= req.getParameter("name");
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		
		//서버에서 적당처리 하고 , 클라이언트로 할당.
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("당신의 이름은 : "+name+"<br>");
		out.println("당신의 이메일은 : "+email+"<br>");
		out.println("당신의 글내용은 : "+content+"<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
			
		
	}//doGet end
	
}//end

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletTest01 extends HttpServlet{

	// 오버라이딩
	// doGet(HttpServletRequest req(요청객체), HttpServletResponse res(응답객체))
	// 클라이언트가 요청한다 
	// 서버가 응답 한다 
	// doGet() : 디폴트 이다 , html없이 서블릿만 실행 할때는 doGet()이 호출된다
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException,ServletException
		{
			res.setContentType("text/html;charset=utf-8");//인코문자 지정
			//html 페이지의 표준 MIME컨텐츠 타입지정
			//MIME ( Multipurpose Internet Mail Extention)
			// => 인터넷 전자 우편으로 텍스 이외의 음성이나 동영상 등
			// 다양한 데이터를 보내기 위한 표준이다 
			// text/html
			// text/plain
			// text/*
			// image/jpg
			// */*
			// tomcat/conf/web.xml 참조
			
			PrintWriter out=res.getWriter();//out 객체 생성 
			out.println("<html>");
			out.println("<body bgcolor='yellow'>");
			out.println("<big><b>Hello World</b></big><br>");
			out.println("<big><b>안녕하세요 서블릿 공부하러 왔어요...</b></big><br>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		}//doGet
}//class 

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest05Check extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html;charset=utf-8"); //웹에서 응답할때 한글처리.
		req.setCharacterEncoding("utf-8"); //클라이언트에서 넘어온 한글처리, post 방식
		
		//get방식은 server.xml 에서 설정. 된다.
		
		PrintWriter out= res.getWriter(); //클라이언트로 응답하기 위하여 아웃 객체 생성.
		
		String fruit[]= req.getParameterValues("fruit");
		
		out.println("<html><body bgcolor=pink>");
		out.println("<center><h2>다중선택</h2></center>");
		if (fruit!=null) {
			out.println("당신이 선택한 과일은 <br>");
			for (int i = 0; i < fruit.length; i++) {
					out.println("<li>"+fruit[i]);	
					
			}//for 
		}else{
			out.println("당신이 선택한 과일은 없습니다.");
		}//if else end
		
		out.println("</body></html>");
		out.close();
		
	}//end
	
}//class end

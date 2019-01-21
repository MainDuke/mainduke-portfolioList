import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet에서 JSP로 포워딩하기 
public class ServletToJsp extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
	res.setContentType("text/html;charset=utf-8"); //클라이언트에게 응답할때 한글처리 인코딩
	PrintWriter out=res.getWriter(); //out 객체 얻기
	
	//HashMap-----------------------------
		String user2="송중기";
		HashMap map = new HashMap();
		map.put("item1", "초콜렛");
		map.put("item2", "키드오");
		map.put("item3", "하리보");
		
		req.setAttribute("name2", user2);
		req.setAttribute("cart2", map);
		//-------------------------------------
	
	
	//Vector-----------------------------
	String user="송혜교";
	Vector vec=new Vector();
	vec.add("이윰 스킨");
	vec.add("청바지 No.3049");
	vec.add("아침햇살 1.5L");
	
	req.setAttribute("name", user);
	req.setAttribute("cart", vec);
	//Map==>HashMap
	
	//Servlet에서 JSP로 포워딩---------------- <<여기 중요함
	RequestDispatcher rd;
	rd=getServletContext().getRequestDispatcher("/jsp/target.jsp");
	//httpservlet에서 상속받았기 때문에 객체 생성 안하고 바로 쓰고있다	
	//포워드 액션이랑 비슷한데 서블릿이랑 제에스피 왔다갔다할 수 있음
	rd.forward(req, res); //jsp로 포워딩
	
	}//doGet
	
}//class



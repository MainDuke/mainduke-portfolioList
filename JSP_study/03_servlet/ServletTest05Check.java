import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest05Check extends HttpServlet {

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html;charset=utf-8"); //������ �����Ҷ� �ѱ�ó��.
		req.setCharacterEncoding("utf-8"); //Ŭ���̾�Ʈ���� �Ѿ�� �ѱ�ó��, post ���
		
		//get����� server.xml ���� ����. �ȴ�.
		
		PrintWriter out= res.getWriter(); //Ŭ���̾�Ʈ�� �����ϱ� ���Ͽ� �ƿ� ��ü ����.
		
		String fruit[]= req.getParameterValues("fruit");
		
		out.println("<html><body bgcolor=pink>");
		out.println("<center><h2>���߼���</h2></center>");
		if (fruit!=null) {
			out.println("����� ������ ������ <br>");
			for (int i = 0; i < fruit.length; i++) {
					out.println("<li>"+fruit[i]);	
					
			}//for 
		}else{
			out.println("����� ������ ������ �����ϴ�.");
		}//if else end
		
		out.println("</body></html>");
		out.close();
		
	}//end
	
}//class end

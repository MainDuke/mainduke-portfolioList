import java.io.*;
import java.rmi.ServerException;
import java.util.Enumeration;

import javax.servlet.*;
import javax.servlet.http.*;

public class ServletTest06Radio extends HttpServlet{

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out= res.getWriter(); //������ �����ϱ� ����, �ƿ� ��ü ����
		
		out.println("<html>");
		out.println("<head><title>������ư</title></head>");
    	
		out.println("<body bgcolor=pink>");
		out.println("<center><h2>������ư �׽�Ʈ</h2></center>");
		out.println("��� ������ �ڷ� �Դϴ�.<br>");
		

		Enumeration en = req.getParameterNames(); //���� ���� ó���ȴ�.
		//html �� form �ȿ� �������� �̸��� �޴´�.
		
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

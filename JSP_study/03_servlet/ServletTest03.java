import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletTest03 extends HttpServlet{

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html; charset=utf-8"); //MINE Ÿ�԰� ���ڵ����� ����.
		PrintWriter out = res.getWriter(); //Ŭ���̾�Ʈ�� ���� �ϱ�����, out ��ü ����
		//Ŭ���̾�Ʈ�� ��û�ϸ鼭 ������ �����͸� �ޱ�.
		
		String name= req.getParameter("name");
		String email = req.getParameter("email");
		String content = req.getParameter("content");
		
		//�������� ����ó�� �ϰ� , Ŭ���̾�Ʈ�� �Ҵ�.
		out.println("<html>");
		out.println("<body bgcolor=yellow>");
		out.println("����� �̸��� : "+name+"<br>");
		out.println("����� �̸����� : "+email+"<br>");
		out.println("����� �۳����� : "+content+"<br>");
		out.println("</body>");
		out.println("</html>");
		out.close();
			
		
	}//doGet end
	
}//end

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.text.*;

public class ServletTest02 extends HttpServlet{

	//overring 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out= res.getWriter(); //Ŭ���̾�Ʈ�� �����ϱ� ���� OUT ��ü ����
		
		java.util.Date date = new java.util.Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
		
		out.println("<html>");
		out.println("<body bgcolor=\'yellow\'>");
		
		out.println("<font color='blue' size='5'> ");
		out.println("<center><br><br>");
		out.println("<img src=\"/03_servlet/imgs/song.jpg\">"); //<img src="a.jpg" width='300' height=
		
		out.println("<marquee>");
		out.println("'������ ����� ȭ���� �Դϴ�...���ϵ� ����� �������Դϴ�'");
		out.println("</marquee>");
		out.println("<br><br><hr size=10 color=cyan><br>");
		out.println(date.toString());
		out.println("<br>");
		out.println(sdf.format(date));
		
		
		out.println("</center>");
		out.println("</font>");
		out.println("</body></html>");
		
		out.close();
		//web.xml : ���� ���� ȯ�� ����
		
	}//over end
	
}//class end

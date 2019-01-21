import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ServletTest01 extends HttpServlet{

	// �������̵�
	// doGet(HttpServletRequest req(��û��ü), HttpServletResponse res(���䰴ü))
	// Ŭ���̾�Ʈ�� ��û�Ѵ� 
	// ������ ���� �Ѵ� 
	// doGet() : ����Ʈ �̴� , html���� ������ ���� �Ҷ��� doGet()�� ȣ��ȴ�
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws IOException,ServletException
		{
			res.setContentType("text/html;charset=utf-8");//���ڹ��� ����
			//html �������� ǥ�� MIME������ Ÿ������
			//MIME ( Multipurpose Internet Mail Extention)
			// => ���ͳ� ���� �������� �ؽ� �̿��� �����̳� ������ ��
			// �پ��� �����͸� ������ ���� ǥ���̴� 
			// text/html
			// text/plain
			// text/*
			// image/jpg
			// */*
			// tomcat/conf/web.xml ����
			
			PrintWriter out=res.getWriter();//out ��ü ���� 
			out.println("<html>");
			out.println("<body bgcolor='yellow'>");
			out.println("<big><b>Hello World</b></big><br>");
			out.println("<big><b>�ȳ��ϼ��� ���� �����Ϸ� �Ծ��...</b></big><br>");
			out.println("</body>");
			out.println("</html>");
			out.close();
			
		}//doGet
}//class 

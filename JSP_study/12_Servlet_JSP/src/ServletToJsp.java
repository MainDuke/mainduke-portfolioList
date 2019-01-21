import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

//Servlet���� JSP�� �������ϱ� 
public class ServletToJsp extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res)
		throws IOException, ServletException
	{
	res.setContentType("text/html;charset=utf-8"); //Ŭ���̾�Ʈ���� �����Ҷ� �ѱ�ó�� ���ڵ�
	PrintWriter out=res.getWriter(); //out ��ü ���
	
	//HashMap-----------------------------
		String user2="���߱�";
		HashMap map = new HashMap();
		map.put("item1", "���ݷ�");
		map.put("item2", "Ű���");
		map.put("item3", "�ϸ���");
		
		req.setAttribute("name2", user2);
		req.setAttribute("cart2", map);
		//-------------------------------------
	
	
	//Vector-----------------------------
	String user="������";
	Vector vec=new Vector();
	vec.add("���� ��Ų");
	vec.add("û���� No.3049");
	vec.add("��ħ�޻� 1.5L");
	
	req.setAttribute("name", user);
	req.setAttribute("cart", vec);
	//Map==>HashMap
	
	//Servlet���� JSP�� ������---------------- <<���� �߿���
	RequestDispatcher rd;
	rd=getServletContext().getRequestDispatcher("/jsp/target.jsp");
	//httpservlet���� ��ӹ޾ұ� ������ ��ü ���� ���ϰ� �ٷ� �����ִ�	
	//������ �׼��̶� ����ѵ� �����̶� �������� �Դٰ����� �� ����
	rd.forward(req, res); //jsp�� ������
	
	}//doGet
	
}//class



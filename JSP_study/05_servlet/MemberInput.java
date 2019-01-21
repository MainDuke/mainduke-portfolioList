

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.sql.*;

@WebServlet("/MemberInput")
public class MemberInput extends HttpServlet {
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		res.setContentType("text/html;charset=utf-8");//KSC5601, euc-kr, utf-8 �ѱ۹��ڼ�.
		req.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		
		//Ŭ���̾�Ʈ�� ������ ������ �ޱ�.
		String name= req.getParameter("name");
		String id= req.getParameter("id");
		String pwd= req.getParameter("pwd");
		String email= req.getParameter("email");
		String tel= req.getParameter("tel");
		String addr= req.getParameter("addr");

		String db_pwd=new String(""); //���� ����.
		//---------------------
		if (id.equals("")) {
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
			out.println("<font color=red size=5>ID�� �ʼ� �Է��Դϴ�.</font>");
			out.println("</body></html>");
			out.close();
			return;
		}//if
		
		if (pwd.equals("")) {
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
			out.println("<font color=red size=5>pwd�� �ʼ� �Է��Դϴ�.</font>");
			out.println("</body></html>");
			out.close();
			return;
		}//if
		
		try {
			Class.forName(DRIVER); //����̹� �ε�
			System.out.println("����̹� �ε�����");
			
		} catch (ClassNotFoundException ex) {System.out.println("����̹� �ε� ����"+ex);		}
		
		try {//DB�� �����ؼ� id�� ��ġ�ϴ� PWD �� �����´�.
			con=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("DB���� ����");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select pwd from login where id='"+id+"';");
			
			if (rs.next()) {
				db_pwd=rs.getString("pwd");
			}//if end pwd�� ������ ����
			
			if (db_pwd.equals("")) {//�ű� ���� ����
				String sql="insert into login values('"+name+"', '"+id+"', '"+pwd+"', '"+email+"', '"+tel+"', '"+addr+"')";
			stmt.executeUpdate(sql); //db �� ����.
			
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/LoginTest\">");
			out.println("<font color=blue size=5>"+id+"�� ȸ�������� �����մϴ�.~~</font>");
			out.println("</body></html>");
			
			}else{
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
				out.println("<font color=blue size=5>"+id+"�� ���̵�� �����~~</font>");
				out.println("</body></html>");
				
			}
			out.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception ex2) {System.out.println("SQL ���� "+ex2);}
		
		
		
		
    }//end doPost
	

}//class end

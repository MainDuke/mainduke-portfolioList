

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;
import java.text.*; 


@WebServlet("/Cart")
public class Cart extends HttpServlet {
	
	
	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
	
	java.util.Date date = new java.util.Date();
	SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd H:mm:ss");
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		try {
			Class.forName(DRIVER); //����̹� �ε�
			System.out.println("����̹� �ε�����");
			
		} catch (ClassNotFoundException ex) {System.out.println("����̹� �ε� ����"+ex);		}
		
		try {
			con=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("DB���� ����");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from sangpum");
			
			out.println("<html><body bgcolor=margenta><br><br>");
			out.println("<h2>��ǰ��� ����Ʈ</h2>");
			out.println("<table align=center width=70% border=1"
					+" borderColor=green cellpadding=0 cellspacing=0>");

			while (rs.next()) {
				String title=rs.getString("title");
				String imgfile=rs.getString("imgfile");
				String imghtml=rs.getString("imghtml");
				String content=rs.getString("content");
			//out.println("<tr bgcolor=cyan><td>����</td></tr>");
			out.println("<tr  bgcolor=cyan align=center><td colspan=2 align=center>"+title+"</td></tr>");
			
			out.println("<tr><td colspan=2 align=center>");
			//<a href='\05_servlet\html03\" �׸�����..
			out.println("<a href='/05_servlet/html03/"+imghtml+"'>");
			out.println("<img src='/05_servlet/imgs/"+imgfile+"' width=150 height=150>");
			out.println("</a></td></tr>");
			out.println("<tr><td>����</td>");
			out.println("<td align=center>"+content+"</td></tr>");
			out.println("<tr align=center><td colspan=2 align=center>");
			out.println(sdf.format(date)+"</td></tr>");
			}//while
			out.println("</table></body></html>");
			out.close();

			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception ex5) {System.out.println("SQL ����"+ex5);}

	}//doGet end

}//class end

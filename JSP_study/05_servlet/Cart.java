

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
			Class.forName(DRIVER); //드라이버 로딩
			System.out.println("드라이버 로딩성공");
			
		} catch (ClassNotFoundException ex) {System.out.println("드라이버 로딩 실패"+ex);		}
		
		try {
			con=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("DB연결 성공");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select * from sangpum");
			
			out.println("<html><body bgcolor=margenta><br><br>");
			out.println("<h2>상품목록 리스트</h2>");
			out.println("<table align=center width=70% border=1"
					+" borderColor=green cellpadding=0 cellspacing=0>");

			while (rs.next()) {
				String title=rs.getString("title");
				String imgfile=rs.getString("imgfile");
				String imghtml=rs.getString("imghtml");
				String content=rs.getString("content");
			//out.println("<tr bgcolor=cyan><td>제목</td></tr>");
			out.println("<tr  bgcolor=cyan align=center><td colspan=2 align=center>"+title+"</td></tr>");
			
			out.println("<tr><td colspan=2 align=center>");
			//<a href='\05_servlet\html03\" 그림파일..
			out.println("<a href='/05_servlet/html03/"+imghtml+"'>");
			out.println("<img src='/05_servlet/imgs/"+imgfile+"' width=150 height=150>");
			out.println("</a></td></tr>");
			out.println("<tr><td>설명</td>");
			out.println("<td align=center>"+content+"</td></tr>");
			out.println("<tr align=center><td colspan=2 align=center>");
			out.println(sdf.format(date)+"</td></tr>");
			}//while
			out.println("</table></body></html>");
			out.close();

			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception ex5) {System.out.println("SQL 예외"+ex5);}

	}//doGet end

}//class end

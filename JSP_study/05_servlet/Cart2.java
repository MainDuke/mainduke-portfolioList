

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;
import java.util.*;
import java.text.*; 


@WebServlet("/Cart2")
public class Cart2 extends HttpServlet {
	
	
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
			
			out.println("<html>");
			out.println("<head>	<script type='text/javascript'>"
			+"function btnClick() { form.submit();	"
			+ "alert('Button Click');}");
			out.println("</script></head>");
			
			out.println("<body bgcolor=margenta><form method=post action='/05_servlet/Cart2'><br><br>");
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
			out.println("<a href='/05_servlet/html03/aajsp.jsp?imgfile="+imgfile+"&title="+title+"'>");
			out.println("<img src='/05_servlet/imgs/"+imgfile+"' width=150 height=150>");
			out.println("</a></td></tr>");
			out.println("<tr><td>설명</td>");
			out.println("<td align=center>"+content+"</td></tr>");
			out.println("<tr align=center><td colspan=2 align=center>");
			out.println(sdf.format(date)+"</td></tr>");
			}//while
			out.println("</table></form></body></html>");
			out.close();

			rs.close();
			stmt.close();
			con.close();
			
		} catch (Exception ex5) {System.out.println("SQL 예외"+ex5);}

	}//doGet end
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		String name= req.getParameter("name");
		System.out.println(name);
		
		out.println(	"<html>"
		+"<head>"
		+"<meta charset='UTF-8'>"
		+"<title>Insert title here</title>"
		+"<style>"
		+"            div#title{ text-align:center; border: 1pt solid black; background-color: cyan;}"
	    + "  div span#title,#name{ text-align:center; border: 1pt solid black; background-color: yellow;}"
		+"	div#product{ text-align:center; border: 1pt solid black; background-color: white;}"
		 +"</style></head>");
		out.println("<body>"
				+ "<form>	<div id='title'>상품정보</div>"
				+ "<div id='title'><center><span id='title' align= 'left';> "
				+ "제품명: </span>&nbsp;&nbsp;<span id='name'> 르브론 12 엘리트 </span></center></div>"
				+ "<br><div id='product'><span>"
				+ "<img src='/05_servlet/imgs/a1.png'>"
				+ "</span><span><table><tr><td>하하하</td></tr>"
				+ "</table></span></div></form></body></html>");
				
	}//doPost end
	
	
}//class end



import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.sql.*;

@WebServlet("/LoginTest")
public class LoginTest extends HttpServlet {

	private static final String DRIVER="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/mydb";
	private static final String USER="root";
	private static final String PWD="12345";
	
	Connection con = null;
	Statement stmt= null;
	ResultSet rs= null;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out = res.getWriter();//out 객체 생성.
		
		out.println("<html><body bgcolor=yellow><center>");
		out.println("<u><center>^-^ 로그인 ^-^</center></u><br><br>");
		out.println("<form method='post' action=\"/05_servlet/LoginTest\">");
		
		//id
		out.println("<table border=1 bgcolor=orange>");
		out.println("<tr><td width=30% bgcolor='cbf5ff'>ID</td>"
				+ "<td width=70%>"
				+ "<input type=text name=id></td></tr>");//td
		//pwd
		out.println("<tr><td width=30% bgcolor='cbf5ff'>PWD</td>"
				+ "<td width=70%>"
				+"<input type='password' name=pwd></td></tr>");
		//sub
		out.println("<tr><td colspan=2 align=center>");
		out.println("<input type='submit' value='로그인'>"
				+"&nbsp;"
				+"<a href='/05_servlet/MemberForm'>회원가입</a>");
		
		out.println("</td></tr>");
		out.println("</table></form></center>");
		
		out.println("</body><html>");
		out.close();
		//out.println();
	
		
	}//get end

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//DB 확인 작업 = 회원 인증
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out=res.getWriter();
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String db_pwd =new String("");
		
		if (id.equals("")) { //id 입력 체크
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/LoginTest\">");
			out.println("<font color=red size=5>ID는 필수 입력입니다.</font>");
			out.println("</body></html>");
			out.close();
			return;
		}//if
		
		if (pwd.equals("")) { //pwd 입력 체크
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/LoginTest\">");
			out.println("<font color=red size=5>pwd는 필수 입력입니다.</font>");
			out.println("</body></html>");
			out.close();
			return;
		}//if
		
		try {
			Class.forName(DRIVER); //드라이버 로딩
			System.out.println("드라이버 로딩성공");
			
		} catch (ClassNotFoundException ex) {System.out.println("드라이버 로딩 실패"+ex);		}
		

		try {//DB에 연결해서 id에 일치하는 PWD 를 가져온다.
			con=DriverManager.getConnection(URL,USER,PWD);
			System.out.println("DB연결 성공");
			stmt=con.createStatement();
			rs=stmt.executeQuery("select pwd from login where id='"+id+"';");
			
			if (rs.next()) {
				db_pwd=rs.getString("pwd");
			}//if end pwd를 변수에 저장
			
			if (db_pwd.equals(pwd)) {
				
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/Cart\">");
			out.println("<font color=blue size=5>");
			out.println(id+"님 방문을 환영합니다..~~</font>");
			out.println("</body></html>");
			out.close();
			
			}else{
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/LoginTest\">");
				out.println("<font color=blue size=5>패스워드가 맞지 않습니다.</font>");
				out.println("</body></html>");
			}
			
			
		}catch(Exception ex2){System.out.println("DB연결 실패"+ex2);}
		
	}//post end
	
}//class end

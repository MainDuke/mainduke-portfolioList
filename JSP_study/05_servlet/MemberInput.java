

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
	
		res.setContentType("text/html;charset=utf-8");//KSC5601, euc-kr, utf-8 한글문자셋.
		req.setCharacterEncoding("utf-8");
		PrintWriter out=res.getWriter();
		
		//클라이언트가 보내준 데이터 받기.
		String name= req.getParameter("name");
		String id= req.getParameter("id");
		String pwd= req.getParameter("pwd");
		String email= req.getParameter("email");
		String tel= req.getParameter("tel");
		String addr= req.getParameter("addr");

		String db_pwd=new String(""); //변수 선언.
		//---------------------
		if (id.equals("")) {
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
			out.println("<font color=red size=5>ID는 필수 입력입니다.</font>");
			out.println("</body></html>");
			out.close();
			return;
		}//if
		
		if (pwd.equals("")) {
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
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
			
			if (db_pwd.equals("")) {//신규 가입 가능
				String sql="insert into login values('"+name+"', '"+id+"', '"+pwd+"', '"+email+"', '"+tel+"', '"+addr+"')";
			stmt.executeUpdate(sql); //db 에 저장.
			
			out.println("<html><body>");
			out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/LoginTest\">");
			out.println("<font color=blue size=5>"+id+"님 회원가입을 축하합니다.~~</font>");
			out.println("</body></html>");
			
			}else{
				out.println("<html><body>");
				out.println("<Meta http-equiv=refresh content=\"2;url=/05_servlet/MemberForm\">");
				out.println("<font color=blue size=5>"+id+"이 아이디는 사용중~~</font>");
				out.println("</body></html>");
				
			}
			out.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception ex2) {System.out.println("SQL 예외 "+ex2);}
		
		
		
		
    }//end doPost
	

}//class end



import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/MemberForm")
public class MemberForm extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
			
		PrintWriter out=res.getWriter();
		
		out.println("<html><body bgcolor=yellow><br><font color=\"blue\" size=6><u>");
		out.println("<center>^-^ 회원가입 ^-^</center></u></font><br><br><br>");
		out.println("<form method='post' action=\"/05_servlet/MemberInput\">");
		out.println("<table align=center border=1 bgColor=margenta"+
		" cellpadding=0 cellspacing=0>");
		
		//name
				out.println("<tr><td width=30% height=35 align=right>이름</td>");
				out.println("<td width=70%>");
				out.println("<input type='text' name='name' size='10'></td></tr>");
				
		//id
				out.println("<tr><td width=30% height=35 align=right>id</td>");
				out.println("<td width=70%>");
				out.println("<input type='text' name='id' size='12'></td></tr>");
				
		//pwd
				out.println("<tr><td width=30% height=35 align=right>암호</td>");
				out.println("<td width=70%>");
				out.println("<input type='password' name='pwd' size='10'></td></tr>");
				
		//email
				out.println("<tr><td width=30% height=35 align=right>이메일</td>");
				out.println("<td width=70%>");
				out.println("<input type='text' name='email' size='30'></td></tr>");
				
		//tel
				out.println("<tr><td width=30% height=35 align=right>전화번호</td>");
				out.println("<td width=70%>");
				out.println("<input type='text' name='tel' size='30'></td></tr>");
				
		//addr
				out.println("<tr><td width=30% height=35 align=right>주소</td>");
				out.println("<td width=70%>");
				out.println("<input type='text' name='addr' size='50'></td></tr>");
				
				out.println("<tr><td colspan=2 align=center>"
						+"<input type=\"submit\" value=\"회원가입\"'>&nbsp&nbsp&nbsp&nbsp"
						+"<input type='reset' value='취소'></td></tr>");
						
		out.println("</table></form></body></html>");
		
		
		out.close();
		
		
		
		
	}//doGet end;

}//class end

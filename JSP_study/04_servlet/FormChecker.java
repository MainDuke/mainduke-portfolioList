

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/FormChecker")
public class FormChecker extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		PrintWriter out = res.getWriter();
		
		out.println("<html>");
		out.println("<body bgcolor='margenta'");
		out.println("<h2>당신이 입력한 정보는 다음과 같습니다.</h2>");
		
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String card=req.getParameter("card");
		String ssn1=req.getParameter("ssn1");
		String ssn2=req.getParameter("ssn2");
		String p1=req.getParameter("p1");
		String p2=req.getParameter("p2");
		
		StringBuffer sb = new StringBuffer(ssn1);
		sb.append("-");
		sb.append(ssn2);
		sb.replace(0, 6, "######"); //111111-
		sb.replace(7, 14, "#######"); //7 8 9 10 11 
		
		p1=p1.replace(p1 ,"***" );
		
		out.println("<li>이름:"+name);
		out.println("<li>ID:"+id);
		out.println("<li>Email:"+email);
		out.println("<li>카드번호:"+card);
		out.println("<li>주민번호:"+sb);
		out.println("<li>암호:"+p1);
		out.close();
		
		
	}//end post

}//class end

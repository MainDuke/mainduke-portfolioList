

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet; ///****
import javax.servlet.http.*;

import java.util.*;


@WebServlet("/FormChecker2")
public class FormChecker2 extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		req.setCharacterEncoding("utf-8");
		
		PrintWriter out=res.getWriter();
		
		out.println("<html>");
		out.println("<head><title>서버측에서 유효성 체크</title></head>");
		out.println("<body bgcolor='yellow'>");
		
		//클라이언트가 보내준 데이터 받기.
		String name=req.getParameter("name");
		String id=req.getParameter("id");
		String email=req.getParameter("email");
		String card=req.getParameter("card");
		String ssn1=req.getParameter("ssn1");
		String ssn2=req.getParameter("ssn2");
		String p1=req.getParameter("p1");
		String p2=req.getParameter("p2");
		
		if (CheckTest.isNull(name)) {
			printErr(out, "이름을 입력하시오.");
 		return;
 		}
		if (!CheckTest.isID(id)) {
			printErr(out, "id을 입력하시오.");
 		return;
 		}
		if (!CheckTest.isEmail(email)) {
			printErr(out, "email이 올바르지 않습니다.");
 		return;
 		}
		
		if (!CheckTest.isCardNumber(card)) {
			printErr(out, "카드번호가 올바르지 않습니다.");
 		return;
 		}
		
		if (!CheckTest.isSSN(ssn1, ssn2)) {
			printErr(out, "주민번호가 올바르지 않습니다.");
 		return;
 		}
		
		if (!CheckTest.isSame(p1, p2)) {
			printErr(out, "암호가 일치하지 않습니다.");
 		return;
 		}

		StringBuffer sb= new StringBuffer(ssn1);
		sb.append("-");
		sb.append(ssn2);
		sb.replace(0, 6, "######");
		sb.replace(7, 14, "#######");
		
		p1=p1.replace(p1, "**");
		
		
		
		out.println("<li>이름 : "+name);
		out.println("<li>ID : "+id);
		out.println("<li>EMAIL : "+email);
		out.println("<li>카드번호 : "+card);
		out.println("<li>주민번호 : "+sb);
		out.println("<li>암호 : "+p1);
		out.println("</body></html>");
		out.close();
		
	}//do post end

	public static void printErr(PrintWriter out2, String msg) throws IOException{
		out2.println("<script>");
		out2.println("alert('"+msg+"')");
		out2.println("histrory.back()");
		out2.println("</script>");
		
	}//end printErr
	
}//class end

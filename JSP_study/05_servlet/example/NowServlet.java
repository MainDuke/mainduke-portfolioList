package example;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.*;

@WebServlet("/NowServlet")
public class NowServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	res.setContentType("text/html;charset=utf-8");
	
	PrintWriter out=res.getWriter();
	
	out.println("<html>");
	out.println("<head><title>����ð�</title></head>");
	out.println("<body>");
	out.println("����ð���");
	out.println(new Date());
	out.println("�Դϴ�.");
	out.println("</body></html>");
	
	}//do get end

}//class end

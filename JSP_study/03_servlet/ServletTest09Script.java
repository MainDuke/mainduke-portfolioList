

import java.io.*;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTest09Script
 */
@WebServlet("/ServletTest09Script")
public class ServletTest09Script extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		String col = req.getParameter("col");
		
		out.println("<html><head>");
		out.println("<script>");
		out.println("function bb(col){");
		out.println("alert(\"당신이 입력한 color :"+col+"\")");
		out.println("}");
		out.println("</script></head>");
		
		out.println("<body bgcolor='"+col+"' onLoad='bb()'>");
	
		out.println("</body>");
		out.println("</html>");
		
	}

}

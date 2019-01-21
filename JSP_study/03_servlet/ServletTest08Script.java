import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletTest08Script")
public class ServletTest08Script extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		PrintWriter out=res.getWriter();
		
		out.println("<html><head>");
		out.println("<script>");
		out.println("function aa(col){");
		out.println("document.bgColor=col.value");
		out.println("}");
		out.println("</script></head>");
		
		out.println("<body><form>");
				
		out.println("<input type=\"radio\" name=\"ra\" value=\"blue\" onClick=\"aa(this)\">blue<br>");
		out.println("<input type=\"radio\" name=\"ra\" value=\"green\" onClick=\"aa(this)\">green<br>");
		out.println("<input type=\"radio\" name=\"ra\" value=\"cyan\" onClick=\"aa(this)\">cyan<br>");
		out.println("<input type=\"radio\" name=\"ra\" value=\"yellow\" onClick=\"aa(this)\">yellow<br>");
				
		out.println("</form></body>");
		out.println("</html>");
		
		
		
	
	}//doget end


}//class end

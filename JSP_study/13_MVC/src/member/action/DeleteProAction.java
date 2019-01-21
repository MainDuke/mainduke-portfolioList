package member.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ch19.action.*;
import member.*;

public class DeleteProAction implements CommandAction{

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		 HttpSession session=request.getSession();
		 request.setCharacterEncoding("utf-8");
		 
	     String id=(String)session.getAttribute("memId");
	     String passwd=request.getParameter("passwd");
	     
	     LoginDao dao= LoginDao.getInstance();
	    // int check=dao.deleteMember(id, passwd);
		
	     
	     request.setAttribute("check", new Integer(dao.deleteMember(id, passwd)));
		
	     return "/member/DeletePro.jsp";
	}
}//class end

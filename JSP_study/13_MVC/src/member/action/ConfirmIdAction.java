package member.action;
import ch19.action.*;

import member.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmIdAction implements CommandAction {

	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

	
		String id=request.getParameter("id");
		LoginDao dao=LoginDao.getInstance();
		int check=dao.confirmId(id); //1: 사용중, -1 사용 가능
		
		
		//System.out.println(id);
		//System.out.println(check);

		
		request.setAttribute("id", new String(id));
		request.setAttribute("check", new Integer(check));
		
		return "/member/confirmId.jsp";
	}
	
}

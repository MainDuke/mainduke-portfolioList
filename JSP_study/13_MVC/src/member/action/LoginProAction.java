package member.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch19.action.*;
import member.LoginDao;

public class LoginProAction implements CommandAction {

	
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
	
		String id =request.getParameter("id");
		String passwd =request.getParameter("passwd");

		LoginDao dao= LoginDao.getInstance();
		int check=dao.userCheck(id, passwd);

		request.setAttribute("id", new String(id));
		request.setAttribute("check", new Integer(check));
		
		
		return "/member/LoginPro.jsp"; //해당 뷰를 리턴
	}//requestPro() end
	
	
}

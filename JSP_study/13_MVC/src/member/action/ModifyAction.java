package member.action;
import javax.servlet.http.*;


import member.*;
import ch19.action.*;


public class ModifyAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		return "/member/Modify.jsp";
	}


}

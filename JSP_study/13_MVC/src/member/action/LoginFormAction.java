package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch19.action.CommandAction;
import boardmysql.BoardDao;
import boardmysql.BoardDto;

public class LoginFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
				
		return "/ch19/content.jsp"; //�ش� �並 ����
	}//requestPro() end
	
	
}

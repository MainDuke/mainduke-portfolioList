package member.action;
import ch19.action.*;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.LoginDao;
import member.LoginDto;

public class ModifyFormAction implements CommandAction{

	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {
		
		HttpSession session=request.getSession();
		
		String id=(String)session.getAttribute("memId");
		
		LoginDao dao=LoginDao.getInstance();
		LoginDto dto= dao.getMember(id);
		
		
		request.setAttribute("id", dto.getId());
		request.setAttribute("name", dto.getName());
		request.setAttribute("jumin1", dto.getJumin1());
		request.setAttribute("jumin2", dto.getJumin2());
		request.setAttribute("email", dto.getEmail());
		request.setAttribute("zipcode", dto.getZipcode());
		request.setAttribute("addr", dto.getAddr());
		request.setAttribute("job", dto.getJob());
		request.setAttribute("blog", dto.getBlog());
		
		
		
		return "/member/ModifyForm.jsp";
	}
	
}

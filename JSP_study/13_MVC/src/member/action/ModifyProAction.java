package member.action;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.*;
import ch19.action.*;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModifyProAction implements CommandAction{
 @Override
	public String requestPro(HttpServletRequest request,
			HttpServletResponse response) throws Throwable {

	 HttpSession session=request.getSession();
	
	 request.setCharacterEncoding("utf-8");
	
	 LoginDao dao=LoginDao.getInstance();
	 String id = (String)session.getAttribute("memId");
		 
	 LoginDto dto= new LoginDto();
		
		dto.setId(id);
		dto.setPasswd(request.getParameter("passwd"));
		dto.setName(request.getParameter("name"));
		
		dto.setJumin1(request.getParameter("jumin1"));
		dto.setJumin2(request.getParameter("jumin2"));
		
		dto.setEmail(request.getParameter("email"));
		
		dto.setZipcode(request.getParameter("zipcode"));
		dto.setAddr(request.getParameter("addr"));
		
		dto.setJob(request.getParameter("job"));
		dto.setBlog(request.getParameter("blog"));
				
		dto.setRegdate(new Timestamp(System.currentTimeMillis()));
	   
		dao.updateMember(dto);
				 
		return "/member/ModifyPro.jsp";
	}
}